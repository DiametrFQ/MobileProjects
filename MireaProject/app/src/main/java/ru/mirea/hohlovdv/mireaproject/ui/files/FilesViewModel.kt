package ru.mirea.hohlovdv.mireaproject.ui.files

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FilesViewModel : ViewModel() {
    val path = MutableLiveData<String>()
    //val publicPath: LiveData<String> = path
}