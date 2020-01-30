package com.optimus.fragmentorientation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.optimus.fragmentorientation.R
import com.optimus.fragmentorientation.model.Language
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_language.view.*

/**
 * Created by Dmitriy Chebotar on 15.01.2020.
 */
class LanguageAdapter(val listener: (languageItem: Language) -> Unit) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    private var items : MutableList<Language> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_language, parent, false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


    fun updateData(newItems: List<Language>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer{
        override val containerView: View?
            get() = itemView

        fun bind(langItem: Language){
            val title = langItem.name
            itemView.language_title.text = title
            itemView.setOnClickListener {
                listener.invoke(langItem)
            }
        }
    }
}