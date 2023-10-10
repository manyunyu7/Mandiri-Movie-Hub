package com.feylabs.feat_ui_home.ui

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.feylabs.core.base.BaseFragment
import com.feylabs.core.helper.toast.ToastHelper.showToast
import com.feylabs.shared_dependencies.R as sharedR
import com.feylabs.feat_ui_home.databinding.FragmentSnipsHomeBinding
import com.feylabs.uikit.listcomponent.pokemon_list.PokemonListAdapter
import com.feylabs.uikit.listcomponent.uikitmodel.MovieGenreUIKitModel
import com.feylabs.uikit.listcomponent.uikitmodel.PokemonUiKitModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SnipsHomeFragment : BaseFragment<FragmentSnipsHomeBinding>(
    FragmentSnipsHomeBinding::inflate
) {

    val viewModel: SnipsHomeViewModel by viewModels()

    override fun initUI() {
        hideActionBar()
    }

    override fun initObserver() {

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.pokemonListValue.collect { state ->
                when {
                    state.isLoading -> {
                        // Show loading progress
                    }

                    state.error.isNotBlank() -> {
                        // Show error message
                    }

                    state.list.isNotEmpty() -> {
                        state.list.forEachIndexed { index, unboxingListItemUIModel ->
                        }
                        binding.pokemonList.addDatas(state.list.map {
                            PokemonUiKitModel(
                                title = it.name,
                                image = it.getImage(),
                                url = it.url
                            )
                        })
                    }
                }
            }
        }


    }

    override fun initAction() {

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.fetchPokemon(query.orEmpty())
                binding.pokemonList.clear()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Handle the text change in the search view
                // You might want to filter your Pokemon list based on the newText

                if(newText?.isEmpty() == true){
                    viewModel.fetchPokemon("")
                    binding.pokemonList.clear()
                }

                return true
            }
        })
        binding.pokemonList.setClickInterface(object : PokemonListAdapter.ItemInterface{
            override fun onClick(string: String) {
                val deepLink = Uri.parse(
                    getString(sharedR.string.route_pokemon_detail)
                        .replace("{name}", string)
                )
                    .buildUpon()
                    .build()

                val navOptions = NavOptions.Builder()
                    .setLaunchSingleTop(true)
                    .build()

                findNavController().navigate(deepLink, navOptions)
            }

        })

    }

    override fun initData() {
        viewModel.fetchPokemon("")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initObserver()
        initAction()
        initData()
    }







}


