package com.optimus.fragmentorientation.ui.activities

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.optimus.fragmentorientation.R
import com.optimus.fragmentorientation.utils.ConstantManager
import com.optimus.fragmentorientation.model.Language
import com.optimus.fragmentorientation.ui.fragments.DescriptionFragment

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish()
            return
        }

        if (savedInstanceState == null) {
            val intent = intent
            val lang: Language? = intent.extras?.getParcelable(ConstantManager.LANG_OBJ_TAG)

            val fragmentDescription = DescriptionFragment.newInstance(lang)
            Log.e("M_DetailActivity", "${fragmentDescription.hashCode()}")

            supportFragmentManager.beginTransaction()
                .add(R.id.description_container, fragmentDescription)
                .commit()
        }
    }
}
