package com.psi.caffeine.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.psi.caffeine.model.Cafe
import com.psi.caffeine.model.Comment
import com.psi.caffeine.model.Menu
import com.psi.caffeine.model.User

@Database(entities = [User::class, Menu::class, Cafe::class, Comment::class], version = 1)
abstract class CaffeineDatabase: RoomDatabase() {
    abstract fun caffeineDao(): CaffeineDao
    
    companion object {
        @Volatile
        private var INSTANCE: CaffeineDatabase? = null
        
        @JvmStatic
        fun getInstance(context: Context): CaffeineDatabase {
            if (INSTANCE == null) {
                synchronized(CaffeineDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CaffeineDatabase::class.java,
                        "caffeine.db"
                    ).build()
                }
            }
            return INSTANCE as CaffeineDatabase
        }
    }
}