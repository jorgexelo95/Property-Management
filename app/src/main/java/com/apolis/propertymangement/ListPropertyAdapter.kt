package com.apolis.propertymangement

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apolis.propertymangement.Models.Properties
import kotlinx.android.synthetic.main.row_property_list_adapter.view.*

class ListPropertyAdapter(val context: Context, var list: ArrayList<Properties>) :
    RecyclerView.Adapter<ListPropertyAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(properties: Properties, position: Int) {
            itemView.text_view_id.text = properties.id
            itemView.text_view_property_address.text = properties.propertyaddress
            itemView.text_view_property_city.text = properties.propertycity
            itemView.text_view_property_country.text = properties.propertycountry
            itemView.text_view_property_mortgage.text = properties.propertymortageinfo
            itemView.text_view_property_price.text = properties.propertypurchaseprice
            itemView.text_view_property_state.text = properties.propertystate
            itemView.text_view_property_status.text = properties.propertystatus
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.row_property_list_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val property = list[position]
        holder.bindView(property, position)
    }
}