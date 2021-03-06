package com.optimus.fragmentorientation.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.optimus.fragmentorientation.R
import com.optimus.fragmentorientation.model.Language
import com.optimus.fragmentorientation.ui.adapters.LanguageAdapter
import com.optimus.fragmentorientation.utils.ConstantManager
import com.optimus.fragmentorientation.utils.DataGenerator
import kotlinx.android.synthetic.main.title_fragment.*


/**
 * Created by Dmitriy Chebotar on 15.01.2020.
 */
class TitleFragment : Fragment(R.layout.title_fragment) {

    private var onSelectLanguageListener: OnSelectLanguageListener? = null

    companion object {
        fun newInstance(langObj: Language?): TitleFragment {
            val bundle = Bundle().apply {
                putParcelable(ConstantManager.LANG_OBJ_TAG, langObj)
            }
            val fragment = TitleFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            onSelectLanguageListener = activity as OnSelectLanguageListener
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement OnItemClickListener")
        }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity == null) return

            val context = activity!!.applicationContext

            val languageAdapter = LanguageAdapter {
                onSelectLanguageListener?.onItemClick(it)

            }

            val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            with(recycler_view) {
                layoutManager = LinearLayoutManager(context)
                adapter = languageAdapter
                addItemDecoration(divider)
            }

            languageAdapter.updateData(DataGenerator.generateLanguage())
    }


    override fun onDetach() {
        super.onDetach()
        onSelectLanguageListener = null
    }

    interface OnSelectLanguageListener {
        fun onItemClick(lang: Language)
    }
}