package uz.abdurashidov.newsapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.abdurashidov.newsapp.domain.usecases.AppEntryUseCase
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCase
) :ViewModel() {
    fun onEvent(event:OnBoardingEvent){
        when(event){
            OnBoardingEvent.SaveAppEntry -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCase.saveAppEntry()
        }
    }
}