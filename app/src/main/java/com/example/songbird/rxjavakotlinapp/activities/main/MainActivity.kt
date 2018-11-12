package com.example.songbird.rxjavakotlinapp.activities.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.songbird.rxjavakotlinapp.R
import com.example.songbird.rxjavakotlinapp.databinding.ActivityMainBinding
import com.example.songbird.rxjavakotlinapp.models.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var adapter: RepositoryAdapter = RepositoryAdapter(listOf<Repository>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Replaced with DataBindingUtil.setContentView
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //basicDataBindingExample()
        sophisticatedDataBindingWithRxExample()
    }

    //region Data Binding with RX Example
    private fun sophisticatedDataBindingWithRxExample() {
        // setup the ViewModel
        setupViewModel()

        // initialize RecyclerView
        setupUI()

    }

    private fun setupViewModel() {
        // The ViewModel will take care of all Business Logic

        // If we do it this way, we will get a new ViewModel every time MainActivity is recreated
        // This will not handle configuration changes
        //val viewModel = MainViewModel()

        // ViewModelProviders will create a new Instance if none exists
        // and will retrieve an already existing one if it exists and belongs to this Activity,
        // even if the this Activity is destroyed and recreated
        // This makes the ViewModel aware of the Activity's life cycle.
        // On configuration changes, we will receive the same ViewModel
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        // observe the repositories because it is a MutableLiveData<List<Repository>>
        // whenever new data comes in, we will update the adapter
        viewModel.repositories.observe(this, Observer<List<Repository>> {
            it?.let {
                adapter.repos = it
                adapter.notifyDataSetChanged()
            }
        })
        binding.viewModel = viewModel // declared in activity_main.xml
    }

    private fun setupUI() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
    //endregion

    //region Basic Data Binding Example
//    var repository = Repository("Test Repo", "Mladen Rakonjac", 1000)
//
//    private fun basicDataBindingExample() {
//        binding.repository = repository // originally declared in activity_main.xml
//        //binding.executePendingBindings() // not required
//        loadFakeRepo() // Load fake data and change the Repo instance and update the UI
//    }
//
//    private fun loadFakeRepo() {
//        Handler().postDelayed({
//            // these 2 fields are being observed so they will be updated whenever they change
//            repository.repoName = "Development Repo"
//            repository.repoOwner = "Chris Nguyen"
//
//            // this field is not being observed so it will not be updated whenever they change
//            // so we must update binding.repository to the updated repository variable
//            repository.numberOfStars = 345
//            binding.repository = repository
//
//            // binding.executePendingBindings() will not work
//            // until we reassign binding.repository to the updated repository instance
//            //binding.repository = repository
//
//            // Note: to solve this we will make Repository observable by extending BaseObservable
//            // then we will no longer need to call:
//            // binding.repository = repository
//        }, Constants.FAKE_NETWORK_DELAY)
//    }
    //endregion

}
