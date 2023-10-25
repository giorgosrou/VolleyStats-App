package com.example.volleystats
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class Team() : ViewModel(){
    val team: MutableLiveData<ArrayList<Player>> = MutableLiveData()
    val button_state : MutableLiveData<String> = MutableLiveData()

    init {
        team.value= ArrayList()
        button_state.value="beginning state"
        fillTeamA()
    }

    init {
        team.value= ArrayList()
        fillTeamB()
    }

    fun getTeamStats() : Stats{
        val teamStats : Stats = Stats()
        val _players = team.value
        var p_kills = 0
        var p_continues = 0
        var p_error = 0
        var p_attempts = 0
        var p_effeciency = 0.0

        if (_players != null) {
            for (p in _players){
                p_kills = p_kills + p.playerStats.kills
                p_continues = p_continues + p.playerStats.continues
                p_error = p_error + p.playerStats.errors
                p_attempts = p_kills + p_continues + p_error
            }
        }
        teamStats.kills = p_kills
        teamStats.continues = p_continues
        teamStats.errors = p_error
        teamStats.attempts = p_attempts
        teamStats.calculateEfficiency()
        return teamStats
    }

    fun changeButtonState(new_state : String){
        var temp = button_state.value
        temp = new_state
        button_state.value = temp
    }

    fun getButtonState(): String? {
        return button_state.value
    }

    //not used
    fun addPlayers(fullName: String, height: Double, jerseyNumber: Int) {
        val temp= team.value
        temp!!.add(Player(fullName, height, jerseyNumber))
        team.value= temp
    }

    fun updateKillStats(position: Int) {
        var temp = team.value
        if (temp != null) {
            temp.get(position).playerStats.increaseKills()
        }
        team.value = temp
        //team.value?.get(position)!!.playerStats.increaseKills()
    }

    fun updateErrorStats(position: Int) {
        var temp = team.value
        if (temp != null) {
            temp.get(position).playerStats.increaseErrors()
        }
        team.value = temp
    }

    fun updateContinuesStats(position: Int) {
        var temp = team.value
        if (temp != null) {
            temp.get(position).playerStats.increaseContinues()
        }
        team.value = temp
    }

    fun size(): Int {  return team.value!!.size  }

    private fun fillTeamA() {
        team.value!!.add(Player("Player 1", 1.78, 8))
        team.value!!.add(Player("Player 2", 1.79, 9))
        team.value!!.add(Player("Player 3", 1.76, 10))
        team.value!!.add(Player("Player 4", 1.70, 11))
        team.value!!.add(Player("Player 5", 1.69, 12))
        team.value!!.add(Player("Player 6", 1.88, 5))
        team.value!!.add(Player("Player 7", 1.78, 18))
        team.value!!.add(Player("Player 8", 1.83, 6))
        team.value!!.add(Player("Player 9", 1.85, 7))
        team.value!!.add(Player("Player 10", 1.74, 15))
        team.value!!.add(Player("Player 11", 1.77, 1))
        team.value!!.add(Player("Player 12", 1.72, 2))
        team.value!!.add(Player("Player 13", 1.90, 3))
        team.value!!.add(Player("Player 14", 1.68, 4))
    }

    private fun fillTeamB() {
        team.value!!.add(Player("Player 1", 1.78, 8))
        team.value!!.add(Player("Player 2", 1.79, 9))
        team.value!!.add(Player("Player 3", 1.76, 10))
        team.value!!.add(Player("Player 4", 1.70, 11))
        team.value!!.add(Player("Player 5", 1.69, 12))
        team.value!!.add(Player("Player 6", 1.88, 5))
        team.value!!.add(Player("Player 7", 1.78, 18))
        team.value!!.add(Player("Player 8", 1.83, 6))
        team.value!!.add(Player("Player 9", 1.85, 7))
        team.value!!.add(Player("Player 10", 1.74, 15))
        team.value!!.add(Player("Player 11", 1.77, 1))
        team.value!!.add(Player("Player 12", 1.72, 2))
        team.value!!.add(Player("Player 13", 1.90, 3))
        team.value!!.add(Player("Player 14", 1.68, 4))
    }

}