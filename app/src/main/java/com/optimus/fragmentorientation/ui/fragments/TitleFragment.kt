package com.optimus.fragmentorientation.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.optimus.fragmentorientation.R
import com.optimus.fragmentorientation.utils.DataGenerator
import com.optimus.fragmentorientation.model.Language
import com.optimus.fragmentorientation.ui.adapters.LanguageAdapter
import kotlinx.android.synthetic.main.title_fragment.*
import java.lang.ClassCastException


/**
 * Created by Dmitriy Chebotar on 15.01.2020.
 */
class TitleFragment : Fragment() {

    private var onSelectLanguageListener: OnSelectLanguageListener? = null

    companion object {
        fun newInstance(args: Bundle?): TitleFragment {
            val fragment = TitleFragment()
            fragment.arguments = args
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.title_fragment, container, false)
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

            languageAdapter.updateData(DataGenerator.generateLanguage(context))
    }


    override fun onDetach() {
        super.onDetach()
        onSelectLanguageListener = null
    }

    interface OnSelectLanguageListener {
        fun onItemClick(lang: Language)
    }
}