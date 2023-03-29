package id.co.sistema.githubuser

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.sistema.githubuser.Networking.ApiConfig
import id.co.sistema.githubuser.Networking.ApiService
import id.co.sistema.githubuser.Networking.ItemsItem
import id.co.sistema.githubuser.Networking.UserResponse
import id.co.sistema.githubuser.RecylerView.RvAdapter
import id.co.sistema.githubuser.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val adapter: RvAdapter by lazy {
        RvAdapter()
    }
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUserData()
        test()

    }

    private fun setUserData(){
        val layoutManager = GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
        binding.rvUser.layoutManager = layoutManager
        binding.rvUser.setHasFixedSize(true)
        binding.rvUser.adapter = adapter
    }

    private fun test(){
        viewModel.user.observe(this, {userResponse ->
            if (userResponse != null){
                adapter.addDataToList(userResponse)
                setUserData()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        return true
    }

//    private suspend fun test(){
//        val client = ApiConfig.getApiService().getListUsersAsync()
//        client.
//        client.enqueue(object : Callback<ItemsItem>{
//            override fun onResponse(call: Call<ItemsItem>, response: Response<ItemsItem>) {
//                if (response.isSuccessful){
//                    val dataa = response.body() as List<ItemsItem>
//                    Log.d("contoh", "onResponse: $dataa")
//                }
//            }
//
//            override fun onFailure(call: Call<ItemsItem>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//
//        })
//
//    }

}