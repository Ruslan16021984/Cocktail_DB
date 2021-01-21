package com.carbit3333333.cocktail_db.presentation

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.carbit3333333.cocktail_db.MainActivity
import com.carbit3333333.cocktail_db.R
import com.carbit3333333.cocktail_db.adapters.FilterAdapter
import kotlinx.android.synthetic.main.fragment_filter.*

/**
 * A simple [Fragment] subclass.
 */
class FilterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).viewModel?.getLiveDataCategories()
            ?.observe(requireActivity(), Observer {
                Log.e("getLiveDataCategories", it.toString())
                val adapter = FilterAdapter(activity as MainActivity, it)
                adapter.setHasStableIds(true)
                rvFilterList.adapter = adapter
            })
    }

}
