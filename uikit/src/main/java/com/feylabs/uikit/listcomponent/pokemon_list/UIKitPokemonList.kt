package com.feylabs.uikit.listcomponent.pokemon_list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.feylabs.uikit.R
import com.feylabs.uikit.databinding.CustomUikitListMovieGenresBinding
import com.feylabs.uikit.databinding.CustomUikitListPokemonBinding
import com.feylabs.uikit.listcomponent.uikitmodel.MovieGenreUIKitModel
import com.feylabs.uikit.listcomponent.uikitmodel.PokemonUiKitModel
import com.feylabs.uikit.util.RecyclerViewUtil.setStaggeredGridLayoutManager

class UIKitPokemonList : ConstraintLayout {

    private val skeletonCounts: Int = 6
    private val binding: CustomUikitListPokemonBinding =
        CustomUikitListPokemonBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )

    lateinit var onClickInterface : PokemonListAdapter.ItemInterface


    private val mAdapter by lazy { PokemonListAdapter() }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        if (isInEditMode.not()) {
            initRecyclerView()
            initAdapterClick()
            //loadDummyData()
        }

        showSkeleton()
    }

    fun loadDummyData() {
    }

    fun showSkeleton(count: Int = skeletonCounts) {
        val parentLayout = binding.uikitListUnboxingPokemonSkeletonContainer
        for (i in 1..count) {
            val include = LayoutInflater.from(parentLayout.context)
                .inflate(R.layout.uikit_skeleton_unboxing_sectoral_item, parentLayout, false)
            parentLayout.addView(include)
        }
        binding.uikitListUnboxingPokemonSkeletonContainer.visibility = View.VISIBLE
        binding.rvUikitListPokemon.visibility = View.GONE
    }

    fun hideSkeleton() {
//        val parentLayout = binding.uikitListUnboxingPokemonSkeletonContainer
        val parentLayout = binding.uikitListUnboxingPokemonSkeletonContainer
        parentLayout.removeAllViews()
        binding.uikitListUnboxingPokemonSkeletonContainer.visibility = View.GONE
        binding.rvUikitListPokemon.visibility = View.VISIBLE
    }

    private fun initAdapterClick() {
        mAdapter.setInterface(object : PokemonListAdapter.ItemInterface {

            override fun onClick(string: String) {
                if(::onClickInterface.isInitialized){
                    onClickInterface.onClick(string)
                }
            }
        })
    }

    fun setClickInterface(mInterface : PokemonListAdapter.ItemInterface){
        this.onClickInterface = mInterface
    }

    private fun initRecyclerView() {
        binding.rvUikitListPokemon.apply {
            this.adapter = mAdapter
            setStaggeredGridLayoutManager(3,false)
        }
    }

    private fun getItemCount() = mAdapter.itemCount

    fun addItem(item: PokemonUiKitModel) {
        val existingItemIndex = mAdapter.data.indexOfFirst { it.url == item.url }
        if (existingItemIndex != -1) {
            mAdapter.data[existingItemIndex] = item
            mAdapter.notifyItemChanged(existingItemIndex)
        } else {
            val position = mAdapter.itemCount
            mAdapter.data.add(item)
            mAdapter.notifyItemInserted(position)
        }
    }

    fun addDatas(datas: List<PokemonUiKitModel>) {
        val itemsToAdd = mutableListOf<PokemonUiKitModel>()
        for (item in datas) {
            val existingItemIndex = mAdapter.data.indexOfFirst { it.url == item.url }
            if (existingItemIndex != -1) {
                mAdapter.data[existingItemIndex] = item
                mAdapter.notifyItemChanged(existingItemIndex)
            } else {
                itemsToAdd.add(item)
            }
        }
        if (itemsToAdd.isNotEmpty()) {
            val positionStart = mAdapter.itemCount
            mAdapter.data.addAll(itemsToAdd)
            mAdapter.notifyItemRangeInserted(positionStart, itemsToAdd.size)
        }

        if (mAdapter.itemCount == 0) {
            showSkeleton(skeletonCounts)
        } else {
            hideSkeleton()
        }
    }

    fun onUnboxingItemClick(action: (() -> Unit)? = null) {
        if (action != null) {
        }
    }


    interface OnUnboxingSectoralListOnClickInterface{
        fun onClick(volume:String)
    }

}