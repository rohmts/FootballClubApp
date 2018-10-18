package com.rohmats.footballclubapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.rohmats.footballclubapp.adapter.AdapterFootballClub
import com.rohmats.footballclubapp.model.FootballClub
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

/**
 * Created by Rohmats on 16/10/18.
 */

class MainActivity : AppCompatActivity() {

    private var footballClub: MutableList<FootballClub> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_footballclub_list)

        setData()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterFootballClub(this, footballClub) {
            startActivity(intentFor<DetailClubActivity>("club_img" to it.image.toString(), "club_name" to it.teamName, "club_desc" to it.description))
        }
    }

    fun setData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val description = resources.getStringArray(R.array.club_desc)
        footballClub.clear()
        for (i in name.indices) {
            footballClub.add(FootballClub(name[i], image.getResourceId(i, 0), description[i]))
        }
        image.recycle()
        toast("Data set successfully")
    }
}
