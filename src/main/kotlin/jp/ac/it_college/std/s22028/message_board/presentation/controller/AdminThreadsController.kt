package jp.ac.it_college.std.s22028.message_board.presentation.controller

import jp.ac.it_college.std.s22028.message_board.application.service.AdminThreadsService
import jp.ac.it_college.std.s22028.message_board.domain.model.ThreadsModel
import jp.ac.it_college.std.s22028.message_board.domain.repository.ThreadsRepository
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.MessagesDynamicSqlSupport.threadId
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.ThreadsDynamicSqlSupport.threads
import jp.ac.it_college.std.s22028.message_board.presentation.form.RegisterThreadsRequest
import jp.ac.it_college.std.s22028.message_board.presentation.form.UpdateThreadsRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("admin/threads")
@CrossOrigin
class AdminThreadsController (
    private val adminThreadsService: AdminThreadsService
) {
    @PostMapping("/create")
    fun create(@RequestBody request: RegisterThreadsRequest) {
        adminThreadsService.create(
            request.run {
                ThreadsModel(id, userId, title, createdAt, updatedAt)
            }
        )
    }

    @PutMapping("/update")
    fun update(@RequestBody request: UpdateThreadsRequest) {
        request.run { adminThreadsService.update(id, userId, threadId, title, createdAt, updatedAt) }
    }
    @DeleteMapping("/delete/{book_id}")
    fun delete(@PathVariable("book_id") bookId: Long){
        adminThreadsService.delete(bookId)
    }
}