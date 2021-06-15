package fr.mappy.fizzbuzz.ui.statistics

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import fr.mappy.fizzbuzz.R
import fr.mappy.fizzbuzz.data.models.FormEntity
import fr.mappy.fizzbuzz.databinding.StatisticFormLayoutBinding
import fr.mappy.fizzbuzz.presentation.StatisticsViewModel
import fr.mappy.fizzbuzz.utils.hide
import fr.mappy.fizzbuzz.utils.show

class StatisticsAdapter(
    private val context: Context,
    private val systemWidth: Int,
    private val viewModel: StatisticsViewModel
) :
    RecyclerView.Adapter<StatisticsAdapter.StatisticsViewHolder>() {

    private var resultList = listOf<FormEntity>()
    private var totalHits = 1
    private val density = Resources.getSystem().displayMetrics.density

    fun setResultList(result: List<FormEntity>) {
        resultList = result.sortedByDescending { formEntity -> formEntity.hits }
        totalHits = viewModel.getTotalHits(resultList)
        notifyDataSetChanged()
    }

    inner class StatisticsViewHolder(private val binding: StatisticFormLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(entity: FormEntity, position: Int) {
            binding.statisticInput1Int.text = entity.input1Int.toString()
            binding.statisticInput2Int.text = entity.input2Int.toString()
            binding.statisticInput1String.text = entity.input1String
            binding.statisticInput2String.text = entity.input2String
            binding.statisticHitValue.text = entity.hits.toString()
            binding.statisticId.text = context.getString(R.string.statistic_top, position + 1)
            decorateHitsView(entity)

            binding.statisticId.setOnClickListener {
                val detailLayout = binding.statisticDetail
                if (detailLayout.isVisible) {
                    detailLayout.hide()
                } else {
                    detailLayout.show()
                }
            }
        }

        private fun decorateHitsView(entity: FormEntity) {
            val layoutParam = binding.statisticHitView.layoutParams
            layoutParam.width = systemWidth.times(entity.hits).div(totalHits).div(density).toInt()
            binding.statisticHitView.layoutParams = layoutParam
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        val itemBinding =
            StatisticFormLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return StatisticsViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) {
        holder.bind(resultList[position], position)
    }

    override fun getItemCount(): Int = resultList.size
}