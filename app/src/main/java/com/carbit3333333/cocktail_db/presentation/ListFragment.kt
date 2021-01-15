package com.carbit3333333.cocktail_db.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.carbit3333333.cocktail_db.MainActivity
import com.carbit3333333.cocktail_db.R
import com.carbit3333333.cocktail_db.adapters.AdapterCoctail
import goldzweigapps.com.annotations.annotations.GencyclerModel
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var list: MutableList<GencyclerModel> = ArrayList()
        var adapter = AdapterCoctail(requireContext())
        rvCoinPriceList.adapter = adapter
        (activity as MainActivity).viewModel?.getLiveDataItems()
            ?.observe(requireActivity(), Observer {
                list.addAll(it as MutableList<GencyclerModel>)
                adapter.elements = list
                adapter.notifyDataSetChanged()
                Log.e("List", list.toString())
            })

    }
}


