package jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper

import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.createdAt
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.id
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.message
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.messages
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.threadId
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.updatedAt
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.userId
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.threads
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.title
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.record.ThreadsWithMessage
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider


@Mapper
interface MessageWithThreadsMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(id = "MessageWithThreadsResult", value = [
        Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
        Result(column = "thread_id", property = "threadId", jdbcType = JdbcType.BIGINT),
        Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
        Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
        Result(column = "message", property = "message", jdbcType = JdbcType.VARCHAR),
        Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
        Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<ThreadsWithMessage>

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("MessageWithThreadsResult")
    fun selectOne(selectStatement: SelectStatementProvider): ThreadsWithMessage
}

private val columnList = listOf(id, threadId, title, userId, message, createdAt, updatedAt)


fun MessageWithThreadsMapper.select(completer: SelectCompleter) =
    select(columnList) {
        from(threads,"t")
        leftJoin(messages,"m") {
            on(threads.id) equalTo messages.threadId
        }
        run(completer)
    }.run(this::selectMany)


fun MessageWithThreadsMapper.selectByPrimaryKey(id_: Long) =
    select(columnList) {
        from(threads,"t")
        leftJoin(messages,"m") {
            on(threads.id) equalTo messages.threadId
        }
        where {
            id isEqualTo id_
        }
    }.run(this::selectOne)