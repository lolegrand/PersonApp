package website.lolegrand.personapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import website.lolegrand.personapp.detail.DetailScreen
import website.lolegrand.personapp.generator.GeneratorScreen
import website.lolegrand.personapp.landing.LandingScreen
import website.lolegrand.personapp.master.MasterScreen
import website.lolegrand.personapp.navigation.destination.DetailDestination
import website.lolegrand.personapp.navigation.destination.GeneratorDestination
import website.lolegrand.personapp.navigation.destination.LandingDestination
import website.lolegrand.personapp.navigation.destination.MasterDestination

@Composable
fun PersonAppNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LandingDestination,
        modifier = modifier,
    ) {

        composable<LandingDestination> {
            LandingScreen(
                onClickGeneratePerson = {
                    navController.navigate(GeneratorDestination)
                },
                onClickGoToPersonList = {
                    navController.navigate(MasterDestination)
                }
            )
        }

        composable<MasterDestination> {
            MasterScreen(
                onGoToPersonDetail = {
                    navController.navigate(DetailDestination(it))
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable<DetailDestination> {
            DetailScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable<GeneratorDestination> {
            GeneratorScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

    }
}