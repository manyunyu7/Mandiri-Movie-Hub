package com.feylabs.feat_ui_detail


import android.os.Bundle
import android.os.SystemClock
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.feylabs.core.base.BaseFragment
import com.feylabs.core.helper.toast.ToastHelper.showToast
import com.feylabs.core.helper.view.ViewUtils.gone
import com.feylabs.core.helper.view.ViewUtils.visible
import com.feylabs.feat_ui_detail.databinding.FragmentPokemonDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class PokemonDetailFragment : BaseFragment<FragmentPokemonDetailBinding>(
    FragmentPokemonDetailBinding::inflate
) {


    val viewModel: PokemonDetailViewModel by viewModels()
    override fun initData() {
        viewModel.getPokemonDetail(getPokemonName())
    }

    private fun getPokemonName(): String {
        val pokemonName = arguments?.getString("name")
        return pokemonName.orEmpty()
    }

    override fun initObserver() {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.pokemonDetailValue.collect { value ->
                when {
                    value.isLoading -> {
                        binding.loadingIndicator.visible()
                    }

                    value.error.isNotBlank() -> {
                        showToast(value.error)
                    }

                    value.data != null -> {
                        binding.loadingIndicator.gone()
                        val movieData = value.data
                        movieData?.apply {
                            binding.labelPokemonName.text=name
                            binding.labelAbilities.text=abilities

                            Glide
                                .with(requireContext())
                                .load(this.backdrop)
                                .dontAnimate() //so there's no weird crossfade
                                .into(binding.imgBackdrop)

                            Glide
                                .with(requireContext())
                                .load(this.spriteFrontDefault)
                                .dontAnimate() //so there's no weird crossfade
                                .into(binding.imgCover)

                        }
                    }
                }
            }
        }
    }

    private fun emulateClick(webview: WebView?) {
        val delta: Long = 100
        val downTime = SystemClock.uptimeMillis()
        val x = (webview!!.left + webview.width / 2).toFloat() //in the middle of the webview
        val y = (webview.top + webview.height / 2).toFloat()
        val downEvent =
            MotionEvent.obtain(downTime, downTime + delta, MotionEvent.ACTION_DOWN, x, y, 0)
        // change the position of touch event, otherwise, it'll show the menu.
        val upEvent =
            MotionEvent.obtain(downTime, downTime + delta, MotionEvent.ACTION_UP, x + 10, y + 10, 0)
        webview.post {
            if (webview != null) {
                webview.dispatchTouchEvent(downEvent)
                webview.dispatchTouchEvent(upEvent)
            }
        }
    }


    override fun initUI() {

    }


    override fun initAction() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initData()
        initObserver()
        initAction()
    }
}