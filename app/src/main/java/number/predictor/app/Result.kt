package number.predictor.app

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import nl.dionsegijn.konfetti.KonfettiView
import nl.dionsegijn.konfetti.emitters.StreamEmitter
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size


class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)

        val buttonPlayAgain = findViewById<Button>(R.id.buttonPlayAgain)
        val buttonMainMenu = findViewById<Button>(R.id.buttonMainMenu)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonPlayAgain.setTextSize(
            TypedValue.COMPLEX_UNIT_SP,
            App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity
        )
        buttonMainMenu.setTextSize(
            TypedValue.COMPLEX_UNIT_SP,
            App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity
        )

        textViewResult.text = App_Globals.gameTotal.toString()

        val scaleDown: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            textViewResult,
            PropertyValuesHolder.ofFloat("scaleX", 1.2f),
            PropertyValuesHolder.ofFloat("scaleY", 1.2f)
        )
        scaleDown.duration = 310
        scaleDown.repeatCount = ObjectAnimator.INFINITE
        scaleDown.repeatMode = ObjectAnimator.REVERSE

        scaleDown.start()

        buttonPlayAgain.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Pre_game::class.java), 1)
        }
        buttonMainMenu.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Homescreen::class.java), 1)
        }

    }
    override fun onBackPressed(){}
    override fun onResume(){
        super.onResume()
        val handler = Handler()
        handler.postDelayed(object : Runnable {
                             override fun run(){
                                 val viewKonfetti = findViewById<KonfettiView>(R.id.viewKonfetti)
                                 val viewKonfetti2 = findViewById<KonfettiView>(R.id.viewKonfetti2)
                                 val viewKonfetti3 = findViewById<KonfettiView>(R.id.viewKonfetti3)

                                 viewKonfetti3.build()
                                     .addColors(Color.parseColor("#673AB7"), Color.parseColor("#FFD700"), Color.parseColor("#FD7F20"))
                                     .setDirection(0.0, 359.0)
                                     .setSpeed(1f, 5f)
                                     .setFadeOutEnabled(true)
                                     .setTimeToLive(2000L)
                                     .addShapes(Shape.Square, Shape.Circle)
                                     .addSizes(Size(12))
                                     .setPosition(viewKonfetti.width.toFloat()/2f, viewKonfetti.width.toFloat()/2f, 0f, 0f)
                                     .streamFor(particlesPerSecond = 300, emittingTime = StreamEmitter.INDEFINITE)

                                 viewKonfetti2.build()
                                     .addColors(Color.parseColor("#673AB7"), Color.parseColor("#FFD700"), Color.parseColor("#FD7F20"))
                                     .setDirection(0.0, 359.0)
                                     .setSpeed(1f, 5f)
                                     .setFadeOutEnabled(true)
                                     .setTimeToLive(2000L)
                                     .addShapes(Shape.Square, Shape.Circle)
                                     .addSizes(Size(12))
                                     .setPosition(viewKonfetti.width.toFloat(), viewKonfetti.width.toFloat(), 0f, 0f)
                                     .streamFor(particlesPerSecond = 300, emittingTime = StreamEmitter.INDEFINITE)

                                 viewKonfetti.build()
                                     .addColors(Color.parseColor("#673AB7"), Color.parseColor("#FFD700"), Color.parseColor("#FD7F20"))
                                     .setDirection(0.0, 359.0)
                                     .setSpeed(1f, 5f)
                                     .setFadeOutEnabled(true)
                                     .setTimeToLive(2000L)
                                     .addShapes(Shape.Square, Shape.Circle)
                                     .addSizes(Size(12))
                                     .setPosition(0f, 0f, 0f, 0f)
                                     .streamFor(particlesPerSecond = 300, emittingTime = StreamEmitter.INDEFINITE)
                             }

                                              }, 200)

    }

}
