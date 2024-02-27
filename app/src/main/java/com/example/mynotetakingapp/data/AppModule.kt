package com.example.mynotetakingapp.data

import android.content.Context
import androidx.room.Room.databaseBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDao(
        noteDatabase: NoteDatabase
    ) = noteDatabase.noteDAO()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): NoteDatabase {
        return databaseBuilder(
            appContext,
            NoteDatabase::class.java,
            "ScoreDatabase"
        ).fallbackToDestructiveMigration().build()
    }

    /*    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "ALTER TABLE score_table "
                            + "ADD COLUMN name TEXT " + "REMOVE COLUMN id"
                )
            }
        }*/
}
