package com.kinsight.kinsightmultiplatform.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kinsight.kinsightmultiplatform.R
import kotlinx.android.synthetic.main.activity_idea.*
import kotlinx.android.synthetic.main.idea_item.*
import kotlinx.android.synthetic.main.idea_item.view.*
import java.math.RoundingMode
import java.text.DecimalFormat
import android.view.View.X
import android.widget.LinearLayout

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.animation.LinearInterpolator
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T







class IdeaActivity : FullScreenActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_idea)

        val startIntent = intent
        val companyName = startIntent.getStringExtra("ideaCompanyName")
        val ticker = startIntent.getStringExtra("ideaTicker")
        val alpha = startIntent.getDoubleExtra("ideaAlpha", 0.0)
        val createdBy = startIntent.getStringExtra("ideaCreatedBy")
        val targetPrice = startIntent.getStringExtra("ideaTargetPrice")

        ideaCompany.text = companyName
        ideaTicker.text = ticker

        val df = DecimalFormat("00.00")
        df.roundingMode = RoundingMode.CEILING
        val alphaFormatted = df.format(alpha)
        alphaValue.text = alphaFormatted

        if (alpha >= 4){
            alphaLabl.setImageResource(R.drawable.ic_fish_superhot)
       }
        else if (alpha.toDouble() >= 3 && alpha.toDouble() < 4){
            alphaLabl.setImageResource(R.drawable.ic_fish_blue)
        }
        else if (alpha.toDouble() >= 1 && alpha.toDouble() < 3){
            alphaLabl.setImageResource(R.drawable.ic_fish_red)
        }
        if (alpha.toDouble() < 1){
            alphaLabl.setImageResource(R.drawable.ic_fish_onfire)
        }

        alphaLabl.alpha = 0F
        alphaLabl.animate().apply {
            alpha(1f)
            start()
        }

    }
}