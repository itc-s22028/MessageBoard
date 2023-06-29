/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object ThreadsDynamicSqlSupport {
    val threads = Threads()

    val id = threads.id

    val userId = threads.userId

    val title = threads.title

    val createdAt = threads.createdAt

    val updatedAt = threads.updatedAt

    class Threads : AliasableSqlTable<Threads>("public.threads", ::Threads) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val userId = column<Int>(name = "user_id", jdbcType = JDBCType.INTEGER)

        val title = column<String>(name = "title", jdbcType = JDBCType.VARCHAR)

        val createdAt = column<LocalDateTime>(name = "created_at", jdbcType = JDBCType.TIMESTAMP)

        val updatedAt = column<LocalDateTime>(name = "updated_at", jdbcType = JDBCType.TIMESTAMP)
    }
}