package com.falanapp.dictionary.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.falanapp.dictionary.R

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val toolbar: androidx.appcompat.widget.Toolbar = view.findViewById(R.id.toolbar_settings)
        (activity as AppCompatActivity).apply {
            setSupportActionBar(toolbar)
            supportActionBar!!.title = "Settings"
        }
        setHasOptionsMenu(true)

        toolbar.setNavigationIcon(R.drawable.ic_back_arrow)

        return view
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController().popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }
}