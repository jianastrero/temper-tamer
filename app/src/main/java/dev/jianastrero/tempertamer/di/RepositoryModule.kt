package dev.jianastrero.tempertamer.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.jianastrero.tempertamer.data.dao.LevelDao
import dev.jianastrero.tempertamer.data.repository.level.ILevelRepository
import dev.jianastrero.tempertamer.data.repository.level.LevelAPIRepository
import dev.jianastrero.tempertamer.data.repository.level.LevelDBRepository
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
    @Provides
    @Named("level_api")
    fun provideLevelAPIRepository(
        @ApplicationContext context: Context
    ): ILevelRepository = LevelAPIRepository(context)

    @Singleton
    @Provides
    @Named("level_db")
    fun provideLevelDBRepository(
        levelDao: LevelDao
    ): ILevelRepository = LevelDBRepository(levelDao)
}
