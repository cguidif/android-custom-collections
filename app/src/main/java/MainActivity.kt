package cu.challenges.jesus.shopifychallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cu.challenges.jesus.shopifychallenge.data.updateAndroidSecurityProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateAndroidSecurityProvider(this)
        setContentView(R.layout.main_activity)
    }

}
