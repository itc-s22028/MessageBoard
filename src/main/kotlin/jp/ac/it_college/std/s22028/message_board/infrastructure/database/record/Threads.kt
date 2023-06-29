/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s22028.message_board.infrastructure.database.record

import java.time.LocalDateTime

data class Threads(
    var id: Long? = null,
    var userId: Int? = null,
    var title: String? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)