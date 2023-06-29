package jp.ac.it_college.std.s22028.message_board.presentation.config


import jp.ac.it_college.std.s22028.message_board.application.service.AuthenticationService
import jp.ac.it_college.std.s22028.message_board.application.service.security.MessageBoardUserDetailsService
import jp.ac.it_college.std.s22028.message_board.domain.enum.RoleType
import jp.ac.it_college.std.s22028.message_board.presentation.handler.message_boardAccessDeniedHandler
import jp.ac.it_college.std.s22028.message_board.presentation.handler.message_boardAuthenticationEntryPoint
import jp.ac.it_college.std.s22028.message_board.presentation.handler.message_boardAuthenticationFailureHandler
import jp.ac.it_college.std.s22028.message_board.presentation.handler.message_boardAuthenticationSuccessHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val authenticationService: AuthenticationService
) {

    @Bean
    @Order(1)
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeHttpRequests {
                authorize("/login", permitAll)
                authorize("/admin/**", hasAuthority(RoleType.ADMIN.toString()))
                authorize(anyRequest, authenticated)
            }
            formLogin {
                loginProcessingUrl = "/login"
                authenticationSuccessHandler = message_boardAuthenticationSuccessHandler()
                authenticationFailureHandler = message_boardAuthenticationFailureHandler()
            }
            csrf {
                disable()
            }
            exceptionHandling {
                authenticationEntryPoint = message_boardAuthenticationEntryPoint()
                accessDeniedHandler = message_boardAccessDeniedHandler()
            }
            cors { }
        }

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun userDetailsService(): UserDetailsService = MessageBoardUserDetailsService(authenticationService)

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val config = CorsConfiguration().apply {
            allowedOrigins = listOf(
                "http://localhost:5173"
            )
            allowedMethods = listOf("GET", "POST", "PATCH")
            allowCredentials = true
        }

        val source = UrlBasedCorsConfigurationSource().apply {
            registerCorsConfiguration("/**", config)
        }
        return source
    }
}