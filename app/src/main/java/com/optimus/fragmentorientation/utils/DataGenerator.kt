package com.optimus.fragmentorientation.utils

import android.content.Context
import com.optimus.fragmentorientation.R
import com.optimus.fragmentorientation.model.Language

/**
 * Created by Dmitriy Chebotar on 15.01.2020.
 */
object DataGenerator {
    private var languageList: MutableList<Language> = mutableListOf()

    fun generateLanguage(context: Context): List<Language> {

        languageList = mutableListOf(
            Language(1, "Java", context.resources.getString(R.string.lang_jav)),
            Language(2, "JavaScript", context.resources.getString(R.string.lang_jav_script)),
            Language(3, "C#", context.resources.getString(R.string.lang_c_sharp)),
            Language(4, "PHP", context.resources.getString(R.string.lang_php)),
            Language(5, "Python", context.resources.getString(R.string.lang_python)),
            Language(6, "C++", context.resources.getString(R.string.lang_с_plus_plus)),
            Language(7, "Swift", context.resources.getString(R.string.lang_swift)),
            Language(8, "Ruby", context.resources.getString(R.string.lang_ruby)),
            Language(9, "Kotlin", context.resources.getString(R.string.lang_kotlin)),
            Language(10, "C", context.resources.getString(R.string.с)),
            Language(11, "Objective-C", context.resources.getString(R.string.lang_objective_c))
        )

        return languageList
    }

    fun getLanguageById(id: Int): Language? {
        val index = languageList.indexOfFirst { it.id == id }
        return languageList.getOrNull(index)
    }
}