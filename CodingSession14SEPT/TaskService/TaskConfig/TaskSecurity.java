package CodingSession14SEPT.TaskService.TaskConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity

public class TaskSecurity {
    @Bean
    public UserDetailsService UserDetails(PasswordEncoder encoder){
        UserDetails admin = User.withUsername("Kelvin")
                .password(encoder.encode("Vision@2030"))
                .build();
        UserDetails user = User.withUsername("Kyle")
                .password(encoder.encode("1234"))
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
}
