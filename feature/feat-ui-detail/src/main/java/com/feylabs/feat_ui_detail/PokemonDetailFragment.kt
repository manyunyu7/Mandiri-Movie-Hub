package com.feylabs.feat_ui_detail


import android.os.Bundle
import android.os.SystemClock
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import androidx.fragment.app.viewModels
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
                            binding.labelMovieTitle.text=name
//                            binding.labelMovieDate.text=releaseDate
//                            binding.labelProductionHouse.text=productionCompanies
//                            binding.labelGenres.text=genres

//                            if(videoUrl.isNotEmpty()){
//                                binding.trailerContainer.visible()
//                                val webView = binding.webView
//
//                                val view = binding.webView
//                                view.webViewClient = object : WebViewClient() {
//                                    override fun onPageFinished(view: WebView, url: String) {
//                                        super.onPageFinished(view, url)
//                                        // Inject JavaScript to hide the element with ID "title"
//                                        view.loadUrl("javascript:(function() { " +
//                                                "var element = document.getElementById('title'); " +
//                                                "element.style.display='none'; " +
//                                                "})()")
//                                        //emulateClick(view)
//                                    }
//                                }
//                                view.settings.setAppCacheEnabled(true)
//                                view.settings.javaScriptEnabled = true
//                                view.settings.setAppCachePath(requireContext().cacheDir.absolutePath)
//                                view.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
//                                view.settings.mediaPlaybackRequiresUserGesture = false
//                                view.loadUrl("${getFullPathVideoUrl()}")
//
//                            }else{
//                                binding.trailerContainer.gone()
//                            }
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