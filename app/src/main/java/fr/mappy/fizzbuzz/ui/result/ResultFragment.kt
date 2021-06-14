package fr.mappy.fizzbuzz.ui.result

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import fr.mappy.fizzbuzz.R
import fr.mappy.fizzbuzz.databinding.FragmentResultBinding
import fr.mappy.fizzbuzz.presentation.ResultViewModel
import fr.mappy.fizzbuzz.utils.hide
import fr.mappy.fizzbuzz.utils.show


class ResultFragment : Fragment(R.layout.fragment_result) {

    private val viewModel by activityViewModels<ResultViewModel>()
    private lateinit var resultAdapter: ResultAdapter
    private val args: ResultFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultAdapter = ResultAdapter(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentResultBinding.bind(view)
        viewModel.calculateResult(args.int1, args.int2, args.str1, args.str2, args.limit)

        binding.resultRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.resultRecyclerview.adapter = resultAdapter
        viewModel.calculatedResultList.observe(viewLifecycleOwner, { result ->
            if (result.isEmpty()) {
                binding.resultRecyclerview.hide()
                binding.progressBar.show()
            } else {
                resultAdapter.setResultList(result)
                binding.progressBar.hide()
                binding.resultRecyclerview.show()
            }
        })
    }
}