package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/webjars/**");
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests( authorizeRequests ->
                authorizeRequests.anyRequest().authenticated()
        )
                .oauth2Login(
                        oauth2login -> oauth2login.loginPage("/oauth2/authorization/messaging-client-oidc")
                )
                .oauth2Client(Customizer.withDefaults());
        return httpSecurity.build();
    }

}
