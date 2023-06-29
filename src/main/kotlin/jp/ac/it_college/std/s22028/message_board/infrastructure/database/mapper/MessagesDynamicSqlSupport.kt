/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object MessagesDynamicSqlSupport {
    val messages = Messages()

    val id = messages.id

    val userId = messages.userId

    val message = messages.message

    val createdAt = messages.createdAt

    val updatedAt = messages.updatedAt

    val threadId = messages.threadId

    class Messages : AliasableSqlTable<Messages>("public.messages", ::Messages) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val userId = column<Int>(name = "user_id", jdbcType = JDBCType.INTEGER)

        val message = column<String>(name = "message", jdbcType = JDBCType.VARCHAR)

        val createdAt = column<LocalDateTime>(name = "created_at", jdbcType = JDBCType.TIMESTAMP)

        val updatedAt = column<LocalDateTime>(name = "updated_at", jdbcType = JDBCType.TIMESTAMP)

        val threadId = column<Long>(name = "thread_id", jdbcType = JDBCType.BIGINT)
    }
}