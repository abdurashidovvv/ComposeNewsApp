package uz.abdurashidov.newsapp.domain.usecases.appentry

import uz.abdurashidov.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}