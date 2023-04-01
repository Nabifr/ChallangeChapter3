package com.android.challangechapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.challangechapter3.databinding.FragmentGridBinding


class FragmentGrid : Fragment() {

    lateinit var binding: FragmentGridBinding
    lateinit var recyclerGrid: RecyclerView
    val arList = ArrayList<Abjad>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGridBinding.inflate(layoutInflater, container, false)
        recyclerGrid = binding.recyclerGrid
        recyclerGrid.setHasFixedSize(true)

        tampilRecyclerListGrid()
        return binding.root
    }

    //direct tampilan grid ke vertical jika menekan icon
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {super.onViewCreated(view, savedInstanceState)
        val imagebutton = binding.mnGrid.icList
        val fragmentvertical = FragmentVertical()

        imagebutton.setOnClickListener {
            setCurrentFragment(fragmentvertical)
        }
    }

    //mengambil data abjad dari string ke array list
    private fun getlistabjad(): ArrayList<Abjad> {
        val datAbjad = resources.getStringArray(R.array.dataAbjad)
        val daftarAbjad = ArrayList<Abjad>()

        for (i in datAbjad.indices) {
            val abjad = Abjad(datAbjad[i])
            daftarAbjad.add(abjad)
        }
        return daftarAbjad
    }

    // menampilkan data abjad pada grid 3 kolom
    private fun tampilRecyclerListGrid() {
        val GridLayout = GridLayoutManager(context, 3)
        recyclerGrid.layoutManager = GridLayout
        val adapterAbjad = AbjadAdapter(arList)
        recyclerGrid.adapter = adapterAbjad
        arList.clear()
        arList.addAll(getlistabjad())
    }

    private fun setCurrentFragment(fragment: Fragment):
      FragmentTransaction = parentFragmentManager.beginTransaction().apply {
            replace(R.id.fr_parent, fragment)
            commit()
        }

}