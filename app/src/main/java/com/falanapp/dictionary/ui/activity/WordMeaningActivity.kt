package com.falanapp.dictionary.ui.activity

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.falanapp.dictionary.R
import com.falanapp.dictionary.R.color.colorAccent

class WordMeaningActivity : AppCompatActivity() {


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
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
