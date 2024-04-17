package com.example.aplikacjemobilne.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aplikacjemobilne.LatweSzlaki
import com.example.aplikacjemobilne.R
import com.example.aplikacjemobilne.RecyclerViewLSzlaki
import com.example.aplikacjemobilne.databinding.FragmentLatweBinding

class LatweFragment : Fragment() {

    private var _binding: FragmentLatweBinding? = null
    private val binding get() = _binding!!

    private var recyclerViewLSzlaki: RecyclerViewLSzlaki? = null
    private var lszlakilist = mutableListOf<LatweSzlaki>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLatweBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lszlakilist = ArrayList()
        recyclerViewLSzlaki = RecyclerViewLSzlaki(this, lszlakilist)

        binding.Lszlakilista.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.Lszlakilista.adapter = recyclerViewLSzlaki

        preparelszlakilistData()
    }

    private fun preparelszlakilistData() {
        var latweszlaki = LatweSzlaki("Szlak nadmorski", R.drawable.morzeszlak)
        lszlakilist.add(latweszlaki)
        latweszlaki = LatweSzlaki("Szlak leśny", R.drawable.lasszlak)
        lszlakilist.add(latweszlaki)
        latweszlaki = LatweSzlaki("Szlak rzeczny", R.drawable.rzekaszlak)
        lszlakilist.add(latweszlaki)

        recyclerViewLSzlaki!!.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
