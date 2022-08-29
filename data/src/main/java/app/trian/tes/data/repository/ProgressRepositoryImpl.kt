package app.trian.tes.data.repository

import app.trian.tes.data.coroutines.DispatcherProvider
import app.trian.tes.data.models.Progress
import app.trian.tes.data.models.UserAnswer
import app.trian.tes.data.repository.design.ProgressRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow

class ProgressRepositoryImpl(
    private val dispatcherProvider: DispatcherProvider,
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) :ProgressRepository{
    override suspend fun getListProgress(): Flow<List<Progress>> {
        TODO("Not yet implemented")
    }

    override suspend fun getListAnswered(testUID: String): Flow<List<UserAnswer>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveAnswer(
        questionUID: String,
        answer: String,
        isCorrect: Boolean
    ): Flow<Pair<Boolean, String>> {
        TODO("Not yet implemented")
    }
}