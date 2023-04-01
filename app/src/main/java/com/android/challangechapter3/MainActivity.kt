package com.android.challangechapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.android.challangechapter3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmenList =  FragmentVertical()
        setCurrentFragment(fragmenList)
    }

    private fun setCurrentFragment(fragment : Fragment): FragmentTransaction = supportFragmentManager.beginTransaction().apply {
    replace(R.id.fr_parent, fragment)
    commit()
    }

}