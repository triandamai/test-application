package app.trian.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModuleTest {
    @Provides
    @Named("test_db")
    fun provideInMemoryDb(@ApplicationContext context: Context) = ""
}