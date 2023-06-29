package jp.ac.it_college.std.s22028.message_board.application.service

import jp.ac.it_college.std.s22028.message_board.domain.model.UserModel
import jp.ac.it_college.std.s22028.message_board.domain.repository.UserRepository
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.record.Users
import org.springframework.stereotype.Service

@Service
class AuthenticationService (
    private val userRepository: UserRepository
) {
    fun findUser(username: String): UserModel? = userRepository.find(username)
}