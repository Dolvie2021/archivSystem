/**
 * This class implements the UserDetailsService to provide our own user service
 *
 * Methods:
 *      loadUserByUsername
 *      findByUserName
 *      userExists
 *
 * Authors: Chizie Leitricia Moguem Foka, Dolvie Emma Kouekam, Gabriel Nathanael Da Gomez,
 *         Nasreddin Abdalla A El Alawani, Said Franck Dam Noujepme Njimoluh, Torben Heller
 *      */
package fhir.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fhir.models.MyUserDetails;
import fhir.models.User;
import fhir.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    /**
     * This method, to load the user details instance using the username
     *
     * @param userName : String, that get the username to prove
     * @return user details instance from the database
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();
    }

    /**
     * This method is to find the username, that will be checked
     *
     * @param userName : String, that has the must be check username
     * @return user details instance from the checked username
     */
    @Transactional
    public Optional<User> findByUserName(String userName){
        return userRepository.findByUsername(userName);
    }

    /**
     * This method is to prove if the new username is already exists in database or not
     *
     * @param userName : String, that has the must be check username
     * @return true or false
     */
    public boolean userExists(String userName){
        return findByUserName(userName).isPresent();
    }

}
