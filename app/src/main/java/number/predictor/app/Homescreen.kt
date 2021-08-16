package number.predictor.app

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import number.predictor.app.R

class Homescreen : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.homescreen)

        val textViewMainTitle1 = findViewById<TextView>(R.id.textViewMainTitle1)
        val buttonPlay = findViewById<Button>(R.id.buttonPlay)
        val buttonInstructions= findViewById<Button>(R.id.buttonInstructions)

        App_Globals.buttonFontSize = buttonPlay.textSize
        App_Globals.buttonHeight = buttonPlay.height

        textViewMainTitle1.setAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_up))
        buttonPlay.setAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_up))
        buttonInstructions.setAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_up))

        buttonPlay.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)
        buttonInstructions.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)

        val scaleDown: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
                textViewMainTitle1,
                PropertyValuesHolder.ofFloat("scaleX", 1.2f),
                PropertyValuesHolder.ofFloat("scaleY", 1.2f))
        scaleDown.duration = 510
        scaleDown.repeatCount = ObjectAnimator.INFINITE
        scaleDown.repeatMode = ObjectAnimator.REVERSE

        scaleDown.start()

        App_Globals.gameTotal = 0

        buttonInstructions.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Instructions_step1::class.java), 1)
        }
        buttonPlay.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Pre_game::class.java), 1)
        }

    }

    override fun onBackPressed(){}
}