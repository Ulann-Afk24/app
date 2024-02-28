package com.example.navigations.nav_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.drawerlayout.widget.DrawerLayout
import com.example.navigations.R
import com.google.android.material.navigation.NavigationView

class HomeFragment : Fragment() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize the DrawerLayout
        drawerLayout = view.findViewById(R.id.drawer_layout)

        // Set up the NavigationView
        val navigationView: NavigationView = view.findViewById(R.id.navigation_drawer)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle navigation item clicks here
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    showToast("Home")
                }
                R.id.nav_profile -> {

                    showToast("Profile")
                }
                R.id.nav_accessories -> {
                    // Handle menu item 2 click
                    showToast("Accessories")
                }
                R.id.nav_motorcyles -> {
                    // Handle menu item 2 click
                    showToast("Rides")
                }
                R.id.nav_cart -> {
                    // Handle menu item 2 click
                    showToast("Carts")
                }
                R.id.nav_Order_History -> {
                    // Handle menu item 2 click
                    showToast("Orders")
                }
                // Add more cases for other menu items as needed

                else -> return@setNavigationItemSelectedListener false
            }

            // Close the drawer after handling the click
            drawerLayout.closeDrawer(navigationView)

            true
        }

        return view
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
