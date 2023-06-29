package jp.ac.it_college.std.s22028.message_board.application.service

import jp.ac.it_college.std.s22028.message_board.domain.model.ThreadsWithMessageModel
import jp.ac.it_college.std.s22028.message_board.domain.repository.ThreadsRepository
import org.springframework.stereotype.Service

@Service
class ThreadsService (
    private val threadsRepository: ThreadsRepository
    ) {
    fun getList(): List<ThreadsWithMessageModel> {
        return threadsRepository.findAllWithMessage()
    }

    fun getDetail(threadId: Long): ThreadsWithMessageModel {
        return threadsRepository.findWithRental(threadId)
            ?: throw IllegalArgumentException("存在IDです。")
    }
}