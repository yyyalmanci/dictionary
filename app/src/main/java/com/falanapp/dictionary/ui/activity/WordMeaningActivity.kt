package com.falanapp.dictionary.ui.activity

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.falanapp.dictionary.R
import com.falanapp.dictionary.R.color.colorAccent
import com.falanapp.dictionary.ui.adapters.ViewPagerAdapter
import com.falanapp.dictionary.ui.fragments.FragmentAntonyms
import com.falanapp.dictionary.ui.fragments.FragmentDefinition
import com.falanapp.dictionary.ui.fragments.FragmentExample
import com.falanapp.dictionary.ui.fragments.FragmentSynonyms
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class WordMeaningActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_meaning)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.mToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "English words"

        val back: Drawable? = getDrawable(R.drawable.ic_back_arrow)
        back?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                it.setTint(applicationContext.getColor(colorAccent))
            }
        }
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow)

        viewPager = findViewById(R.id.tab_viewpager)
        setupViewPager(viewPager)

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
                return
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                return
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                viewPager.currentItem = p0!!.position

            }
        })
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(FragmentDefinition(), "Definition")
        adapter.addFrag(FragmentAntonyms(), "Antonyms")
        adapter.addFrag(FragmentExample(), "Example")
        adapter.addFrag(FragmentSynonyms(), "Synonyms")
        viewPager.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}

