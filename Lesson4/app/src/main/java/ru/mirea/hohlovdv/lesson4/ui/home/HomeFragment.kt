package ru.mirea.hohlovdv.lesson4.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.mirea.hohlovdv.lesson4.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private val TAG = HomeFragment::class.java.simpleName
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root = binding.root

        homeViewModel.text.observe(viewLifecycleOwner) {
            binding.editTextMirea.setText(it)
        }

        val text = homeViewModel.onClickText.value as String
        binding.buttonMirea.setOnClickListener {
            Log.d(TAG, "onClick: $text")
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}