package com.android.challangechapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.challangechapter3.databinding.FragmentVerticalBinding

class FragmentVertical : Fragment() {
    val verList = ArrayList<Abjad>()
    lateinit var binding: FragmentVerticalBinding
    lateinit var verticalRecycler: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentVerticalBinding.inflate(layoutInflater, container, false)
        verticalRecycler = binding.recyclerVertical
        verticalRecycler.setHasFixedSize(true)

        tampilRecyclerListVertical()
        return binding.root
    }
    //direct tampilan vertical ke grid jika menekan icon
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {super.onViewCreated(view, savedInstanceState)
        val imagebutton = binding.mnVertical.icGrid
        val fragmentgrid = FragmentGrid()

        imagebutton.setOnClickListener {
            setCurrentFragment(fragmentgrid)
        }
    }

    //mengambil data abjad dari string ke array list
    private fun getlistabjad(): ArrayList<Abjad> {
        val dataNama = resources.getStringArray(R.array.dataAbjad)
        val listAbjad = ArrayList<Abjad>()

        for (i in dataNama.indices) {
            val abjad = Abjad(dataNama[i])
            listAbjad.add(abjad)
        }
        return listAbjad
    }
    //menampilkan data abjad secara vertical
    private fun tampilRecyclerListVertical() {
        verticalRecycler.layoutManager = LinearLayoutManager(context)
        val adapterAbjad = AbjadAdapter(verList)
        verticalRecycler.adapter = adapterAbjad
        verList.clear()
        verList.addAll(getlistabjad())
    }


    private fun setCurrentFragment(fragment: Fragment):
      FragmentTransaction = parentFragmentManager.beginTransaction().apply {
            replace(R.id.fr_parent, fragment)
            commit()
        }

}