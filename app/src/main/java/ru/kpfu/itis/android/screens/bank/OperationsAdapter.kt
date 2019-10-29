package ru.kpfu.itis.android.screens.bank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.synthetic.main.list_item_operation_date_bank.view.*
import kotlinx.android.synthetic.main.list_item_operation_value_bank.view.*
import ru.kpfu.itis.android.screens.R

class OperationsAdapter :
    ListAdapter<OperationsListItem, BaseViewHolder<OperationsListItem>>(
        OperationsDiffUtilCallback()
    ) {

    companion object {
        private const val TYPE_DATE = 1
        private const val TYPE_OPERATION = 2
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<OperationsListItem> {
        return if (viewType == TYPE_DATE) {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_operation_date_bank, parent, false)
            DateViewHolder(itemView)
        } else {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_operation_value_bank, parent, false)
            OperationViewHolder(itemView)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).date != null
        ) {
            TYPE_DATE
        } else {
            TYPE_OPERATION
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<OperationsListItem>, position: Int) {
        holder.bind(getItem(position))
    }

    inner class DateViewHolder(itemView: View) : BaseViewHolder<OperationsListItem>(itemView) {

        override fun bind(item: OperationsListItem) {
            itemView.apply {
                tv_operation_date_list_item_bank.text = item.date
            }
        }
    }

    inner class OperationViewHolder(itemView: View) : BaseViewHolder<OperationsListItem>(itemView) {

        override fun bind(item: OperationsListItem) {
            itemView.apply {
                item.operation?.let {
                    if (it.isOut) {
                        iv_operation_icon_item_bank.setImageResource(R.drawable.ic_out_bank)
                    } else {
                        iv_operation_icon_item_bank.setImageResource(R.drawable.ic_in_bank)
                        tv_operation_money_item_bank.setTextColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.colorAccentBank
                            )
                        )
                    }
                    tv_operation_title_item_bank.text = it.title
                    tv_operation_money_item_bank.text = it.money
                }
            }
        }
    }
}

class OperationsDiffUtilCallback : DiffUtil.ItemCallback<OperationsListItem>() {

    override fun areItemsTheSame(
        oldItem: OperationsListItem,
        newItem: OperationsListItem
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: OperationsListItem,
        newItem: OperationsListItem
    ): Boolean {
        return oldItem == newItem
    }

}
