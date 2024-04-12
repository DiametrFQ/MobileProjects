package ru.mirea.hohlovdv.mireaproject.ui.worker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.google.android.material.snackbar.Snackbar
import ru.mirea.hohlovdv.mireaproject.R
import ru.mirea.hohlovdv.mireaproject.databinding.FragmentWorkerBinding


class WorkerFragment : Fragment() {

    companion object {
        fun newInstance() = WorkerFragment()
        const val POINT_KEY = "numberOfPoints"
        const val APP_KEY = "piApproximation"
    }

    private val viewModel: WorkerViewModel by activityViewModels()
    private var _binding: FragmentWorkerBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkerBinding.inflate(inflater, container, false)
        val root = binding.root

        val fragmentDescTextView = binding.fragmentDescTextView
        val inputFieldView = binding.inputFieldView
        val resultTextView = binding.resultTextView

        viewModel.textViewDescription.observe(viewLifecycleOwner) {
            fragmentDescTextView.text = getString(it)
        }
        viewModel.resultTextView.observeForever {
            if (it.isNotEmpty()) {
                resultTextView.text = it
            }
        }

        val workManager = WorkManager
            .getInstance(requireContext())

        binding.btnStartWorker.setOnClickListener {
            val inputText = inputFieldView.text.toString()

            if (inputText.isEmpty()) {
                Snackbar.make(
                    inputFieldView,
                    R.string.empty_input_field,
                    Snackbar.LENGTH_LONG
                ).show()
            } else if (inputText.toLongOrNull() == null) {
                Snackbar.make(
                    inputFieldView,
                    R.string.invalid_input_field,
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val inputData = Data
                    .Builder()
                    .putLong(POINT_KEY, inputText.toLong())
                    .build()

                val factorialCalcWorkRequest = OneTimeWorkRequest
                    .Builder(LongTime::class.java)
                    .setInputData(inputData)
                    .setConstraints(
                        Constraints
                            .Builder()
                            .setRequiredNetworkType(NetworkType.UNMETERED)
                            .build()
                    )
                    .build()

                workManager.enqueue(factorialCalcWorkRequest)

                Snackbar.make(
                    inputFieldView,
                    getString(R.string.worker_started, inputText.toLong()),
                    Snackbar.LENGTH_LONG
                ).show()

                workManager
                    .getWorkInfoByIdLiveData(factorialCalcWorkRequest.id)
                    .observeForever { workInfo ->
                        if (workInfo.state == WorkInfo.State.SUCCEEDED) {
                            val result = workInfo.outputData.getDouble(APP_KEY, 3.14)
                            viewModel.resultTextView.apply { value = "Result: $result" }
                        }
                    }
            }
        }
        return root
    }
}