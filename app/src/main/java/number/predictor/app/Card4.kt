package number.predictor.app

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import number.predictor.app.R

class Card4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card4)

        val buttonCard4Yes = findViewById<Button>(R.id.buttonCard4Yes)
        val buttonCard4No = findViewById<Button>(R.id.buttonCard4No)
        val fabHome = findViewById<FloatingActionButton>(R.id.fabHome)

        buttonCard4Yes.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)
        buttonCard4No.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)

        buttonCard4Yes.setOnClickListener{
            App_Globals.gameTotal += 8
            App_Globals.transferActivity(this, Intent(this, Card5::class.java), 1)
        }

        buttonCard4No.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Card5::class.java), 1)
        }
        fabHome.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Homescreen::class.java), 2)
        }
    }

    override fun onBackPressed() {
        App_Globals.transferActivity(this, Intent(this, Card3::class.java), 2)
        App_Globals.gameTotal -= 4
    }
}