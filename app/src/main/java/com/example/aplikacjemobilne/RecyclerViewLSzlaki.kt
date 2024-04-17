package com.example.aplikacjemobilne

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikacjemobilne.Fragments.LatweFragment

class RecyclerViewLSzlaki constructor(private val getFragment: LatweFragment, private val lszlakilist : List<LatweSzlaki>) :
    RecyclerView.Adapter<RecyclerViewLSzlaki.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_latwe_szlaki, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.Lszlakinazwa.text = lszlakilist[position].title
        holder.Lszlakizdjecia.setImageResource(lszlakilist[position].image)

        holder.cardView.setOnClickListener {
            Toast.makeText(getFragment.requireContext(), lszlakilist[position].title, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return lszlakilist.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val Lszlakinazwa : TextView = itemView.findViewById(R.id.Lszlakinazwa)
        val Lszlakizdjecia : ImageView = itemView.findViewById(R.id.Lszlakizdjecia)
        val cardView : CardView = itemView.findViewById(R.id.cardView)

    }

}