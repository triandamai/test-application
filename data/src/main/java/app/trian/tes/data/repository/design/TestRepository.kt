package app.trian.tes.data.repository.design

import app.trian.tes.data.models.Question
import app.trian.tes.data.models.Test
import kotlinx.coroutines.flow.Flow

interface TestRepository {
    suspend fun getListTest():Flow<List<Test>>

    suspend fun getDetailTest(testUID:String):Flow<Test>

    suspend fun getQuestion(testUID: String,version:Int):Flow<List<Question>>


}