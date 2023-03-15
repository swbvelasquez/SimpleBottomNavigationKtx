package com.swbvelasquez.simplebottomnavigationktx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import com.swbvelasquez.simplebottomnavigationktx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnvMain.background = null //Permite quitar el background del bottom nav view
        binding.bnvMain.setOnItemSelectedListener { menuItem ->
            val fragment:Fragment? = when(menuItem.itemId){
                R.id.optHome -> HomeFragment()
                R.id.optFavorite -> FavoriteFragment()
                R.id.optProfile -> ProfileFragment()
                R.id.optHistory -> HistoryFragment()
                else -> null
            }

            if(fragment!=null){
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.lyContentMain,fragment)
                    .commit()
            }

            true
        }
    }
}