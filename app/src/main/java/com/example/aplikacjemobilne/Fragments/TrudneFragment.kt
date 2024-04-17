package com.example.aplikacjemobilne.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aplikacjemobilne.TrudneSzlaki
import com.example.aplikacjemobilne.R
import com.example.aplikacjemobilne.RecyclerViewTSzlaki
import com.example.aplikacjemobilne.databinding.FragmentTrudneBinding

class TrudneFragment : Fragment() {

    private var _binding: FragmentTrudneBinding? = null
    private val binding get() = _binding!!

    private var recyclerViewTSzlaki: RecyclerViewTSzlaki? = null
    private var tszlakilist = mutableListOf<TrudneSzlaki>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrudneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tszlakilist = ArrayList()
        recyclerViewTSzlaki = RecyclerViewTSzlaki(this, tszlakilist)

        binding.Tszlakilista.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.Tszlakilista.adapter = recyclerViewTSzlaki

        preparetszlakilistData()
    }

    private fun preparetszlakilistData() {
        var trudneszlaki = TrudneSzlaki("Szlak górski", R.drawable.goryszlak)
        tszlakilist.add(trudneszlaki)
        trudneszlaki = TrudneSzlaki("Szlak górski 2", R.drawable.goryszlak2)
        tszlakilist.add(trudneszlaki)

        recyclerViewTSzlaki!!.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}