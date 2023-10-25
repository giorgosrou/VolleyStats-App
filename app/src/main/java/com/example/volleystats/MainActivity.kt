package com.example.volleystats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fm= supportFragmentManager
        val fragmentStatsType= fm.findFragmentById(R.id.stats_type)
        val fragmentPlayersView= fm.findFragmentById(R.id.players_view)
        val fragmentStatsView = fm.findFragmentById(R.id.stats_view)
        setUpFragments(fragmentStatsType, fragmentPlayersView, fragmentStatsView)
    }

    private fun setUpFragments(
        fragmentStatsType: Fragment?,
        fragmentPlayersView: Fragment?,
        fragmentStatsView: Fragment?
    ) {
        if (fragmentStatsType == null   && fragmentPlayersView == null && fragmentStatsView == null  ) {
            supportFragmentManager.beginTransaction()
                .add(R.id.stats_type, StatsTypeFragment())
                .add(R.id.players_view, PlayersFragmentList())
                .add(R.id.stats_view, StatsViewFragment())
                .commit()
        }
    }
}