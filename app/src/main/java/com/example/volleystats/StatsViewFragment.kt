package com.example.volleystats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.w3c.dom.Text

class StatsViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val v = inflater.inflate(R.layout.fragment_stats_view, container, false)

        val team: Team= ViewModelProvider(requireActivity())[Team()::class.java]

        //Text Fields
        var efficiency : TextView = v.findViewById(R.id.textViewEfficiency)
        var kills : TextView = v.findViewById(R.id.textViewKills)
        var attempts : TextView = v.findViewById(R.id.textViewAttempts)
        var errors : TextView = v.findViewById(R.id.textViewErrors)

        team.team.observe(viewLifecycleOwner) {
            var stats : Stats = team.getTeamStats()
            efficiency.text = "Efficiency: " + stats.efficiency.toString()
            kills.text = "Kills: " + (stats.kills.toString())
            attempts.text = "Attempts: " + (stats.attempts.toString())
            errors.text = "Errors: " + (stats.errors.toString())
        }

        team.button_state.observe(viewLifecycleOwner){
            team.getTeamStats()
        }

        return v
    }
}