package mx.dev.shell.android.ejemplohilt.flow.page1.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import mx.dev.shell.android.ejemplohilt.databinding.FragmentPage1Binding
import mx.dev.shell.android.ejemplohilt.flow.page1.vm.Page1ViewModel
import mx.dev.shell.android.ejemplohilt.flow.page1.vm.Page1ViewModelFactory
import javax.inject.Inject

@AndroidEntryPoint
class Page1Fragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: Page1ViewModelFactory

    private lateinit var binding: FragmentPage1Binding
    private lateinit var viewModel: Page1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPage1Binding.inflate(inflater, container, false)

        setupView()
        setupViewModel()
        observeViewModel()

        return binding.root
    }

    private fun observeViewModel() {
        viewModel.apply {
            loading.observe(this@Page1Fragment as LifecycleOwner) {
                binding.page1Progressbar.visibility = if (it) View.VISIBLE else View.GONE
            }

            result.observe(this@Page1Fragment as LifecycleOwner) {
                binding.page1TxtResult.text = it
            }

            errorMessage.observe(this@Page1Fragment as LifecycleOwner) {
                Snackbar.make(binding.page1Container, it, Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun setupView() {
        binding.page1SendButton.setOnClickListener {
            viewModel.queryInfo()
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(Page1ViewModel::class.java)
    }
}