package com.android.example.mathnew

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.android.example.mathnew.databinding.FragmentAnswerBinding
import com.android.example.mathnew.databinding.FragmentCalculatorBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Answer.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Answer.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class Answer : Fragment() {

    var anw="pp";
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = AnswerArgs.fromBundle(arguments!!)
        val binding = DataBindingUtil.inflate<FragmentAnswerBinding>(inflater, R.layout.fragment_answer,container,false)


        binding.answer.setText(args.anw)
        binding.Backbutton.setOnClickListener {view ->
            view.findNavController().navigate(R.id.action_answer_to_select)

        }
        if(args.form=="1") {
            binding.imageanw.setImageResource(R.drawable.square)
            anw="Square = ${binding.answer.text}"
        }else if(args.form=="2") {
            binding.imageanw.setImageResource(R.drawable.rectangle)
            anw="Rectangle = ${binding.answer.text}"
        }else if(args.form=="3") {
            binding.imageanw.setImageResource(R.drawable.pyramidsq)
            anw="Pyramid Square = ${binding.answer.text}"
        }else if(args.form=="4") {
            binding.imageanw.setImageResource(R.drawable.circle)
            anw="Circle = ${binding.answer.text}"
        }else if(args.form=="5") {
            binding.imageanw.setImageResource(R.drawable.funnel)
            anw="Funnel = ${binding.answer.text}"
        }else if(args.form=="6") {
            binding.imageanw.setImageResource(R.drawable.cylinder)
            anw="Cylinder = ${binding.answer.text}"
        }

        setHasOptionsMenu(true)
        return binding.root

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun getShareIntent() : Intent {
        //val args = Answer.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT,anw )
        return shareIntent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

}


