
package number.predictor.app

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.content.res.Configuration

class App_Globals: Application() {
    companion object {
        var gameTotal = 0
        var textFontSize: Float = 0.0f
        var buttonFontSize: Float = 0.0f
        var buttonHeight: Int = 0
        fun transferActivity(currentActivity: Activity, nextActivityIntent: Intent, direction: Int) {

            when(direction){
                1 -> {
                    if (currentActivity.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

                        currentActivity.startActivity(nextActivityIntent)
                        currentActivity.overridePendingTransition(
                            R.anim.slide_in_right,
                            R.anim.slide_out_left
                        )

                    } else if (currentActivity.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

                        currentActivity.startActivity(nextActivityIntent)
                        currentActivity.overridePendingTransition(
                            R.anim.slide_in_up,
                            R.anim.slide_out_down
                        )

                    }
                }
                2 -> {
                    if (currentActivity.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

                        currentActivity.startActivity(nextActivityIntent)
                        currentActivity.overridePendingTransition(
                            R.anim.slide_in_left,
                            R.anim.slide_out_right
                        )

                    } else if (currentActivity.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

                        currentActivity.startActivity(nextActivityIntent)
                        currentActivity.overridePendingTransition(
                            R.anim.slide_in_up,
                            R.anim.slide_out_down
                        )

                    }
                }
            }

        }


    }
}