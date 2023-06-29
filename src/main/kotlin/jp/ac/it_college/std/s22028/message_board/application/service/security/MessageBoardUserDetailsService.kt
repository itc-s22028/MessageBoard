package jp.ac.it_college.std.s22028.message_board.application.service.security

import jp.ac.it_college.std.s22028.message_board.application.service.AuthenticationService
import jp.ac.it_college.std.s22028.message_board.domain.enum.RoleType
import jp.ac.it_college.std.s22028.message_board.domain.model.UserModel
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class MessageBoardUserDetailsService (
    private val authenticationService: AuthenticationService
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        username ?: throw UsernameNotFoundException("username が空です")
        val user = authenticationService.findUser(username)
            ?: throw UsernameNotFoundException("ユーザーまたはパスワードが違います。")
        return message_boardUserdetails(user)
    }
    data class message_boardUserdetails(
        val id: Int,
        val email: String,
        val pass: String,
    ) : UserDetails {
        constructor(user: UserModel): this(user.id, user.username, user.password)

        override fun getAuthorities(): MutableCollection<out GrantedAuthority>
                = AuthorityUtils.createAuthorityList()

        override fun getPassword(): String = pass

        override fun getUsername(): String = email

        override fun isAccountNonExpired(): Boolean = true

        override fun isAccountNonLocked(): Boolean = true

        override fun isCredentialsNonExpired(): Boolean = true

        override fun isEnabled(): Boolean = true
    }
}