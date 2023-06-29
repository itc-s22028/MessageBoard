package jp.ac.it_college.std.s22028.message_board.application.service

import jp.ac.it_college.std.s22028.message_board.domain.model.ThreadsModel
import jp.ac.it_college.std.s22028.message_board.domain.repository.ThreadsRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import kotlin.concurrent.thread

@Service
class AdminThreadsService(
private val threadsRepository: ThreadsRepository
) {
    @Transactional
    fun create(threads: ThreadsModel) {
        threadsRepository.findWithRental(threads.id)?.let {
            throw IllegalArgumentException("ダブリID: ${threads.id}")
        }
        threadsRepository.create(threads)
    }

    @Transactional
    fun update(id: Long, userId: Int?,  threadId: Long, title: String?, createdAt: LocalDateTime?, updatedAt: LocalDateTime?) {
        threadsRepository.findWithRental(threadId)
            ?: throw IllegalArgumentException("存在しないID: $threadId")
        threadsRepository.update(id, userId, threadId, title, createdAt, updatedAt)
    }

    @Transactional
    fun delete(bookId: Long) {
        threadsRepository.findWithRental(bookId)
            ?: throw IllegalArgumentException("存在しない書籍ID: $bookId")
        threadsRepository.delete(bookId)
    }
}

