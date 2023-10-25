package com.example.volleystats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlayersFragmentList : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val v = inflater.inflate(R.layout.fragment_players, container, false)
        val team: Team= ViewModelProvider(requireActivity())[Team()::class.java]
        //val stateTest : TextView = v.findViewById(R.id.test_state)!!


        // Set up recyclerview
        val playerList: RecyclerView = v.findViewById(R.id.listTeamPlayers)
        playerList.layoutManager = LinearLayoutManager(activity)
        val mAdapter= TeamAdapter(team)
        playerList.adapter = mAdapter

        return v
    }

    private inner class TeamHolder(teamView: View, _team: Team ) :
        RecyclerView.ViewHolder(teamView),
        View.OnClickListener {
        private val playerInfoView: TextView
        private val team = _team

        init {
            playerInfoView = teamView.findViewById(R.id.player_info)
            teamView.setOnClickListener(this)
        }

        fun bind(player: Player, position: Int) {
            playerInfoView.text= player.fullName +  "\n" + "\n" + "Kills: " + player.playerStats.kills.toString() + "\n" + "Attempts: " + player.playerStats.attempts.toString() + "\n" + "Errors: " + player.playerStats.errors.toString() + "\n" +  "Efficiency: " + player.playerStats.efficiency.toString()
        }

        override fun onClick(v: View) {
            val pos: Int = adapterPosition
            var state: String = team.getButtonState().toString()

            if (state.equals("kill")) {
                team.updateKillStats(pos)
                playerInfoView.text = team.team.value?.get(pos)!!.fullName +  "\n" + "\n" + "Kills: " + team.team.value?.get(pos)!!.playerStats.kills.toString() + "\n" + "Attempts: " + team.team.value?.get(pos)!!.playerStats.attempts + "\n" + "Errors: " + team.team.value?.get(pos)!!.playerStats.errors + "\n" + "Efficiency: " + team.team.value?.get(pos)!!.playerStats.efficiency
                Toast.makeText(activity, "Kill updated for: " + team.team.value?.get(pos)!!.fullName, Toast.LENGTH_SHORT).show()
                team.button_state.value = ""
            }
            if (state.equals("continue")) {
                team.updateContinuesStats(pos)
                playerInfoView.text = team.team.value?.get(pos)!!.fullName + "\n" + "\n" + "Kills: " + team.team.value?.get(pos)!!.playerStats.kills.toString() + "\n" + "Attempts: " + team.team.value?.get(pos)!!.playerStats.attempts  + "\n" + "Errors: " + team.team.value?.get(pos)!!.playerStats.errors + "\n" +  "Efficiency: " + team.team.value?.get(pos)!!.playerStats.efficiency
                Toast.makeText(activity, "Continues updated for: " + team.team.value?.get(pos)!!.fullName, Toast.LENGTH_SHORT).show()
                team.button_state.value = ""
            }
            if (state.equals("error_unforced")) {
                team.updateErrorStats(pos)
                playerInfoView.text = team.team.value?.get(pos)!!.fullName + "\n" + "\n" + "Kills: " + team.team.value?.get(pos)!!.playerStats.kills.toString() + "\n"+ "Attempts: " + team.team.value?.get(pos)!!.playerStats.attempts + "\n" + "Errors: " + team.team.value?.get(pos)!!.playerStats.errors + "\n" + "Efficiency: " + team.team.value?.get(pos)!!.playerStats.efficiency
                Toast.makeText(activity, "Errors updated for: " + team.team.value?.get(pos)!!.fullName, Toast.LENGTH_SHORT).show()
                team.button_state.value = ""
            }
            if (state.equals("error_blocked")) {
                team.updateErrorStats(pos)
                playerInfoView.text = team.team.value?.get(pos)!!.fullName + "\n" + "\n" + "Kills: " + team.team.value?.get(pos)!!.playerStats.kills.toString() + "\n" + "Attempts: " + team.team.value?.get(pos)!!.playerStats.attempts + "\n" + "Errors: " + team.team.value?.get(pos)!!.playerStats.errors + "\n" +  "Efficiency: " + team.team.value?.get(pos)!!.playerStats.efficiency
                Toast.makeText(activity, "Blocks updated for: " + team.team.value?.get(pos)!!.fullName, Toast.LENGTH_SHORT).show()
                team.button_state.value = ""
            }
        }

    }

    private inner class TeamAdapter(_team: Team ) : RecyclerView.Adapter<TeamHolder>() {
        private val team = _team

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
            val layoutInflater = LayoutInflater.from(activity)
            val v = layoutInflater.inflate(R.layout.one_row, parent, false)

            return TeamHolder(v, team)
        }

        override fun onBindViewHolder(holder: TeamHolder, position: Int) {
            val item = team.team.value?.get(position)!!
            holder.bind(item, position)
        }

        override fun getItemCount(): Int {
            return team.size()
        }
    }
}


