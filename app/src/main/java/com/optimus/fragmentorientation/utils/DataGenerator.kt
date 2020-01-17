package com.optimus.fragmentorientation.utils

import android.content.Context
import com.optimus.fragmentorientation.R
import com.optimus.fragmentorientation.model.Language

/**
 * Created by Dmitriy Chebotar on 15.01.2020.
 */
object DataGenerator {

    fun generateLanguage(context: Context): List<Language> {
        val languageList: MutableList<Language> = mutableListOf()

        languageList.add(Language(1, "Java", context.resources.getString(R.string.lang_jav)))
        languageList.add(Language(2, "JavaScript", context.resources.getString(R.string.lang_jav_script)))
        languageList.add(Language(3, "C#", context.resources.getString(R.string.lang_c_sharp)))
        languageList.add(Language(4, "PHP", context.resources.getString(R.string.lang_php)))
        languageList.add(Language(5, "Python", context.resources.getString(R.string.lang_python)))
        languageList.add(Language(6, "C++", context.resources.getString(R.string.lang_с_plus_plus)))
        languageList.add(Language(7, "Swift", context.resources.getString(R.string.lang_swift)))
        languageList.add(Language(8, "Ruby", context.resources.getString(R.string.lang_ruby)))
        languageList.add(Language(9, "Kotlin", context.resources.getString(R.string.lang_kotlin)))
        languageList.add(Language(10, "C", context.resources.getString(R.string.с)))
        languageList.add(Language(11, "Objective-C", context.resources.getString(R.string.lang_objective_c)))

        return languageList
    }

}