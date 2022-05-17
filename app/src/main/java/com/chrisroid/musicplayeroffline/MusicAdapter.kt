package com.chrisroid.musicplayeroffline

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chrisroid.musicplayeroffline.databinding.MusicViewBinding

class MusicAdapter(
    private val context: Context,
    private var musicList: ArrayList<Music>,
    private val playlistDetails: Boolean = false,
    private val selectionActivity: Boolean = false
) : RecyclerView.Adapter<MusicAdapter.MyHolder>() {

    class MyHolder(binding: MusicViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.songNameMV
        val album = binding.songAlbumMV
        val image = binding.imageMV
        val duration = binding.songDuration
        val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(MusicViewBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.title.text = musicList[position].title
        holder.album.text = musicList[position].album
        holder.duration.text = formatDuration(musicList[position].duration)
        Glide.with(context)
            .load(musicList[position].artUri)
            .apply(
                RequestOptions().placeholder(R.drawable.music_icon).centerCrop()
            ).into(holder.image)

        //for play next feature
        if (!selectionActivity) {

        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}