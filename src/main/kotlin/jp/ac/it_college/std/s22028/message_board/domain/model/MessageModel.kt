package jp.ac.it_college.std.s22028.message_board.domain.model

import org.mybatis.dynamic.sql.SqlColumn
import java.time.LocalDateTime

data class MessageModel(
    val id: Long,
    val userId: Int,
    val message: String,
    val threadId: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    )