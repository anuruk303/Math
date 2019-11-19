package com.android.example.mathnew

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.IntegerRes
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.android.example.mathnew.databinding.FragmentCalculatorBinding
import com.android.example.mathnew.databinding.FragmentSelectBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [calculator.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [calculator.newInstance] factory method to
 * create an instance of this fragment.
 *
 */

class calculator : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var x=0;
        var y=0;
        var z=0;
        val binding = DataBindingUtil.inflate<FragmentCalculatorBinding>(inflater, R.layout.fragment_calculator,container,false)
        val args = calculatorArgs.fromBundle(arguments!!)
        Log.i("calculator","Select${args.nameselect}")
        if(args.nameselect=="1") {
            binding.y.setVisibility(View.GONE)
            binding.z.setVisibility(View.GONE)
            binding.imageView.setImageResource(R.drawable.square)
        }else if(args.nameselect=="2") {
            binding.imageView.setImageResource(R.drawable.rectangle)
        }else if(args.nameselect=="3") {
            binding.imageView.setImageResource(R.drawable.pyramidsq)
        }else if(args.nameselect=="4") {
            binding.y.setVisibility(View.GONE)
            binding.z.setVisibility(View.GONE)
            binding.imageView.setImageResource(R.drawable.circle)
        }else if(args.nameselect=="5") {
            binding.z.setVisibility(View.GONE)
            binding.imageView.setImageResource(R.drawable.funnel)
        }else if(args.nameselect=="6") {
            binding.z.setVisibility(View.GONE)

            binding.imageView.setImageResource(R.drawable.cil)
        }

        binding.Submitbutton.setOnClickListener { view ->
            if(args.nameselect=="1") {
                if(binding.x.text.toString().isNullOrBlank()) {
                    Toast.makeText(context, "Please enter complete information.", Toast.LENGTH_LONG).show()
                }else{
                    var num1 = binding.x.text.toString()
                    x = Integer.parseInt(num1.toString())
                    Log.i("calculator","InputX = ${x}")
                    x = x * x * x;
                    Log.i("calculator","Anw = ${x}")
                    view.findNavController().navigate(calculatorDirections.actionCalculatorToAnswer("${x}","${args.nameselect}"))
                }
            }else if(args.nameselect=="2") {
                if(binding.x.text.toString().isNullOrBlank()||binding.y.text.toString().isNullOrBlank()||binding.z.text.toString().isNullOrBlank()) {
                    Toast.makeText(context, "Please enter complete information.", Toast.LENGTH_LONG).show()
                }else {
                    var num1 = binding.x.text
                    var num2 = binding.y.text
                    var num3 = binding.z.text
                    x = Integer.parseInt(num1.toString())
                    y = Integer.parseInt(num2.toString())
                    z = Integer.parseInt(num3.toString())
                    Log.i("calculator","InputX = ${x},InputY = ${y},InputZ = ${z}")
                    x = x * y * z;
                    Log.i("calculator","Anw = ${x}")
                    view.findNavController().navigate(calculatorDirections.actionCalculatorToAnswer("${x}","${args.nameselect}"))
                }
            }else if(args.nameselect=="3") {
                if(binding.x.text.toString().isNullOrBlank()||binding.y.text.toString().isNullOrBlank()||binding.z.text.toString().isNullOrBlank()) {
                    Toast.makeText(context, "Please enter complete information.", Toast.LENGTH_LONG).show()
                }else {
                    var num1 = binding.x.text
                    var num2 = binding.y.text
                    var num3 = binding.z.text
                    x = Integer.parseInt(num1.toString())
                    y = Integer.parseInt(num2.toString())
                    z = Integer.parseInt(num3.toString())
                    Log.i("calculator","InputX = ${x},InputY = ${y},InputZ = ${z}")
                    x = (x * y * z) / 3
                    Log.i("calculator","Anw = ${x}")
                    view.findNavController().navigate(calculatorDirections.actionCalculatorToAnswer("${x}","${args.nameselect}"))
                }
            }else if(args.nameselect=="4") {
                if(binding.x.text.toString().isNullOrBlank()) {
                    Toast.makeText(context, "Please enter complete information.", Toast.LENGTH_LONG).show()
                }else {
                    var num1 = binding.x.text
                    x = Integer.parseInt(num1.toString())
                    Log.i("calculator","InputX = ${x}")
                    x = (4 * x * x * x * 22) / 21
                    Log.i("calculator","Anw = ${x}")
                    view.findNavController().navigate(calculatorDirections.actionCalculatorToAnswer("${x}","${args.nameselect}"))
                }
            }else if(args.nameselect=="5") {
                if(binding.x.text.toString().isNullOrBlank()||binding.y.text.toString().isNullOrBlank()) {
                    Toast.makeText(context, "Please enter complete information.", Toast.LENGTH_LONG).show()
                }else {
                    var num1 = binding.x.text
                    var num2 = binding.y.text
                    Log.i("calculator","InputX = ${x},InputY = ${y}")
                    x = Integer.parseInt(num1.toString())
                    y = Integer.parseInt(num2.toString())
                    x = (x * y * 22) / 7
                    Log.i("calculator","Anw = ${x}")
                    view.findNavController().navigate(calculatorDirections.actionCalculatorToAnswer("${x}","${args.nameselect}"))
                }
            }else if(args.nameselect=="6") {
                if (binding.x.text.toString().isNullOrBlank() || binding.y.text.toString().isNullOrBlank()) {
                    Toast.makeText(context, "Please enter complete information.", Toast.LENGTH_LONG).show()
                } else {
                    var num1 = binding.x.text
                    var num2 = binding.y.text
                    x = Integer.parseInt(num1.toString())
                    y = Integer.parseInt(num2.toString())
                    Log.i("calculator","InputX = ${x},InputY = ${y}")
                    x = (x * x * 22 * y) / 21
                    Log.i("calculator","Anw = ${x}")
                    view.findNavController().navigate(calculatorDirections.actionCalculatorToAnswer("${x}","${args.nameselect}"))
                }
            }

        }

        return binding.root
    }


}

