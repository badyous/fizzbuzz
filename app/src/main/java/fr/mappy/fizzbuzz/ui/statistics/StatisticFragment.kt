package fr.mappy.fizzbuzz.ui.statistics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import fr.mappy.fizzbuzz.R
import fr.mappy.fizzbuzz.databinding.FragmentStatisticBinding
import fr.mappy.fizzbuzz.presentation.StatisticsViewModel
import fr.mappy.fizzbuzz.utils.getScreenWidthPixels
import fr.mappy.fizzbuzz.utils.hide
import fr.mappy.fizzbuzz.utils.show
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class StatisticFragment : Fragment(R.layout.fragment_statistic) {

    private lateinit var binding: FragmentStatisticBinding
    private val viewModel by activityViewModels<StatisticsViewModel>()
    private lateinit var adapter: StatisticsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter =
            StatisticsAdapter(requireContext(), requireActivity().getScreenWidthPixels())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStatisticBinding.bind(view)

        retreiveTheTop5Forms()
    }

    private fun retreiveTheTop5Forms() {
        binding.statisticsProgressbar.show()
        binding.statisticRecyclerView.hide()
        viewModel.retreiveTop5FormsByHits()
        binding.statisticRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.statisticRecyclerView.adapter = adapter
        viewModel.statisticsResultList.observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                lifecycleScope.launch(Dispatchers.IO) {
                    val sortedList = it.sortedByDescending { formEntity -> formEntity.hits }
                    val totalHits = viewModel.getTotalHits(sortedList)
                    withContext(Dispatchers.Main) {
                        binding.statisticsProgressbar.hide()
                        binding.statisticRecyclerView.show()
                        binding.statisticsEmpty.hide()
                        binding.statisticTotalValue.text =
                            getString(R.string.statistic_total_hits, totalHits)
                        adapter.setResultList(sortedList, totalHits)
                    }
                }
            } else {
                binding.statisticsProgressbar.hide()
                binding.statisticRecyclerView.hide()
                binding.statisticsEmpty.show()
            }
        })
    }
}