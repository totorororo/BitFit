package com.example.bitfit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class EntityAdapter (private val context: Context, private val mItems: List<Item>) :
    RecyclerView.Adapter<EntityAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // as you render a row.
        val titleText: TextView
        val valueText: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {

            // the public final member variables created above
            titleText = itemView.findViewById(R.id.itemTitle)
            valueText = itemView.findViewById(R.id.itemValue)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item: Item = mItems.get(position)

        holder.titleText.setText(item.title)
        holder.valueText.setText(item.value)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }


}
