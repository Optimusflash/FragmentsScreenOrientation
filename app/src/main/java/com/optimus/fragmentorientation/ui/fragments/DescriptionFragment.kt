package com.optimus.fragmentorientation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.optimus.fragmentorientation.R
import com.optimus.fragmentorientation.model.Language
import com.optimus.fragmentorientation.utils.ConstantManager
import kotlinx.android.synthetic.main.detail_fragment.*

/**
 * Created by Dmitriy Chebotar on 15.01.2020.
 */
class DescriptionFragment : Fragment() {
    private var language : Language? =null
    companion object{
        fun newInstance(args: Bundle?): DescriptionFragment{
            val fragment = DescriptionFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        language = arguments?.getParcelable(ConstantManager.LANG_OBJ_TAG)
        tv_language_description.text = language?.description

    }

}