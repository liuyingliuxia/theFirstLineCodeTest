package com.zeasn.thefirstlinecode.thirdchapter

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.zeasn.thefirstlinecode.R

class FirstFragment : Fragment() {
    companion object {
        const val TAG = "FirstFragment:"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG,"onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG,"onCreate")
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG,"onCreateView")
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e(TAG,"onActivityCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG,"onViewCreated!!!")
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG,"onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG,"onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(TAG,"onDetach")
    }
}