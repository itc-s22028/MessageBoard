package jp.ac.it_college.std.s22028.message_board.domain.model

import jp.ac.it_college.std.s22028.message_board.domain.enum.RoleType

data class UserModel(
    val id: Int,
    val username: String,
    val password: String,
)