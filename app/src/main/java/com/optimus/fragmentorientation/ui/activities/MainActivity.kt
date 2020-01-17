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

class MainActivity : AppCompatActivity(), TitleFragment.OnItemClickListener {

    private var isLandscape = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (findViewById<View>(R.id.description_container) != null) {
            isLandscape = true
        }
        Log.e("M_MainActivity", "savedInstanceState $savedInstanceState")
        if (savedInstanceState == null) {
            val titleFragment = TitleFragment.getInstance(null)
            supportFragmentManager.beginTransaction()
                .add(R.id.title_container, titleFragment)
                .commit()
        }

    }

    override fun onItemClick(lang: Language) {
        if (isLandscape) {
            val bundle = Bundle()
            bundle.putParcelable(ConstantManager.LANG_OBJ_TAG, lang)
            val fragmentDescription = DescriptionFragment.getInstance(bundle)
            Log.e("M_MainActivity", "fragment ${fragmentDescription.hashCode()}")
            supportFragmentManager.beginTransaction()
                .replace(R.id.description_container, fragmentDescription)
                .commit()
        } else {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(ConstantManager.LANG_OBJ_TAG, lang)
            startActivity(intent)
        }

    }
}
