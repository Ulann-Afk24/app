package com.example.navigations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.navigations.nav_fragments.HomeFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener{

    private val onBackPressedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            onBackPressedMethod()
        }


    }

    private fun onBackPressedMethod() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            (drawerLayout.closeDrawer(GravityCompat.START))



        }else{
            finish()
        }
    }

    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onBackPressedDispatcher.addCallback(this,onBackPressedCallback)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)

        val navigationView = findViewById<NavigationView>(R.id.navigation_drawer)
       

        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        ///deaf nav pri
        replaceframent(HomeFragment())
        navigationView.setCheckedItem(R.id.nav_home)

    }
    private fun replaceframent(fragment:HomeFragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_fragment,fragment)
            .commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> {
                replaceframent(HomeFragment())
                title = "helmet_sa_nav_menu"
            }
            R.id.nav_motorcyles-> {
                replaceframent(HomeFragment())
                title = "motor_sa_nav_menu"
                Toast.makeText(this,"share Clicked", Toast.LENGTH_LONG).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }


}