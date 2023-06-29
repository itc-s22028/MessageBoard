package jp.ac.it_college.std.s22028.message_board.presentation.controller

import jp.ac.it_college.std.s22028.message_board.application.service.ThreadsService
//import jp.ac.it_college.std.s22028.message_board.presentation.form.GetThreadsDetailResponse
import jp.ac.it_college.std.s22028.message_board.presentation.form.GetThreadsListResponse
import jp.ac.it_college.std.s22028.message_board.presentation.form.ThreadsInfo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("threads")
@CrossOrigin
class ThreadsController (
    private val threadsService: ThreadsService
) {
    @GetMapping("/list")
    fun getList(): GetThreadsListResponse {
        val threadList = threadsService.getList().map {
            ThreadsInfo(it)
        }
        return GetThreadsListResponse(threadList)
    }

//    @GetMapping("/detail/{thread_id}")
//    fun getDetail(@PathVariable("thread_id") threadId: Long): GetThreadsDetailResponse {
//        val thread = threadsService.getDetail(bookId)
//        return GetThreadsDetailResponse(thread)
//    }
}

