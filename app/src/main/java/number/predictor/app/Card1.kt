package number.predictor.app

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import number.predictor.app.R

class Card1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card1)

        App_Globals.gameTotal = 0

        val buttonCard1Yes = findViewById<Button>(R.id.buttonCard1Yes)
        val buttonCard1No = findViewById<Button>(R.id.buttonCard1No)
        val fabHome = findViewById<FloatingActionButton>(R.id.fabHome)

        buttonCard1Yes.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)
        buttonCard1No.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)

        buttonCard1Yes.setOnClickListener{
            App_Globals.gameTotal += 1
            App_Globals.transferActivity(this, Intent(this, Card2::class.java), 1)
        }

        buttonCard1No.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Card2::class.java), 1)
        }
        fabHome.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Homescreen::class.java), 2)
        }
    }

    override fun onBackPressed() {
        App_Globals.transferActivity(this, Intent(this, Pre_game::class.java), 2)
        App_Globals.gameTotal = 0
    }
}