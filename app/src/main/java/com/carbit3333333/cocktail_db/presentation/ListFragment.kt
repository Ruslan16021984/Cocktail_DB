package com.carbit3333333.cocktail_db.presentation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.carbit3333333.cocktail_db.MainActivity
import com.carbit3333333.cocktail_db.R
import com.carbit3333333.cocktail_db.adapters.AdapterCoctail2
import com.carbit3333333.cocktail_db.pojo.Cell
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
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter = AdapterCoctail2()
        var list = (activity as MainActivity).list
        rvCoinPriceList.adapter = adapter
        (activity as MainActivity).viewModel?.getLiveDataItems()
            ?.observe(requireActivity(), Observer {
                list.addAll(it as MutableList<Cell>)
                adapter.items = list as ArrayList<Cell>
                adapter.notifyDataSetChanged()
            })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.filter_main, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        NavigationUI.onNavDestinationSelected(item, findNavController());
        return super.onOptionsItemSelected(item);

    }
}


