package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.os.Bundle
import androidx.navigation.ui.NavigationUI
import Models.LoginData
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mAppBarConfiguration: AppBarConfiguration? = null
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val drawer = binding!!.drawerLayout
        val navigationView = binding!!.navView
        mAppBarConfiguration = AppBarConfiguration.Builder(
            R.id.mainPageFragment,
            R.id.smartphoneFragment,
            R.id.notebookFragment,
            R.id.wirelessHeadphonesFragment,
            R.id.wireHeadphonesFragment,
            R.id.accessoryFragment
        )
            .setOpenableLayout(drawer).build()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main)
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration!!)
        NavigationUI.setupWithNavController(navigationView, navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main)
        return (NavigationUI.navigateUp(navController, mAppBarConfiguration!!)
                || super.onSupportNavigateUp())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Login -> if (LoginData.getUsername() == null) Navigation.findNavController(
                this,
                R.id.nav_host_fragment_content_main
            ).navigate(R.id.LoginFragment) else {
                Toast.makeText(this.applicationContext, R.string.AlreadySignIn, Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.Cart -> if (LoginData.getUsername() == null) {
                Toast.makeText(this.applicationContext, R.string.SignInRequired, Toast.LENGTH_SHORT)
                    .show()
            } else {
                Navigation.findNavController(this, R.id.nav_host_fragment_content_main)
                    .navigate(R.id.CartFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}