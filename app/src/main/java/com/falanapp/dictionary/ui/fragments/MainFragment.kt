package com.falanapp.dictionary.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.falanapp.dictionary.R
import com.falanapp.dictionary.ui.activity.WordMeaningActivity


class MainFragment : Fragment() {
    lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val toolbar: androidx.appcompat.widget.Toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        setHasOptionsMenu(true)

        searchView = view.findViewById(R.id.search_view)

        searchView.setOnClickListener {
            searchView.isIconified = false
            val intent = Intent(context, WordMeaningActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.action_exit) {
            System.exit(0)
            true
        } else {
            NavigationUI.onNavDestinationSelected(
                item!!,
                view!!.findNavController()
            )
                    || super.onOptionsItemSelected(item)
        }
    }
}