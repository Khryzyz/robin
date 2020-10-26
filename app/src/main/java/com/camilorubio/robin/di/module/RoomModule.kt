package com.camilorubio.robin.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.camilorubio.robin.data.db.RobinDatabase
import com.camilorubio.robin.data.db.dao.EmployeeDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): RobinDatabase {
        return Room.databaseBuilder(context, RobinDatabase::class.java, "robin_database")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                })
                .build()
    }

    @Provides
    @Singleton
    fun provideEmployeeDao(robinRoomDatabase: RobinDatabase): EmployeeDao {
        return robinRoomDatabase.employeeDao()
    }

}