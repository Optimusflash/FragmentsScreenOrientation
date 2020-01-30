package com.optimus.fragmentorientation.utils

import com.optimus.fragmentorientation.R
import com.optimus.fragmentorientation.model.Language

/**
 * Created by Dmitriy Chebotar on 15.01.2020.
 */
object DataGenerator {
    private var languageList: MutableList<Language> = mutableListOf()

    fun generateLanguage(): List<Language> {

        languageList = mutableListOf(
            Language(1, "Java", R.string.lang_jav),
            Language(2, "JavaScript", R.string.lang_jav_script),
            Language(3, "C#", R.string.lang_c_sharp),
            Language(4, "PHP", R.string.lang_php),
            Language(5, "Python", R.string.lang_python),
            Language(6, "C++", R.string.lang_с_plus_plus),
            Language(7, "Swift",R.string.lang_swift),
            Language(8, "Ruby", R.string.lang_ruby),
            Language(9, "Kotlin", R.string.lang_kotlin),
            Language(10, "C", R.string.с),
            Language(11, "Objective-C", R.string.lang_objective_c)
        )

        return languageList
    }

    fun getLanguageById(id: Int): Language? {
        val index = languageList.indexOfFirst { it.id == id }
        return languageList.getOrNull(index)
    }
}