package com.example.aplikacjemobilne

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikacjemobilne.Fragments.TrudneFragment

class RecyclerViewTSzlaki constructor(private val getFragment: TrudneFragment, private val tszlakilist : List<TrudneSzlaki>) :
    RecyclerView.Adapter<RecyclerViewTSzlaki.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_trudne_szlaki, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.Tszlakinazwa.text = tszlakilist[position].title
        holder.Tszlakizdjecia.setImageResource(tszlakilist[position].image)

        holder.cardView.setOnClickListener {
            Toast.makeText(getFragment.requireContext(), tszlakilist[position].title, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return tszlakilist.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val Tszlakinazwa : TextView = itemView.findViewById(R.id.Tszlakinazwa)
        val Tszlakizdjecia : ImageView = itemView.findViewById(R.id.Tszlakizdjecia)
        val cardView : CardView = itemView.findViewById(R.id.cardView)

    }

}