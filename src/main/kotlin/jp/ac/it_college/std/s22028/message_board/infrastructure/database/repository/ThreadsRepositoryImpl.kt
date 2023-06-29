package jp.ac.it_college.std.s22028.message_board.infrastructure.database.repository

import jp.ac.it_college.std.s22028.message_board.domain.model.MessageModel
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessageWithThreadsMapper
//import jp.ac.it_college.std.s22028.message_board.domain.model.MessageModel
import jp.ac.it_college.std.s22028.message_board.domain.model.ThreadsWithMessageModel
import jp.ac.it_college.std.s22028.message_board.domain.model.ThreadsModel
import jp.ac.it_college.std.s22028.message_board.domain.repository.ThreadsRepository
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.*
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.threadId
//import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.createdAt
//import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.title
//import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.updatedAt
//import jp.ac.it_college.std.s22028.message_board.infrastructure.database.record.Threads
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.record.Threads as RecordThreads
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.record.ThreadsWithMessage as RecordThreadsWithMessage
//import jp.ac.it_college.std.s22028.message_board.infrastructure.database.record.ThreadsWithMessage

import org.springframework.stereotype.Repository
//import java.time.LocalDate
import java.time.LocalDateTime

@Repository
class ThreadsRepositoryImpl (
//    private val messageWithThreadsMapper: ThreadsMapper,
    private val messageWithThreadsMapper: MessageWithThreadsMapper,
    private val ThreadsMapper: ThreadsMapper
//    private val MessagesMapper: MessagesMapper
) : ThreadsRepository {

    override fun findAllWithMessage(): List<ThreadsWithMessageModel> {
        return messageWithThreadsMapper.select { }.map(::toModel)
    }

    override fun findWithRental(id: Long): ThreadsWithMessageModel? {
        return messageWithThreadsMapper.selectByPrimaryKey(id).let(::toModel)
    }

    override fun create(threads: ThreadsModel) {
        ThreadsMapper.insert(toRecord(threads))

    }

    override fun update(
        id: Long,
        userId: Int?,
        threadId: Long,
        title: String?,
        createdAt: LocalDateTime?,
        updatedAt: LocalDateTime?
    ) {
        ThreadsMapper.updateByPrimaryKeySelective(RecordThreads(id, userId, title, createdAt, updatedAt))
    }

    override fun delete(id: Long) {
        ThreadsMapper.deleteByPrimaryKey(id)
    }


    private fun toModel(record: RecordThreadsWithMessage): ThreadsWithMessageModel {
        val thread = record.run {
            ThreadsModel(id!!, userId!!, title!!, createdAt!!, updatedAt!!)
        }
        val message = record.userId.let {
            with(record) {
                MessageModel(id!!, userId!!, message!!, threadId!!, createdAt!!, updatedAt!!)
            }
        }
        return ThreadsWithMessageModel(thread, message)
    }

    private fun toRecord(model: ThreadsModel): RecordThreads =
        model.run { RecordThreads(id, userId, title, createdAt, updatedAt) }
}
/*
val id: Long,
val threadId: Long,
val userId: Int,
val message: String,
val releaseDate: LocalDate,
val messageDatetime : LocalDateTime,
val returnDeadline : LocalDateTime,
 */