package com.example.apuntesclasecdi.Components

import android.content.Context
import android.widget.Button
import android.widget.LinearLayout
import com.example.apuntesclasecdi.R


class ButtonsGrid(val context: Context, val parent: LinearLayout) {

    class ButtonsRow(val context: Context, val parent: LinearLayout) {
        private var buttons: MutableList<Button> = mutableListOf()
        private val linearLayout: LinearLayout = LinearLayout(context)

        init {
            linearLayout.orientation = LinearLayout.HORIZONTAL
            linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f
            )

            linearLayout.setBackgroundColor(context.getColor(R.color.teal_200))

            parent.addView(linearLayout)
        }

        fun AddNewButton(text: String) : Button {
            var bt = Button(context)
            bt.text = text

            bt.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f
            )

            linearLayout.addView(bt)
            buttons.add(bt)
            return bt
        }

    }

    private var rows: MutableList<ButtonsRow> = mutableListOf()

    fun AddNewRow() : ButtonsRow {
        val btRow = ButtonsRow(context, parent)

        rows.add(btRow)
        return btRow
    }

    fun GetRow(index: Int) : ButtonsRow? {
        if(index >= rows.count() || index < 0) {
            return null
        }

        return rows[index]
    }
}