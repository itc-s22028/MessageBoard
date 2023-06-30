package jp.ac.it_college.std.s22028.message_board.presentation.form

import jp.ac.it_college.std.s22028.message_board.domain.model.ThreadsWithMessageModel
import java.time.LocalDateTime

data class GetThreadsListResponse(val threadsList: List<ThreadsInfo>)

data class ThreadsInfo(
    val id: Long,
//    val userId: Int,
    val title: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    constructor(model: ThreadsWithMessageModel) : this(
        model.threads.id,
//        model.threads.userId,
        model.threads.title,
        model.threads.createdAt,
        model.threads.updatedAt
    )
}

//data class GetThreadsDetailResponse(
//    val id: Long,
//    val userId: Int,
//    val threadId: Long,
//    val title: String,
//    val createdAt: LocalDateTime,
//    val updatedAt: LocalDateTime
//){
//    constructor(model: MessageWithThreadModel) : this(
//        model.threads.id,
//        model.threads.userId,
//        model.threads.id,
//        model.threads.title,
//        model.threads.createdAt,
//        model.threads.updatedAt,
//        model.message?.let { ThreadsInfo(it) }
//    )
//}
//
//data class ThreadsInfo(
//    val id: Long,
//    val userId: Id,
//    val threadId: Long,
//    val title: String,
//    val createdAt: LocalDateTime,
//    val updatedAt: LocalDateTime
//){
//    constructor(rental: MessageModel) : this(
//        rental.Id,
//        rental.usern,
//        rental.returnDeadline
//    )
//}

data class RegisterThreadsRequest(
    val id: Long,
    val userId: Int,
    val threadId: Long,
    val title: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)

data class UpdateThreadsRequest(
    val id: Long,
    val userId: Int,
    val threadId: Long,
    val title: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)

