/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper

import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.createdAt
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.id
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.message
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.messages
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.threadId
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.updatedAt
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.userId
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.record.Messages
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.CountCompleter
import org.mybatis.dynamic.sql.util.kotlin.DeleteCompleter
import org.mybatis.dynamic.sql.util.kotlin.KotlinUpdateBuilder
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.UpdateCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.countFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.deleteFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insert
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insertMultiple
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectDistinct
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectOne
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.update
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface MessagesMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Messages>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="MessagesResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="thread_id", property="threadId", jdbcType=JdbcType.BIGINT)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Messages>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("MessagesResult")
    fun selectOne(selectStatement: SelectStatementProvider): Messages?
}

fun MessagesMapper.count(completer: CountCompleter) =
    countFrom(this::count, messages, completer)

fun MessagesMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, messages, completer)

fun MessagesMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun MessagesMapper.insert(row: Messages) =
    insert(this::insert, row, messages) {
        map(id) toProperty "id"
        map(userId) toProperty "userId"
        map(message) toProperty "message"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
        map(threadId) toProperty "threadId"
    }

fun MessagesMapper.insertMultiple(records: Collection<Messages>) =
    insertMultiple(this::insertMultiple, records, messages) {
        map(id) toProperty "id"
        map(userId) toProperty "userId"
        map(message) toProperty "message"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
        map(threadId) toProperty "threadId"
    }

fun MessagesMapper.insertMultiple(vararg records: Messages) =
    insertMultiple(records.toList())

fun MessagesMapper.insertSelective(row: Messages) =
    insert(this::insert, row, messages) {
        map(id).toPropertyWhenPresent("id", row::id)
        map(userId).toPropertyWhenPresent("userId", row::userId)
        map(message).toPropertyWhenPresent("message", row::message)
        map(createdAt).toPropertyWhenPresent("createdAt", row::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", row::updatedAt)
        map(threadId).toPropertyWhenPresent("threadId", row::threadId)
    }

private val columnList = listOf(id, userId, message, createdAt, updatedAt, threadId)

fun MessagesMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, messages, completer)

fun MessagesMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, messages, completer)

fun MessagesMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, messages, completer)

fun MessagesMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun MessagesMapper.update(completer: UpdateCompleter) =
    update(this::update, messages, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Messages) =
    apply {
        set(id) equalToOrNull row::id
        set(userId) equalToOrNull row::userId
        set(message) equalToOrNull row::message
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
        set(threadId) equalToOrNull row::threadId
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Messages) =
    apply {
        set(id) equalToWhenPresent row::id
        set(userId) equalToWhenPresent row::userId
        set(message) equalToWhenPresent row::message
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
        set(threadId) equalToWhenPresent row::threadId
    }

fun MessagesMapper.updateByPrimaryKey(row: Messages) =
    update {
        set(userId) equalToOrNull row::userId
        set(message) equalToOrNull row::message
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
        set(threadId) equalToOrNull row::threadId
        where { id isEqualTo row.id!! }
    }

fun MessagesMapper.updateByPrimaryKeySelective(row: Messages) =
    update {
        set(userId) equalToWhenPresent row::userId
        set(message) equalToWhenPresent row::message
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
        set(threadId) equalToWhenPresent row::threadId
        where { id isEqualTo row.id!! }
    }