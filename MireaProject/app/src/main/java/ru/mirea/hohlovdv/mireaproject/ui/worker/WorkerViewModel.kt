package ru.mirea.hohlovdv.mireaproject.ui.worker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mirea.hohlovdv.mireaproject.R

class WorkerViewModel : ViewModel() {
    private val _textDescription = MutableLiveData<Int>().apply {
        value = R.string.worker_task_description
    }
    val resultTextView = MutableLiveData<String>()
    val textViewDescription: LiveData<Int> = _textDescription
}
