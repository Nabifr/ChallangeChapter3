package com.android.challangechapter3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.challangechapter3.databinding.CardListBinding

class AbjadAdapter(private val daftarAbjad : ArrayList<Abjad>) : RecyclerView.Adapter<AbjadAdapter.ViewHolder>(){
class ViewHolder(var binding : CardListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =CardListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardlist = daftarAbjad[position].abjad
        holder.binding.tvAbjad.text = cardlist

        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val transaction = p0?.context as AppCompatActivity
                val bundle = Bundle()

                bundle.putString("DATABJAD", cardlist)
                val kumpulanKataFrag = FragmentKata()
                kumpulanKataFrag.arguments = bundle
                transaction.supportFragmentManager.beginTransaction()
                    .replace(R.id.fr_parent, kumpulanKataFrag)
                    .addToBackStack(null)
                    .commit()
            }

        } )
    }
    override fun getItemCount(): Int {
        return daftarAbjad.size }
}