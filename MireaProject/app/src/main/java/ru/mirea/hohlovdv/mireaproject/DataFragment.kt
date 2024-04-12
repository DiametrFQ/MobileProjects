package ru.mirea.hohlovdv.mireaproject
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import ru.mirea.hohlovdv.mireaproject.R
import ru.mirea.hohlovdv.mireaproject.databinding.FragmentDataBinding

class DataFragment : Fragment() {

    private var _binding: FragmentDataBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val _textTitle = MutableLiveData<String>().apply {
            value = "Музыкальная  индустрия"
        }

        val _textDescription = MutableLiveData<String>().apply {
            value = "Музыкальная индустрия представляет собой совокупность творческих и технических процессов, направленных на проведение музыкальной деятельности, а также создание, запись, хранение и распространение музыкальных произведений. Рост технического развития музыкальных носителей начался в XX веке."
        }

        _binding = FragmentDataBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textViewTitle: TextView = binding.textViewTitle
        val textViewDescription: TextView = binding.textViewDescription
        _textTitle.observe(viewLifecycleOwner) {
            textViewTitle.text = it
        }
        _textDescription.observe(viewLifecycleOwner) {
            textViewDescription.text = it
        }
        return root
    }
}