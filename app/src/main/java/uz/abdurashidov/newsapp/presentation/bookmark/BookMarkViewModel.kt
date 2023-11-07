package uz.abdurashidov.newsapp.presentation.bookmark

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.abdurashidov.newsapp.domain.usecases.news.NewsUseCases
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
):ViewModel() {
}