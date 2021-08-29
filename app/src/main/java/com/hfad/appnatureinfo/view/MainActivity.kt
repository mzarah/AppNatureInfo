package com.hfad.appnatureinfo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.hfad.appnatureinfo.R
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_AppNatureInfo)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navBar: ChipNavigationBar = findViewById(R.id.bottom_nav)
        var manager: FragmentManager? = supportFragmentManager


        var fragment: Fragment = EarthquakeFragment()

        manager?.beginTransaction()?.replace(R.id.fragment_container, fragment)?.commit()
        navBar.setItemSelected(R.id.earthquake, true)

        navBar.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(id: Int) {
                when (id) {
                    R.id.earthquake -> fragment = EarthquakeFragment()
                    R.id.flood -> fragment = DisasterFragment()
                }
                    manager = supportFragmentManager
                    manager!!.beginTransaction().replace(R.id.fragment_container, fragment).commit()

            }
        })

    }
}