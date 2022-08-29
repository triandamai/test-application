package app.trian.tes.data.repository

import app.trian.tes.data.coroutines.DispatcherProvider
import app.trian.tes.data.models.UserSession
import app.trian.tes.data.repository.design.UserRepository
import app.trian.tes.data.utils.utils.getTodayTimeStamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

class UserRepositoryImpl(
    private val dispatcherProvider: DispatcherProvider,
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
): UserRepository {
    override suspend fun signIn(email: String, password: String): Flow<Pair<Boolean, String>> = flow{
        try {
            val user = firebaseAuth.signInWithEmailAndPassword(
                email,
                password
            ).await()
            if(user.user != null){
                emit(Pair(true,"Login Berhasil!"))
            }else{
                emit(Pair(false,"Login Gagal!"))
            }
        }catch (e:Exception){
            throw e
        }
    }.flowOn(dispatcherProvider.io())

    override suspend fun register(
        email: String,
        password: String,
        name: String
    ): Flow<Pair<Boolean, String>> = flow {
        try {
            val user = firebaseAuth.createUserWithEmailAndPassword(email, password)
                .await()
            val session = UserSession(
                email=email,
                name=name,
                createdAt = getTodayTimeStamp(),
                updatedAt = getTodayTimeStamp(),
            )
            if(user.user != null){
                firestore.collection("USER")
                    .document()
                    .set(session)
                    .await()
                emit(Pair(true,"Berhasil mendaftar"))
            }else{
                emit(Pair(false,"Gagal mendaftar"))
            }


        }catch (e:Exception){
           throw e
        }
    }.flowOn(dispatcherProvider.io())

    override suspend fun resetPassword(email: String): Flow<Pair<Boolean, String>> = flow {
        try {
             firebaseAuth.sendPasswordResetEmail(email).await()
            emit(Pair(true,"Reset password sudah dikirim ke email anda!"))
        }catch (e:Exception){
           throw e
        }
    }.flowOn(dispatcherProvider.io())

    override suspend fun isUserLoggedIn(): Boolean {
        return firebaseAuth.currentUser != null
    }
}