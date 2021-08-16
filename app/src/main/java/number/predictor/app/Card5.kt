package number.predictor.app

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import nl.dionsegijn.konfetti.KonfettiView

class Card5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card5)

        val buttonCard5Yes = findViewById<Button>(R.id.buttonCard5Yes)
        val buttonCard5No = findViewById<Button>(R.id.buttonCard5No)
        val fabHome = findViewById<FloatingActionButton>(R.id.fabHome)

        buttonCard5Yes.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)
        buttonCard5No.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)

        buttonCard5Yes.setOnClickListener{
            App_Globals.gameTotal += 16
            App_Globals.transferActivity(this, Intent(this, Result::class.java), 1)
        }

        buttonCard5No.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Result::class.java), 1)
        }
        fabHome.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Homescreen::class.java), 2)
        }
    }

    override fun onBackPressed() {
        App_Globals.transferActivity(this, Intent(this, Card4::class.java), 2)
        App_Globals.gameTotal -= 8
    }
}