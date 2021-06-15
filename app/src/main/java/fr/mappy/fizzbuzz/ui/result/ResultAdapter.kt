package fr.mappy.fizzbuzz.ui.result

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.mappy.fizzbuzz.databinding.ResultRowLayoutBinding

class ResultAdapter(private val context: Context) :
    RecyclerView.Adapter<ResultAdapter.ItemViewHolder>() {

    private var resultList = listOf<String>()

    fun setResultList(result: List<String>) {
        resultList = result
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemBinding =
            ResultRowLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(resultList[position])
    }

    override fun getItemCount(): Int = resultList.size


    inner class ItemViewHolder(private val binding: ResultRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: String) {
            binding.resultField.text = result
        }
    }
}

