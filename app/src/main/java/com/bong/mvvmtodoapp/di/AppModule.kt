package com.bong.mvvmtodoapp.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bong.mvvmtodoapp.data.TodoDatabase
import com.bong.mvvmtodoapp.data.TodoRepository
import com.bong.mvvmtodoapp.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application) : TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDatabase) : TodoRepository {
        return TodoRepositoryImpl(db.dao)
    }
}