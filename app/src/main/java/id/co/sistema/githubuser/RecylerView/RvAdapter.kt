package id.co.sistema.githubuser.RecylerView

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.sistema.githubuser.Networking.UserResponse

class RvAdapter: RecyclerView.Adapter<RvAdapter.MyViewHolder>() {
    private var listUserResponse = ArrayList<UserResponse>()

    class MyViewHolder(private var binding: ItemUser) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}