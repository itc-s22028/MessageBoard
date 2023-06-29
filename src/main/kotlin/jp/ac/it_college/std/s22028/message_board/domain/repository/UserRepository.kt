package jp.ac.it_college.std.s22028.message_board.domain.repository

import jp.ac.it_college.std.s22028.message_board.domain.model.UserModel
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.record.Users
import javax.print.attribute.standard.RequestingUserName

interface UserRepository {
    fun find(username: String): UserModel?

//    fun find(id: Long): UserModel?
}