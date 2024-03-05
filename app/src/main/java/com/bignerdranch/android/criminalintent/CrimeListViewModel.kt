package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import java.util.Date
import java.util.UUID

class CrimeListViewModel : ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        for (i in 0 until 100) {
            if(i % 3 == 0 || i % 7 == 0){
                val crime = Crime(
                    id = UUID.randomUUID(),
                    title ="Crime #$i",
                    date = Date(),
                    isSolved = i % 2 == 0,
                    viewType = 1
                )
                crimes += crime
            }
            else{
                val crime = Crime(
                    id = UUID.randomUUID(),
                    title ="Serious Crime #$i",
                    date = Date(),
                    isSolved = i % 2 == 0,
                    viewType = 2
                )
                crimes += crime
            }
        }
    }
}
