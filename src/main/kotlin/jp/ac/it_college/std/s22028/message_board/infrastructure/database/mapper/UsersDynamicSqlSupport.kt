/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object UsersDynamicSqlSupport {
    val users = Users()

    val id = users.id

    val username = users.username

    val password = users.password

    class Users : AliasableSqlTable<Users>("public.users", ::Users) {
        val id = column<Int>(name = "id", jdbcType = JDBCType.INTEGER)

        val username = column<String>(name = "username", jdbcType = JDBCType.VARCHAR)

        val password = column<String>(name = "password", jdbcType = JDBCType.VARCHAR)
    }
}