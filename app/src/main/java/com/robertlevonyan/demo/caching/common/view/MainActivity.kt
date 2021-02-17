package com.robertlevonyan.demo.caching.common.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.robertlevonyan.demo.caching.R
import com.robertlevonyan.demo.caching.common.view.dropboxstore.DropBoxStoreFragment
import com.robertlevonyan.demo.caching.common.view.objectbox.ObjectBoxFragment
import com.robertlevonyan.demo.caching.common.view.realm.RealmFragment
import com.robertlevonyan.demo.caching.common.view.room.RoomFragment
import com.robertlevonyan.demo.caching.common.view.sqldelight.SqlDelightFragment
import com.robertlevonyan.demo.caching.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
  private val viewModel: MainViewModel by viewModel()
  private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)
    viewModel.getData()

    binding.run {
      bnTabs.setOnNavigationItemSelectedListener {
        when (it.itemId) {
          R.id.bnDropBoxStore -> showScreen(DropBoxStoreFragment.newInstance(), R.string.title_dropbox_store)
          R.id.bnObjectBox -> showScreen(ObjectBoxFragment.newInstance(), R.string.title_object_box)
          R.id.bnRealm -> showScreen(RealmFragment.newInstance(), R.string.title_realm)
          R.id.bnRoom -> showScreen(RoomFragment.newInstance(), R.string.title_room)
          R.id.bnSqlDelight -> showScreen(SqlDelightFragment.newInstance(), R.string.title_sql_delight)
        }
        true
      }
      bnTabs.selectedItemId = R.id.bnDropBoxStore
    }
  }

  private fun showScreen(fragment: Fragment, titleRes: Int) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.containerMovies, fragment)
        .commit()
    supportActionBar?.title = getString(titleRes)
  }
}
