package jp.ac.it_college.std.s22028.message_board.threads.create


import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.time.LocalDateTime
import java.util.*


object  DatabaseConnection{
    private const val DB_URL = "jdbc:mysql://localhost:3306/message_board"
    private const val DB_USER = "kotlin"
    private const val DB_PASSWORD = "spring"

    //    val eventTime : LocalDateTime = LocalDateTime.now()
//    val dbDate: Int = eventTime
    private val currentDateTime = LocalDateTime.now()
    val updatedAt = ThreadsDynamicSqlSupport.updatedAt


    object Main {
        @JvmStatic
        fun main(args: Array<String>) {
            val scanner = Scanner(System.`in`)
            print("スレッドのタイトル: ")
            val sctitle: String = scanner.nextLine()

            main(sctitle)

            scanner.close()
        }

    }


    fun getConnection(): Connection =
        DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)

    fun main(sctitle: String) {
        val sql = "INSERT INTO threads (id, user_Id, title, created_at, updated_at) VALUES (?, ?, ?, ?, ?)"

        try {
            DatabaseConnection.getConnection().use { conn ->
                conn.prepareStatement(sql).use { statement ->
                    // パラメータを設定します
//                    statement.setInt(1, )
//                    statement.setString(2, "John Doe")
                    statement.setString(3, "$sctitle")
                    statement.setObject(2, currentDateTime)
                    statement.setObject(5, updatedAt)


                    // SQL文を実行してデdbDateータを挿入します
                    val rowsInserted = statement.executeUpdate()
                    if (rowsInserted > 0) {
                        println("データが正常に挿入されました。")
                    }
                }
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }


}