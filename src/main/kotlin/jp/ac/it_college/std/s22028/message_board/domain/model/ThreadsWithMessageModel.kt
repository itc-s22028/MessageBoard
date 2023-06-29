package jp.ac.it_college.std.s22028.message_board.domain.model

data class ThreadsWithMessageModel (
    val threads: ThreadsModel,
    val message: MessageModel?,
    )