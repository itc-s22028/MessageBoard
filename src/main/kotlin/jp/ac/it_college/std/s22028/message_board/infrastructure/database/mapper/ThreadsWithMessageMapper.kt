//package jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper
//
//import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessageWithThreads
//import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.createdAt
//import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.id
//import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.message
//import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.threadId
//import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.updatedAt
//import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.userId
//import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.title
//import org.apache.ibatis.annotations.*
//import org.apache.ibatis.type.JdbcType
//import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
//import org.mybatis.dynamic.sql.util.SqlProviderAdapter
//
//@Mapper
//interface ThreadsWithMessageMapper {
//    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
//    @Results(id = "MessageWithThreadsResult", value = [
//        Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
//        Result(column = "thread_id", property = "threadId", jdbcType = JdbcType.BIGINT),
//        Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
//        Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
//        Result(column = "message", property = "message", jdbcType = JdbcType.VARCHAR),
//        Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
//        Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP)
//    ])
//    fun selectMany(selectStatement: SelectStatementProvider): List<MessageWithThreads>
//
//    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
//    @ResultMap("MessageWithThreadsResult")
//    fun selectOne(selectStatement: SelectStatementProvider): MessageWithThreads?
//}
//
//private val columnList = listOf(id, threadId, title, userId, message, createdAt, updatedAt)