package app.trian.tes.data.repository

import app.trian.tes.data.coroutines.DispatcherProvider
import app.trian.tes.data.models.Progress
import app.trian.tes.data.models.Question
import app.trian.tes.data.models.Test
import app.trian.tes.data.models.UserAnswer
import app.trian.tes.data.repository.design.ProgressRepository
import app.trian.tes.data.utils.utils.getTodayTimeStamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

class ProgressRepositoryImpl(
    private val dispatcherProvider: DispatcherProvider,
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) :ProgressRepository{
    companion object{
        const val PROGRESS_COLLECTION = "PROGRESS"
    }
    override suspend fun getListProgress(): Flow<List<Progress>> = flow {
        try {
            val user = firebaseAuth.currentUser ?: throw Exception("Anda belum masuk!")

            val data = firestore.collection(PROGRESS_COLLECTION)
                .whereEqualTo("userUID",user.uid)
                .get()
                .await()

            val finalData = data.documents.map {
                it.toObject(Progress::class.java)!!
            }
            emit(finalData)
        }catch (e:Exception){
            throw e
        }
    }.flowOn(dispatcherProvider.io())

    override suspend fun getListAnswered(testUID: String): Flow<List<UserAnswer>> = flow<List<UserAnswer>> {
        try {
            val data = firestore.collection(PROGRESS_COLLECTION)
                .document("userUID")
                .collection("1")
                .get()
                .await()
            val finalResult = data.documents.map {
                it.toObject(UserAnswer::class.java)!!
            }


            emit(finalResult)
        }catch (e:Exception){
            throw  e
        }
    }.flowOn(dispatcherProvider.io())

    override suspend fun saveAnswer(
        testUID: String,
        questionUID: String,
        answer: String,
        isCorrect: Boolean
    ): Flow<Pair<Boolean, String>> = flow<Pair<Boolean, String>> {

        try {
            val user = firebaseAuth.currentUser ?: throw Exception("Anda belum login!")

            val test = firestore.collection(TestRepositoryImpl.TEST_COLLECTION)
                .document(testUID)
                .get()
                .await()
                .toObject(Test::class.java)

            val progress = firestore.collection(PROGRESS_COLLECTION)
                .document()
                .set(Progress(
                    userUID = user.uid,
                    testUID = questionUID,
                    testName = test?.title!!,
                    createdAt = getTodayTimeStamp(),
                    updatedAt = getTodayTimeStamp(),
                    percentage = 0
                ), SetOptions.merge())


        }catch (e:Exception){

        }
    }.flowOn(dispatcherProvider.io())
}