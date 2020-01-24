package com.optimus.fragmentorientation.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.optimus.fragmentorientation.R
import com.optimus.fragmentorientation.model.Language
import com.optimus.fragmentorientation.ui.fragments.DescriptionFragment
import com.optimus.fragmentorientation.ui.fragments.TitleFragment
import com.optimus.fragmentorientation.utils.ConstantManager


class MainActivity : AppCompatActivity(), TitleFragment.OnSelectLanguageListener {

        private var isLandscape = false
        private var langObj: Language? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("M_MainActivity", "onCreate")

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
                val fragment = supportFragmentManager.findFragmentById(R.id.description_container) as? DescriptionFragment
                Log.e("M_MainActivity", "${fragment.hashCode()}")
                val bundle = Bundle().apply {
                    putParcelable(ConstantManager.LANG_OBJ_TAG, langObj)
                }
                if(fragment==null){
                    val descriptionFragment = DescriptionFragment.newInstance(bundle)
                    supportFragmentManager.beginTransaction()
                        .add(R.id.description_container, descriptionFragment)
                        .commit()
                } else {
                    fragment.arguments = bundle
                }
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.e("M_MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("M_MainActivity", "onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.e("M_MainActivity", "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.e("M_MainActivity", "onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("M_MainActivity", "onDestroy")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
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
        val fragment = supportFragmentManager.findFragmentById(R.id.description_container) as? DescriptionFragment

        Log.e("M_MainActivity", "${fragment.hashCode()}")

        if (fragment == null) {
            val bundle = Bundle().apply {
                putParcelable(ConstantManager.LANG_OBJ_TAG, language)
            }
            val fragmentDescription = DescriptionFragment.newInstance(bundle)
            supportFragmentManager.beginTransaction()
                .replace(R.id.description_container, fragmentDescription)
                .commit()
        } else {
            fragment.updateDescription(language.description)
        }
    }
}
