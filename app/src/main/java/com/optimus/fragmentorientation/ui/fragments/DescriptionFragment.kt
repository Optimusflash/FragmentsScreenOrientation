package com.optimus.fragmentorientation.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.optimus.fragmentorientation.R
import com.optimus.fragmentorientation.model.Language
import com.optimus.fragmentorientation.utils.ConstantManager
import kotlinx.android.synthetic.main.detail_fragment.*

/**
 * Created by Dmitriy Chebotar on 15.01.2020.
 */
class DescriptionFragment : Fragment(R.layout.detail_fragment) {
    private var language : Language? =null

    companion object{
        fun newInstance(langObj: Language?): DescriptionFragment{
            val bundle = Bundle().apply {
                putParcelable(ConstantManager.LANG_OBJ_TAG, langObj)
            }
            val fragment = DescriptionFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("M_DescriptionFragment", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("M_DescriptionFragment", "onCreate")

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("M_DescriptionFragment", "onViewCreated")

        language = arguments?.getParcelable(ConstantManager.LANG_OBJ_TAG)
        language?.let {
            tv_language_description.text = view.resources.getString(it.description)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("M_DescriptionFragment", "onActivityCreated")

    }


    override fun onPause() {
        super.onPause()
        Log.e("M_DescriptionFragment", "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.e("M_DescriptionFragment", "onStop")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("M_DescriptionFragment", "onDestroyView")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("M_DescriptionFragment", "onDestroy")

    }

    override fun onDetach() {
        super.onDetach()
        Log.e("M_DescriptionFragment", "onDetach")

    }
}