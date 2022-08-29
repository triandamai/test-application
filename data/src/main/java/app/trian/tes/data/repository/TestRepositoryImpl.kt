package app.trian.tes.data.repository

import app.trian.tes.data.coroutines.DispatcherProvider
import app.trian.tes.data.models.Question
import app.trian.tes.data.models.Test
import app.trian.tes.data.repository.design.TestRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

class TestRepositoryImpl(
    private val dispatcherProvider: DispatcherProvider,
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
):TestRepository {
    companion object{
        const val TEST_COLLECTION = "TEST"
        const val QUESTION_COLLECTION = "QUESTION"
    }
    override suspend fun getListTest(): Flow<List<Test>> = flow{
        try {
            if(firebaseAuth.currentUser == null) throw Exception("Anda belum masuk!")
            val listTest = firestore.collection(TEST_COLLECTION)
                .get()
                .await()
            val finalList = listTest.documents.map {
                it.toObject(Test::class.java)!!
            }
            emit(finalList)
        }catch (e:Exception){
            throw e
        }
    }.flowOn(dispatcherProvider.io())

    override suspend fun getDetailTest(testUID: String): Flow<Test> = flow {
        try {
            val data = firestore.collection(TEST_COLLECTION)
                .document(testUID)
                .get()
                .await()
                .toObject(Test::class.java) ?: throw Exception("Gagal mengambil data!")

            emit(data)
        }catch (e:Exception){
            throw e
        }
    }.flowOn(dispatcherProvider.io())

    override suspend fun getQuestion(testUID: String, version: Int): Flow<List<Question>> = flow<List<Question>> {
        try {
            firebaseAuth.currentUser ?: throw Exception("Anda belum masuk!")

            val question = firestore.collection(QUESTION_COLLECTION)
                .whereEqualTo("testUID",testUID)
                .whereEqualTo("version",version)
                .get()
                .await()
            val final = question.documents.map {
                it.toObject(Question::class.java)!!
            }

            emit(final)
        }catch (e:Exception){
            throw e
        }
    }.flowOn(dispatcherProvider.io())
}