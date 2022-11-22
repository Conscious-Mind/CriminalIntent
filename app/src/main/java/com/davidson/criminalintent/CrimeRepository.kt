package com.davidson.criminalintent

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.davidson.criminalintent.database.CrimeDatabase
import kotlinx.coroutines.flow.Flow
import java.util.*

private const val DATABASE_NAME = "crime_database"
private const val TAG = "CrimeRepository"

class CrimeRepository private constructor(context: Context) {

    private val database: CrimeDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            CrimeDatabase::class.java,
            DATABASE_NAME
        )
        .createFromAsset(DATABASE_NAME)
        .build()

    fun getCrimes(): Flow<List<Crime>> {
        Log.d(TAG, "Getting Crime Data from DB")
        return database.crimeDao().getCrimes()
    }

    suspend fun getCrime(id: UUID): Crime = database.crimeDao().getCrime(id)


    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return INSTANCE ?: throw IllegalStateException("Crime Repo must be Initialized")
        }
    }
}