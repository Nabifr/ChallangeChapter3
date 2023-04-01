package com.android.challangechapter3

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.challangechapter3.databinding.CardListBinding

class HurufAdapter(private val daftarHuruf : ArrayList<Kata>) : RecyclerView.Adapter<HurufAdapter.ViewHolder>(){
class ViewHolder(var binding: CardListBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardlist = daftarHuruf[position].kata
        holder.binding.tvAbjad.text = cardlist

        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val transaction = p0?.context as AppCompatActivity
                val browser = Intent(Intent.ACTION_VIEW)

                browser.data = Uri.parse("https://www.google.com/search?q=$cardlist")
                transaction.startActivity(browser)
            }

        } )
    }

    override fun getItemCount(): Int {
        return daftarHuruf.size }
}