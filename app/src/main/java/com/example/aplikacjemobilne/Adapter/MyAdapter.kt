package com.example.aplikacjemobilne.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.aplikacjemobilne.Fragments.HomeFragment
import com.example.aplikacjemobilne.Fragments.LatweFragment
import com.example.aplikacjemobilne.Fragments.TrudneFragment

internal class MyAdapter(val context: Context,val fm : FragmentManager, val totalTabs:Int) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {

        return when(position){
            0 -> {
                HomeFragment()
            }
            1 -> {
                LatweFragment()
            }
            2 -> {
                TrudneFragment()
            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {

        return totalTabs
    }
}