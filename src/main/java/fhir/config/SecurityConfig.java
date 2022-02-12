/**
 * This class extends the WebSecurityConfigurerAdapter which leads to methods,
 * to access some of SpringSecurity core objects, that tells SpringSecurity what to do.
 *
 *  Authors: Chizie Leitricia Moguem Foka, Dolvie Emma Kouekam, Gabriel Nathanael Da Gomez,
 *          Nasreddin Abdalla A El Alawani, Said Franck Dam Noujepme Njimoluh, Torben Heller
*/

package fhir.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("myUserDetailsService")
    @Autowired
    UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/**", "/css/**", "/images/**").permitAll()
                .antMatchers("/admin").hasAnyAuthority("ADMIN")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/templates/**").authenticated()
                .antMatchers("/uploadFile").authenticated()
                .antMatchers("/search").authenticated()
                .antMatchers("/patient").authenticated()
                .antMatchers("/observation").authenticated()
                .antMatchers("/diagnostic").authenticated()
                .antMatchers("/uploadMessage").authenticated()
                .antMatchers("/downloadFile/{fileId}").authenticated()
                
                .antMatchers("/error").authenticated()
                .antMatchers("/login*").permitAll()
                
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
