package com.example.crud_mvvm.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.crud_mvvm.data.TodoDatabase
import com.example.crud_mvvm.data.TodoRepository
import com.example.crud_mvvm.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//defines dependecies and lifetime
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: TodoDatabase) : TodoRepository {
        return TodoRepositoryImpl(db.dao)
    }

}