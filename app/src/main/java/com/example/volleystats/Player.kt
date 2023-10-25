package com.example.volleystats

class Player(fullName: String,height: Double, jerseyNumber: Int) {
    var fullName: String
    var height: Double
    var jerseyNumber: Int
    var playerStats: Stats

    init {
        this.fullName= fullName
        this.height= height
        this.jerseyNumber = jerseyNumber
        this.playerStats = Stats()

    }

    override fun toString(): String {
        return oneLine()
    }

    private fun oneLine(): String {
        return "$fullName: height: $height jersey number: $jerseyNumber"
    }
}