package website.lolegrand.personapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import org.koin.compose.KoinContext
import website.lolegrand.personapp.navigation.PersonAppNavHost
import website.lolegrand.personapp.theme.PersonAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            KoinContext {
                PersonAppTheme {
                    PersonAppNavHost(
                        modifier = Modifier
                    )
                }
            }
        }
    }
}