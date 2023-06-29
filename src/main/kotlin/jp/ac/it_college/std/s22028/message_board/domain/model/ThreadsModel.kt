package jp.ac.it_college.std.s22028.message_board.domain.model

import java.time.LocalDateTime

data class ThreadsModel(
    val id: Long,
    val userId: Int,
    val title: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)