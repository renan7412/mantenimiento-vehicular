package com.mantenimiento.vehicular.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    private final UserDetailsService userDetailsService;

    /* A través de este constructor se inyecta UserDetailService que se utiliza para cargar los detalles del usuario */
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // Se define el método BCryptPasswordEncoder con @Bean, para ser utilizado en la configuración de la seguridad */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /* En este método se define un bean SecurityFilterChain para configurar las reglas de seguridad HTTP  */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
               .authorizeHttpRequests((requests) -> requests
                       .requestMatchers("/registro", "/css/**", "/js/**").permitAll()
                       .anyRequest().authenticated()
               )
               .formLogin((form) -> form
                       .loginPage("/login")
                       .permitAll()
               )
               .logout((logout) -> logout
                       .permitAll()
               );
        return http.build();
    }

}
