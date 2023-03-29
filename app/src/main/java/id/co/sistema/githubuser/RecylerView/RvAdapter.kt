package id.co.sistema.githubuser.RecylerView

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.co.sistema.githubuser.Networking.ItemsItem
import id.co.sistema.githubuser.Networking.UserResponse
import id.co.sistema.githubuser.databinding.ItemRowUserBinding

class RvAdapter: RecyclerView.Adapter<RvAdapter.MyViewHolder>() {
    private var listUserResponse = ArrayList<ItemsItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun addDataToList(items: ArrayList<ItemsItem>){
        listUserResponse.clear()
        listUserResponse.addAll(items)
    }

    class MyViewHolder(private var binding: ItemRowUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(userResponse: ItemsItem){
            binding.tvItemName.text = userResponse.login.toString()
            binding.tvUserGiturl.text = userResponse.htmlUrl.toString()
            Glide.with(binding.root)
                .load(userResponse.avatarUrl)
                .circleCrop()
                .into(binding.imgItemPhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(listUserResponse[position])
    }

    override fun getItemCount(): Int {
       return listUserResponse.size
    }


}