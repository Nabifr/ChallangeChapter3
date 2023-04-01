package com.android.challangechapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.challangechapter3.databinding.FragmentKataBinding


@Suppress("DEPRECATION")
class FragmentKata : Fragment() {
    val daftarkata = ArrayList<Kata>()
    lateinit var binding: FragmentKataBinding
    lateinit var kataRecycler: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKataBinding.inflate(layoutInflater, container, false)
        val args = this.arguments
        val kirimkata = args?.get("DATABJAD")

        binding.mnKata.textView.text = "Word That Start With $kirimkata"
        kataRecycler = binding.recyclerWord
        kataRecycler.setHasFixedSize(true)

        tampilRecyclerListWordVertical()
        return binding.root
    }

    //mengatur icon back agar bisa kembali ke halamansebelumnya
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgBack = binding.mnKata.icBack
        val backOff = FragmentVertical()
        imgBack.setOnClickListener {
            setCurrentFragment(backOff)
        }
    }


    private fun getKata(): ArrayList<Kata> {
        val args = this.arguments
        val kirimkata = args?.get("DATABJAD")

        val dataKata = resources.getStringArray(R.array.Huruf)
        val listKata = ArrayList<Kata>()
        for (i in dataKata.indices) {
            val firstletter = dataKata[i].take(1)

            if (firstletter == kirimkata) {
                val kata = Kata(dataKata[i])
                listKata.add(kata)
            }
        }
        return listKata
}
    private fun tampilRecyclerListWordVertical() {
        kataRecycler.layoutManager = LinearLayoutManager(context)
            val listHurufAdapter = HurufAdapter(daftarkata)
            kataRecycler.adapter = listHurufAdapter
            daftarkata.clear()
            daftarkata.addAll(getKata())
    }


    private fun setCurrentFragment(fragment: Fragment): FragmentTransaction =
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fr_parent, fragment)
            commit()
        }
}