package com.android.example.mathnew

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.android.example.mathnew.databinding.FragmentSelectBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [select.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [select.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class select : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSelectBinding>(inflater, R.layout.fragment_select,container,false)
        binding.GButton.setOnClickListener {view ->
            view.findNavController().navigate(selectDirections.actionSelectToCalculator("1"))
        }
        binding.BButton.setOnClickListener {view ->
            view.findNavController().navigate(selectDirections.actionSelectToCalculator("2"))
        }
        binding.GButton2.setOnClickListener {view ->
            view.findNavController().navigate(selectDirections.actionSelectToCalculator("3"))
        }
        binding.GButton3.setOnClickListener {view ->
            view.findNavController().navigate(selectDirections.actionSelectToCalculator("4"))
        }
        binding.GButton5.setOnClickListener {view ->
            view.findNavController().navigate(selectDirections.actionSelectToCalculator("5"))
        }
        binding.GButton4.setOnClickListener {view ->
            view.findNavController().navigate(selectDirections.actionSelectToCalculator("6"))
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,view!!.findNavController())
                ||super.onOptionsItemSelected(item)
    }


}
