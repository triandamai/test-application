package app.trian.tes.data.repository.design

import kotlinx.coroutines.flow.Flow


interface UserRepository {
    suspend fun signIn(email:String, password:String):Flow<Pair<Boolean,String>>

    suspend fun register(email:String,password:String,name:String):Flow<Pair<Boolean,String>>

    suspend fun resetPassword(email:String):Flow<Pair<Boolean,String>>

    suspend fun isUserLoggedIn():Boolean
}