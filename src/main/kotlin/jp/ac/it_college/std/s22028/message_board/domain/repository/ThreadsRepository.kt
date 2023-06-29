package jp.ac.it_college.std.s22028.message_board.domain.repository

import jp.ac.it_college.std.s22028.message_board.domain.model.ThreadsModel
import jp.ac.it_college.std.s22028.message_board.domain.model.ThreadsWithMessageModel
import java.time.LocalDateTime

interface ThreadsRepository{

    fun findAllWithMessage(): List<ThreadsWithMessageModel>

    fun findWithRental(id: Long): ThreadsWithMessageModel?

    fun create(threads: ThreadsModel)

    fun update(id: Long, userId: Int?, threadId: Long, title: String?, createdAt: LocalDateTime?, updatedAt: LocalDateTime?)

    fun delete(id: Long)
}