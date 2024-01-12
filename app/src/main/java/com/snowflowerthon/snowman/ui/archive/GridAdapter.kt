package com.snowflowerthon.snowman.ui.archive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.snowflowerthon.snowman.R
import com.snowflowerthon.snowman.data.dto.response.ArchiveDetailiResponseDto
import com.snowflowerthon.snowman.data.dto.response.VoteHistory
import com.snowflowerthon.snowman.data.enums.Clothes
import com.snowflowerthon.snowman.data.enums.Weather
import com.snowflowerthon.snowman.databinding.ItemCardBinding



class GridAdapter(private val dataList: List<VoteHistory>) :
    RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {

            binding.tvTime.text = dataList[position].voteTime

            when (dataList[position].weatherStatus) {
                Weather.CLEAR.toString() -> { binding.ivWeather.setImageResource(R.drawable.img_sunny) }
                Weather.RAIN.toString() -> { binding.ivWeather.setImageResource(R.drawable.ic_rainy) }
                Weather.SNOW.toString() -> { binding.ivWeather.setImageResource(R.drawable.img_snowy) }
            }

            when (dataList[position].headWear){
                Clothes.BALACLAVA.toString() -> { binding.ivHeadWear.setImageResource(R.drawable.img_balaclava) }
                Clothes.EAR_MUFFS.toString() -> { binding.ivHeadWear.setImageResource(R.drawable.img_ear) }
                Clothes.NONE.toString() -> { binding.ivHeadWear.setImageResource(R.drawable.img_empty) }
            }

            when (dataList[position].neckWear){
                Clothes.SCARF.toString() -> { binding.ivNeckWear.setImageResource(R.drawable.img_muffler) }
                Clothes.NONE.toString() -> { binding.ivNeckWear.setImageResource(R.drawable.img_empty) }
            }

            when (dataList[position].outerWear){
                Clothes.SHORT_PADDING.toString() -> { binding.ivOuterWear.setImageResource(R.drawable.img_short_padding) }
                Clothes.LONG_PADDING.toString() -> { binding.ivOuterWear.setImageResource(R.drawable.img_long_padding) }
                Clothes.COAT.toString() -> { binding.ivOuterWear.setImageResource(R.drawable.img_coat) }
                Clothes.NONE.toString() -> { binding.ivOuterWear.setImageResource(R.drawable.img_empty) }
            }

            when (dataList[position].topWear){
                Clothes.LONG_SLEEVE.toString() -> { binding.ivTopWear.setImageResource(R.drawable.img_long_shirt) }
                Clothes.NEAT.toString() -> { binding.ivTopWear.setImageResource(R.drawable.img_neat) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = dataList.size
}