package app.trian.testapp.di


import android.content.Context
import app.trian.tes.data.coroutines.DefaultDispatcherProvider
import app.trian.tes.data.coroutines.DispatcherProvider
import app.trian.tes.data.repository.ProgressRepositoryImpl
import app.trian.tes.data.repository.TestRepositoryImpl
import app.trian.tes.data.repository.UserRepositoryImpl
import app.trian.tes.data.repository.design.ProgressRepository
import app.trian.tes.data.repository.design.TestRepository
import app.trian.tes.data.repository.design.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.functions.FirebaseFunctions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Persistence Class
 * Author PT Cexup Telemedicine
 * Created by Trian Damai
 * 01/09/2021
 */


@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    
    @Provides
    internal fun provideDispatcherProvider(): DispatcherProvider = DefaultDispatcherProvider()





    //firebase
    @Provides
    fun provideFirebaseFunctions()=FirebaseFunctions.getInstance()

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    //datasource
    //repo
    @Provides
    fun provideTestRepository(
        dispatcherProvider: DispatcherProvider,
        firestore: FirebaseFirestore,
        firebaseAuth: FirebaseAuth,
    ):TestRepository = TestRepositoryImpl(
        dispatcherProvider = dispatcherProvider,
        firestore = firestore,
        firebaseAuth = firebaseAuth
    )

    @Provides
    fun provideUserRepository(
        dispatcherProvider: DispatcherProvider,
        firestore: FirebaseFirestore,
        firebaseAuth: FirebaseAuth
    ):UserRepository = UserRepositoryImpl(
        dispatcherProvider = dispatcherProvider,
        firestore = firestore,
        firebaseAuth = firebaseAuth
    )

    @Provides
    fun provideProgressRepository(
        dispatcherProvider: DispatcherProvider,
        firestore: FirebaseFirestore,
        firebaseAuth: FirebaseAuth
    ):ProgressRepository = ProgressRepositoryImpl(
        dispatcherProvider = dispatcherProvider,
        firestore = firestore,
        firebaseAuth = firebaseAuth
    )


}