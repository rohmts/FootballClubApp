package com.rohmats.footballclubapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.rohmats.footballclubapp.R
import com.rohmats.footballclubapp.model.FootballClub
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.holder_list_footballclub.view.*
import org.jetbrains.anko.image

/**
 * Created by Rohmats on 16/10/18.
 */

class AdapterFootballClub(
    private val context: Context,
    private val footballClub: List<FootballClub>,
    private val listener: (FootballClub) -> Unit) : RecyclerView.Adapter<AdapterFootballClub.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.holder_list_footballclub, parent, false))

    override fun getItemCount(): Int = footballClub.size

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        holder.bindItem(footballClub[pos], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.findViewById<ImageView>(R.id.iv_image)
        private val name = view.findViewById<TextView>(R.id.tv_name)

        fun bindItem(footbalClub: FootballClub, listener: (FootballClub) -> Unit) {
            name.text = footbalClub.teamName
            footbalClub.image?.let { Picasso.get().load(it).into(image) }
            itemView.setOnClickListener {
                listener(footbalClub)
            }
        }
    }

}