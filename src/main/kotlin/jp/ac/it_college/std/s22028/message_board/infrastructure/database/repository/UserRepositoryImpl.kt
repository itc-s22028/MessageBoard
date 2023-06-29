package jp.ac.it_college.std.s22028.message_board.infrastructure.database.repository

import jp.ac.it_college.std.s22028.message_board.domain.model.UserModel
import jp.ac.it_college.std.s22028.message_board.domain.repository.UserRepository
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.UsersDynamicSqlSupport
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.UsersMapper
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.mapper.selectOne
import jp.ac.it_college.std.s22028.message_board.infrastructure.database.record.Users
import org.springframework.stereotype.Repository

//@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class UserRepositoryImpl (
    private val mapper: UsersMapper
) : UserRepository {
    override fun find(username: String): UserModel? {
        val record = mapper.selectOne {
            where {
                UsersDynamicSqlSupport.username isEqualTo username
            }
        }
        return record?.let { toModel(it) }
    }


    private fun toModel(record: Users): UserModel = record.run {
        UserModel(id!!, username!!, password!!)
    }
}
//    private fun toModel(record: Users): Users {
//        return Users(
//            record.id!!,
//            record.username!!,
//            record.password!!
//        )
//    }
//}