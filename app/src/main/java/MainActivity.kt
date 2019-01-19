package cu.challenges.jesus.shopifychallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import cu.challenges.jesus.shopifychallenge.data.updateAndroidSecurityProvider
import cu.challenges.jesus.shopifychallenge.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateAndroidSecurityProvider(this)
        setContentView(R.layout.main_activity)
    }

}
