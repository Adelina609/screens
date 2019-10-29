package ru.kpfu.itis.android.screens.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bank.*
import ru.kpfu.itis.android.screens.R

class BankActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank)

        setupRecyclerView()
        setData()
    }

    private fun setupRecyclerView() {
        rv_operations_bank.adapter = OperationsAdapter()
    }

    private fun setData() {
        val operationsList = mutableListOf(
            OperationsListItem("Вчера"),
            OperationsListItem(
                operation = Operation(
                    false, "Зарплата", "+ 22 578,81 \u20BD"
                )
            ),
            OperationsListItem(
                operation = Operation(
                    true, "Вывод денег", "- 1 050 \u20BD"
                )
            ),
            OperationsListItem("29 сентября, пн"),
            OperationsListItem(
                operation = Operation(
                    true, "Вывод денег в две строки", "- 16 085,75 \u20BD"
                )
            ),
            OperationsListItem(
                operation = Operation(
                    true, "Вывод денег", "- 1 750 \u20BD"
                )
            ),
            OperationsListItem(
                operation = Operation(
                    false, "Бонусы", "+ 54,10 \u20BD"
                )
            ),
            OperationsListItem("25 сентября, пн"),
            OperationsListItem(
                operation = Operation(
                    false, "Аванс", "+ 20 000 \u20BD"
                )
            )
        )

        (rv_operations_bank.adapter as OperationsAdapter).submitList(operationsList)
    }
}
