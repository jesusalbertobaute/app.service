package app.auth.service.configuration;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import java.util.Arrays;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	private static final String[] WHITE_LIST_URL = {
		"/h2-console/**",
		"/auth/authenticate"
	};

	private static final String[] CSRF_LIST_IGNORING_URL = {
		"/user/register"
	};

	private final JwtAuthenticationFilter jwtAuthFilter;
 

    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		String[] crfIgnoringList= Stream.concat(Arrays.stream(WHITE_LIST_URL), Arrays.stream(CSRF_LIST_IGNORING_URL)).toArray(String[]::new);
		
		http
            .csrf(csrf->csrf.ignoringRequestMatchers(crfIgnoringList))
            //.csrf(AbstractHttpConfigurer::disable)
            .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers(WHITE_LIST_URL).permitAll()
				//.requestMatchers("/","/**").permitAll()
				.anyRequest().authenticated()
			)
			.sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
			.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .logout(logout ->
                        logout.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                );

		return http.build();
	}
}
