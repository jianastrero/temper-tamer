package dev.jianastrero.tempertamer.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.jianastrero.tempertamer.dao.LevelDao
import dev.jianastrero.tempertamer.db.AppDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "temper_tamer.db"
        ).build()

    @Singleton
    @Provides
    fun provideLevelDao(
        database: AppDatabase
    ): LevelDao = database.levelDao()
}
