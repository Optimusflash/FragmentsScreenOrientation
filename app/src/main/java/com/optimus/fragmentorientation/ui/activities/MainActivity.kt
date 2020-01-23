package com.optimus.fragmentorientation.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.optimus.fragmentorientation.R
import com.optimus.fragmentorientation.model.Language
import com.optimus.fragmentorientation.ui.fragments.DescriptionFragment
import com.optimus.fragmentorientation.ui.fragments.TitleFragment
import com.optimus.fragmentorientation.utils.ConstantManager
import com.optimus.fragmentorientation.utils.DataGenerator


class MainActivity : AppCompatActivity(), TitleFragment.OnSelectLanguageListener {

    private var isLandscape = false
    private var langId: Int = 0
    private var langObj: Language? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (findViewById<View>(R.id.description_container) != null) {
            isLandscape = true
        }
        if (savedInstanceState == null) {
            val titleFragment = TitleFragment.newInstance(null)
            supportFragmentManager.beginTransaction()
                .add(R.id.title_container, titleFragment)
                .commit()
        } else {
            langObj = savedInstanceState.getParcelable(ConstantManager.LANG_OBJ_TAG)
            if (isLandscape && langObj != null) {
                showDescription(langObj!!)
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("M_MainActivity", "onSaveInstanceState")
        outState.putParcelable(ConstantManager.LANG_OBJ_TAG, langObj)
    }

    override fun onItemClick(lang: Language) {
        langObj = lang
        if (isLandscape) {
            showDescription(lang)
        } else {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(ConstantManager.LANG_OBJ_TAG, lang)
            startActivity(intent)
        }

    }


    private fun showDescription(language: Language) {
        val bundle = Bundle().apply {
            putParcelable(ConstantManager.LANG_OBJ_TAG, language)
        }
        val fragmentDescription = DescriptionFragment.newInstance(bundle)
        Log.e("M_MainActivity", "fragment ${fragmentDescription.hashCode()}")
        supportFragmentManager.beginTransaction()
            .replace(R.id.description_container, fragmentDescription)
            .commit()
    }
}
