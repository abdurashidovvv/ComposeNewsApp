package uz.abdurashidov.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.abdurashidov.newsapp.domain.usecases.AppEntryUseCase
import uz.abdurashidov.newsapp.presentation.onboarding.OnBoardingScreen
import uz.abdurashidov.newsapp.presentation.onboarding.OnBoardingViewModel
import uz.abdurashidov.newsapp.presentation.ui.theme.NewsAppTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var useCase: AppEntryUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()

        lifecycleScope.launch {
            useCase.readAppEntry().collect{
                Log.d("Test", "onCreate: $it")
            }
        }
        setContent {
            NewsAppTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    val viewModel: OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(
                        event = viewModel::onEvent
                    )
                }
            }
        }
    }
}
