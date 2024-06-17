package com.example.loginapirest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.loginapirest.databinding.UserListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserListFragment: Fragment() {

    private lateinit var mBinding: UserListBinding

    private lateinit var mAdapter: UsersAdapter
    private lateinit var mGridLayout: GridLayoutManager

    private var userList = mutableListOf<UserEntity>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadUsers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = UserListBinding.inflate(inflater,container,false)
        initRecyclerView()
        return mBinding.root
    }

    private fun loadUsers() {
        val url = Constants.BASE_URL + Constants.API_PATH + Constants.USER_LIST_PATH

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            Log.i("Response", response.toString())

            val jsonList = response.optJSONArray(Constants.DATA_PROPERTY)?.toString()

            if (jsonList != null) {
                val mutableListType = object : TypeToken<MutableList<UserEntity>>() {}.type
                userList = Gson().fromJson(jsonList, mutableListType)
                mAdapter.updateUsers(userList) // Update adapter with new data
            } else {
                Log.e("Error", "Data array is null")
            }

        }, { error ->
            error.printStackTrace()
        })

        // Add the request to Volley's request queue
        LoginApplication.reqResApi.addToRequestQueue(jsonObjectRequest)
    }


    private fun initRecyclerView() {
        mAdapter = UsersAdapter(mutableListOf())
        mGridLayout = GridLayoutManager(requireContext(), 1)


        mBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter
        }
    }


}



