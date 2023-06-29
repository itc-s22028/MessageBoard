package jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper

import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.id
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.title
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.userId
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.createdAt
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.updatedAt


private val columnList = listOf(
    id,
    title,
    userId,
    createdAt,
    updatedAt,
)



//fun ThreadsWithMapper.select(completer: SelectCompleter) =
//    select(columnList) {
//        from(book,"b")
//        leftJoin(rental,"r") {
//            on(book.id) equalTo rental.bookId
//        }
//        run(completer)
//    }.run(this::selectMany)
//
//fun ThreadsWithMapper.selectByPrimaryKey(id_: Long) =
//    select(columnList) {
//        from(book,"b")
//        leftJoin(rental,"r") {
//            on(book.id) equalTo rental.bookId
//        }
//        where {
//            id isEqualTo id_
//        }
//    }.run(this::selectOne)
