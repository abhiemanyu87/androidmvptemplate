package com.abhie.mvp.ui.home

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.abhie.mvp.R
import com.abhie.mvp.ui.base.view.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class Home : BaseActivity(), HasSupportFragmentInjector {
    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

    private lateinit var textMessage: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val hostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
                ?: return

        val navController = hostFragment.navController

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            // do whatever needed when nav destination changed
        }

        setupNavWithActionBar(navController, toolbar)
        setupBottomNavigationMenu(navController)
    }

    private fun setupNavWithActionBar(navController: NavController, toolbar: Toolbar) {
        NavigationUI.setupWithNavController(toolbar, navController)
    }

    private fun setupBottomNavigationMenu(navController: NavController) {
        findViewById<BottomNavigationView>(R.id.bottom_navigation)?.let { bottomNavigationView ->
//            defaultMenu = bottomNavigationView.menu

            NavigationUI.setupWithNavController(bottomNavigationView, navController)
        }
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }
}
