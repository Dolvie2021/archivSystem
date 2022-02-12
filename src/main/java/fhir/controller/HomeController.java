/**
 * This class contains methods to control the flow of the data
 * in Login, Home, Admin and Update pages
 *
 * Authors: Chizie Leitricia Moguem Foka, Dolvie Emma Kouekam, Gabriel Nathanael Da Gomez,
 *          Nasreddin Abdalla A El Alawani, Said Franck Dam Noujepme Njimoluh, Torben Heller
 */
package fhir.controller;

import fhir.models.User;
import fhir.repository.UserRepository;
import fhir.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class HomeController {
    private final MyUserDetailsService myUserDetailsService;

    @Autowired
    public HomeController(MyUserDetailsService myUserDetailsService){
        this.myUserDetailsService = myUserDetailsService;
    }

    @Autowired
    UserRepository userRepo;
    
    /**
     * GetMapping method, that gets the user to return to the home page
     * @return home page
     */
    @GetMapping("/")
    public String index(){
        return "home";
    }
    
    /**
     * GetMapping method, that shows the admin page,
     * which contains the list of all users from database and a registration form for adding a new user
     *
     * @param model: Model can supply attributes used for rendering views
     * @param users: Entity user class
     * @return admin page
     */
    @GetMapping("/admin")
    public String admin(@ModelAttribute User users, Model model){
        model.addAttribute("userslist", userRepo.findAll());
        model.addAttribute("users", users);
        return "admin";
    }

    /**
     * PostMapping method, that adds and saves the new user, that has been added.
     * proves if the new username is already in database and gives an error message if there is one exist
     * if the input contains no error then the new user will be save in database
     *
     * @param users : Entity user class
     * @param bindingResult: used for parameter verification
     * @param ra : A specialization of the Model interface that provides our own message in a redirect scenario
     * @param model : Model can supply attributes used for rendering views
     * @return home page if successfully adding a new user
     */
    @PostMapping("/admin")
    public String processRegister(@Valid User users, BindingResult bindingResult, RedirectAttributes ra, Model model) {
        //Check if username is already exist
        if(myUserDetailsService.userExists(users.getUsername())){
            bindingResult.addError(new FieldError("users", "username", "Username is already exist"));
        }

        //Check if there is an error in input by user details
        //This code will accept the errors message in the annotations we add to the entity class
        if(bindingResult.hasErrors()){
            model.addAttribute("userslist", userRepo.findAll());
            return "admin";
        }
        //message when successfully adding a new user
        ra.addFlashAttribute("success_message", "Success! Neuer User ist hinzugefügt");
        //save the new user in database
        userRepo.save(users);
        return "redirect:/";
    }

    /**
     * GetMappping method, that gets all details from the chosen user
     *
     * @param id : the id from the chosen user
     * @param model : Model can supply attributes used for rendering views
     * @return edit page
     */
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable(value = "id") int id, Model model){
        //get the details from the chosen user
        User users = userRepo.getById(id);

        model.addAttribute("users", users);
        return "edit";
    }

    /**
     * PostMapping method, that saves updated user details
     * check if there is any error in the updating process
     *
     * @param id: the id from the chosen user
     * @param bindingResult : used for parameter verification
     * @param ra: A specialization of the Model interface that provides our own message in a redirect scenario
     * @param users: Entity user class
     * @return redirect to admin page
     */
    @PostMapping("/saveUser/{id}" )
    public String saveUser(@Valid @ModelAttribute("users") @RequestBody User users, BindingResult bindingResult, @PathVariable(value = "id") int id, RedirectAttributes ra){
        User userstemp = userRepo.getById(id);
        String username = userstemp.getUsername();
        //Check if username is already exist
        if(myUserDetailsService.userExists(users.getUsername()) && !users.getUsername().equals(username)){
            bindingResult.addError(new FieldError("users", "username", "Username is already exist"));
        }

        //Check if there is an error in input by user details
        if(bindingResult.hasErrors()){
            return "edit";
        }
        //message when successfully updating the user
        ra.addFlashAttribute("update_success","User details have been updated");

        //save the new information from user in database
        userRepo.save(users);

        return "redirect:/admin";
    }
    
    /**
     * GetMapping method, that gets the login page
     * @return login page
     */
    @GetMapping("/login")
    public String login(){ return "login";}
    
    /**
     * GetMapping method, that redirects to login page
     *
     * @return login page with success logout message
     */
    @GetMapping ("/logout")
    public String logout(){
        return "redirect:/login?logout";
    }
    
    /**
     * GetMapping method, that shows the upload page
     *
     * @return upload page
     */
    @GetMapping("/newdatenhochladen")
    public String newdaten(){
        return "newdatenhochladen";
    }
/*
    @GetMapping ("/archivedfiles")
    public String archivedfiles(){
        return "archivedfiles";
    }*/
}
