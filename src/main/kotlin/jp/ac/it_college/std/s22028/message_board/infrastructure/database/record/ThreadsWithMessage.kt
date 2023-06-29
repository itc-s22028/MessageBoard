package jp.ac.it_college.std.s22028.message_board.infrastructure.database.record

import java.time.LocalDateTime

data class ThreadsWithMessage(
    var id: Long? = null,
    var userId: Int? = null,
    var threadId: Long? = null,
    var title: String? = null,
    var message: String? = null,
    var createdAt: LocalDateTime?= null,
    var updatedAt: LocalDateTime? = null,
)
//    var releaseDate: LocalDate? = null,
//    var messageDatetime : LocalDateTime? = null,
//    var returnDeadline : LocalDateTime? = null,

//data class BookWithRental(
//    var id: Long? = null,
//    var title: String? = null,
//    var author: String? = null,
//    var releaseDate: LocalDate? = null,
//    var userId: Long? = null,
//    var rentalDatetime : LocalDateTime? = null,
//    var returnDeadline : LocalDateTime? = null,
//)
