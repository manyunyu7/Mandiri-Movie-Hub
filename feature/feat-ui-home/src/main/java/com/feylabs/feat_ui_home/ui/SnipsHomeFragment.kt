package com.feylabs.feat_ui_home.ui

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.feylabs.core.base.BaseFragment
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

        binding.menuSnip.onClickListener {
            val deepLink = Uri.parse(getString(sharedR.string.route_movies_home)).buildUpon().build()
            findNavController().navigate(deepLink)
        }

        binding.menuUnboxingSector.onClickListener {
            val deepLink =
                Uri.parse(getString(sharedR.string.route_snips_unboxing_test)).buildUpon().build()
            findNavController().navigate(deepLink)
        }

        binding.menuUnboxingStock.onClickListener {
            val deepLink =
                Uri.parse(getString(sharedR.string.route_snips_unboxing_test)).buildUpon().build()
            findNavController().navigate(deepLink)
        }

        binding.pokemonList.setClickInterface(object : PokemonListAdapter.ItemInterface{
            override fun onClick(string: String) {
                val deepLink = Uri.parse(
                    getString(sharedR.string.route_movie_by_genre)
                        .replace("{genreId}", string)
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
        viewModel.getMovie()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initObserver()
        initAction()
        initData()
    }







}


