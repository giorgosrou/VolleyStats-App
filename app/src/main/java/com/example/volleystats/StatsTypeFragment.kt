package com.example.volleystats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


class StatsTypeFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val v = inflater.inflate(R.layout.fragment_stats_type, container, false)

        val button_kill: Button = v.findViewById(R.id.kill_button)
        val button_continue: Button = v.findViewById(R.id.continue_button)
        val button_error_unforced: Button = v.findViewById(R.id.error_unforced_button)
        val button_error_blocked: Button = v.findViewById(R.id.error_blocked_button)

        val team: Team= ViewModelProvider(requireActivity())[Team()::class.java]

        button_kill.setOnClickListener{
            team.changeButtonState("kill")
            //val message= "State is: " + team.button_state.value
            //Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        }

        button_continue.setOnClickListener{
            team.changeButtonState("continue")
            //val message= "State is: " + team.button_state.value
            //Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        }

        button_error_unforced.setOnClickListener{
            team.changeButtonState("error_unforced")
            //val message= "State is: " + team.button_state.value
            //Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        }

        button_error_blocked.setOnClickListener{
            team.changeButtonState("error_blocked")
            //val message= "State is: " + team.button_state.value
            //Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        }


        return v
    }
}