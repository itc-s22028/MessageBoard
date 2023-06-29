/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper

import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.createdAt
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.id
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.threads
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.title
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.updatedAt
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.userId
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.record.Threads
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
interface ThreadsMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Threads>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="ThreadsResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Threads>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("ThreadsResult")
    fun selectOne(selectStatement: SelectStatementProvider): Threads?
}

fun ThreadsMapper.count(completer: CountCompleter) =
    countFrom(this::count, threads, completer)

fun ThreadsMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, threads, completer)

fun ThreadsMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun ThreadsMapper.insert(row: Threads) =
    insert(this::insert, row, threads) {
        map(id) toProperty "id"
        map(userId) toProperty "userId"
        map(title) toProperty "title"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
    }

fun ThreadsMapper.insertMultiple(records: Collection<Threads>) =
    insertMultiple(this::insertMultiple, records, threads) {
        map(id) toProperty "id"
        map(userId) toProperty "userId"
        map(title) toProperty "title"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
    }

fun ThreadsMapper.insertMultiple(vararg records: Threads) =
    insertMultiple(records.toList())

fun ThreadsMapper.insertSelective(row: Threads) =
    insert(this::insert, row, threads) {
        map(id).toPropertyWhenPresent("id", row::id)
        map(userId).toPropertyWhenPresent("userId", row::userId)
        map(title).toPropertyWhenPresent("title", row::title)
        map(createdAt).toPropertyWhenPresent("createdAt", row::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", row::updatedAt)
    }

private val columnList = listOf(id, userId, title, createdAt, updatedAt)

fun ThreadsMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, threads, completer)

fun ThreadsMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, threads, completer)

fun ThreadsMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, threads, completer)

fun ThreadsMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun ThreadsMapper.update(completer: UpdateCompleter) =
    update(this::update, threads, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Threads) =
    apply {
        set(id) equalToOrNull row::id
        set(userId) equalToOrNull row::userId
        set(title) equalToOrNull row::title
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Threads) =
    apply {
        set(id) equalToWhenPresent row::id
        set(userId) equalToWhenPresent row::userId
        set(title) equalToWhenPresent row::title
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
    }

fun ThreadsMapper.updateByPrimaryKey(row: Threads) =
    update {
        set(userId) equalToOrNull row::userId
        set(title) equalToOrNull row::title
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
        where { id isEqualTo row.id!! }
    }

fun ThreadsMapper.updateByPrimaryKeySelective(row: Threads) =
    update {
        set(userId) equalToWhenPresent row::userId
        set(title) equalToWhenPresent row::title
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
        where { id isEqualTo row.id!! }
    }