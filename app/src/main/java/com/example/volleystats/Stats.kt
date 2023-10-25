package com.example.volleystats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Stats {
    var kills: Int = 0
    var attempts: Int = 0
    var continues: Int = 0
    var errors: Int = 0
    var efficiency: Double = 0.0


    fun increaseKills(){
        var tempKills = kills
        if (tempKills != null) {
            kills = tempKills + 1
        }
        attempts ++
        calculateEfficiency()
    }

    fun increaseContinues(){
        continues ++
        attempts ++
        calculateEfficiency()
    }

    fun increaseErrors(){
        errors ++
        attempts ++
        calculateEfficiency()
    }

    //Helper methods
    fun calculateEfficiency(){
        if (attempts == 0) {
            efficiency = 0.0
        } else {
            var result : Double = ((kills.toDouble()-errors.toDouble())/attempts.toDouble())
            efficiency = result
        }
    }

}