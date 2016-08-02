package com.github.verhoevenv.sc2soundboard

import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import org.jetbrains.anko.*


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUi().setContentView(this)
    }

}

class MainActivityUi : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            padding = dip(32)

            for ((img, sound) in listOf(
                    Pair(R.drawable.zealot, R.raw.sound_zealot_ready_1),
                    Pair(R.drawable.stalker, R.raw.sound_stalker_ready_1)
            )) {
                imageView() {
                    imageResource = img

                    onClick {
                        play(ctx, sound)
                    }
                }.lparams {
                    width = dip(200)
                    height = dip(200)
                }
            }
        }
    }

    private fun play(ctx: Context, resource: Int) {
        val mp = MediaPlayer.create(ctx, resource);
        mp.start()
    }
}