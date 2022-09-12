package app.trian.tes.data.repository.design

import app.trian.tes.data.models.Progress
import app.trian.tes.data.models.UserAnswer
import kotlinx.coroutines.flow.Flow

interface ProgressRepository {
    suspend fun getListProgress():Flow<List<Progress>>

    suspend fun getListAnswered(testUID:String):Flow<List<UserAnswer>>

    suspend fun saveAnswer(testUId:String,questionUID:String,answer:String,isCorrect:Boolean):Flow<Pair<Boolean,String>>

}