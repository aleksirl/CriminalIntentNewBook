package com.bignerdranch.android.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID


private const val TAG = "CrimeListViewModel"
class CrimeListViewModel: ViewModel() {
    val crimes = mutableListOf<Crime>()

    init {
        viewModelScope.launch {
            Log.d(TAG,"coroutine launched")
            crimes += loadCrime()
            Log.d(TAG, "Loading crimes finished")

        }
    }
    suspend fun loadCrime(): List<Crime>{
        val result = mutableListOf<Crime>()
        delay(500)
        for (i in 0 until 100){
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime #$i",
                date = Date(),
                isSolved = i % 2 == 0
            )
            result += crime
        }
        return result
    }
}