package number.predictor.app

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import number.predictor.app.R

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val textViewHeader = findViewById<TextView>(R.id.textViewHeader)
        val textViewDesc = findViewById<TextView>(R.id.textViewDesc)
        val imageViewHeart = findViewById<ImageView>(R.id.imageViewHeart)

        textViewHeader.startAnimation(AnimationUtils.loadAnimation(this,
            R.anim.splash_screen_animation
        ))
        textViewDesc.startAnimation(AnimationUtils.loadAnimation(this,
            R.anim.splash_screen_animation
        ))
        imageViewHeart.startAnimation(AnimationUtils.loadAnimation(this,
            R.anim.splash_screen_animation
        ))

        val scaleDown: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
                imageViewHeart,
                PropertyValuesHolder.ofFloat("scaleX", 1.2f),
                PropertyValuesHolder.ofFloat("scaleY", 1.2f))
        scaleDown.duration = 310
        scaleDown.repeatCount = ObjectAnimator.INFINITE
        scaleDown.repeatMode = ObjectAnimator.REVERSE

        scaleDown.start()

        Handler().postDelayed({
            App_Globals.transferActivity(this, Intent(this, Homescreen::class.java), 1)
        }, 5000);
    }
}