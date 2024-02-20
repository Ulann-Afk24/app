package com.example.navigations

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{


    private lateinit var fragmentManager:FragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
    

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_prime -> openfragment(PrimeFragment())
            R.id.nav_motor -> openfragment(MotorFragment())
            R.id.bottom_home -> openfragment((HomeFragment()))
            R.id.bottom_profile -> openfragment((ProfileFragment()))
            R.id.bottom_cart -> openfragment(CartFragment())
            R.id.bottom_order -> openfragment(Ordersragment())
        }
        return true
    }
    private fun openfragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

    }


}