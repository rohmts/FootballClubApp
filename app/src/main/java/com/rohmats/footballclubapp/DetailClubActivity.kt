package com.rohmats.footballclubapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_club.*
import org.jetbrains.anko.*

/**
 * Created by Rohmats on 16/10/18.
 */

class DetailClubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailClubUI().setContentView(this)

        val clubImage = intent.getStringExtra("club_img")
        val clubName = intent.getStringExtra("club_name")
        val clubDesc = intent.getStringExtra("club_desc")

        Picasso.get().load(clubImage).into(iv_detail_image)
        tv_detail_name.text = clubName
        tv_detail_desc.text = clubDesc
    }

    class DetailClubUI : AnkoComponent<DetailClubActivity> {
        override fun createView(ui: AnkoContext<DetailClubActivity>) = with(ui) {
            verticalLayout {
                gravity = Gravity.CENTER_HORIZONTAL

                imageView {
                    id = R.id.iv_detail_image
                    this.scaleType = ImageView.ScaleType.CENTER_CROP
                }.lparams(width = dip(90), height = dip(90)) {
                    topMargin = dip(8)
                }

                textView {
                    id = R.id.tv_detail_name
                    hint = R.string.hint_team_name.toString()
                    textColor = Color.BLACK
                    textSize = 18f
                    this.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams() {
                    topMargin = dip(8)
                }

                textView {
                    id = R.id.tv_detail_desc
                    hint = R.string.hint_desciption.toString()
                    textColor = Color.BLACK
                }.lparams {
                    topMargin = dip(16)
                    leftMargin = dip(8)
                    rightMargin = dip(8)
                }
            }
        }

    }
}
