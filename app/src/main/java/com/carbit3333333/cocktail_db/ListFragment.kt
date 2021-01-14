package com.carbit3333333.cocktail_db

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carbit3333333.cocktail_db.adapters.AdapterCoctail
import kotlinx.android.synthetic.main.fragment_list.*


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {
    lateinit var viewAdapter: AdapterCoctail

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AdapterCoctail(requireContext())
        recycler_list.adapter = adapter
       var list = (activity as MainActivity).viewModel?.getLiveDataItems()?.observe(activity as MainActivity, Observer {
           adapter.coinInfoList = it
       })

    }



}
