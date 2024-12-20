package ru.mirea.hohlovdv.lesson4.ui.musicplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.mirea.hohlovdv.lesson4.ui.musicplayer.MusicPlayerViewModel
import ru.mirea.hohlovdv.lesson4.databinding.FragmentMusicPlayerBinding

class MusicPlayerFragment : Fragment() {

    private var _binding: FragmentMusicPlayerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val musicPlayerViewModel =
            ViewModelProvider(this)[MusicPlayerViewModel::class.java]

        _binding = FragmentMusicPlayerBinding.inflate(inflater, container, false)
        val root = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}