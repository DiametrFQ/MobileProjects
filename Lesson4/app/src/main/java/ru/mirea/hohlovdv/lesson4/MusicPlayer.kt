package ru.mirea.hohlovdv.lesson4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.mirea.hohlovdv.lesson4.databinding.FragmentMusicPlayerBinding

class MusicPlayer : Fragment() {
    private var binding: FragmentMusicPlayerBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicPlayerBinding.inflate(inflater, container, false)
        val root: View = binding!!.getRoot()
        val textView: TextView = binding!!.textGallery
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}