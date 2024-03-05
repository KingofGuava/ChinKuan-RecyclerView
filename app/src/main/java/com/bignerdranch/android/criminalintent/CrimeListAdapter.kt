package com.bignerdranch.android.criminalintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.databinding.ListItemCrimeBinding

class CrimeHolder(private val binding: ListItemCrimeBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class SeriousCrimeHolder(view: View) :
    RecyclerView.ViewHolder(view) {
    private val crimeTitle = view.findViewById<TextView>(R.id.scrime_title)
    private val crimeDate = view.findViewById<TextView>(R.id.scrime_date)
    private val actionButton = view.findViewById<Button>(R.id.actionButton)
    init {
        view.setOnClickListener {
            Toast.makeText(
                view.context,
                "crime clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    fun bind(crime: Crime) {
        crimeTitle.setText(crime.title)
        crimeDate.setText(crime.date.toString())

    }
}

class CrimeListAdapter(private val crimes: List<Crime>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
                val inflater = LayoutInflater.from(parent.context)

                if(viewType == 1){
                    val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
                    return CrimeHolder(binding)
                }
                else {
                    //val binding = SeriousCrimeBinding.inflate(inflater, parent, false)
                    val view = inflater.inflate(R.layout.serious_crime, parent, false)
                    return SeriousCrimeHolder(view)
                }
            }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val crime = crimes[position]

            if(holder is CrimeHolder){
                holder.bind(crime)
            }
            else if(holder is SeriousCrimeHolder){
                holder.bind(crime)
            }

        }

    override fun getItemViewType(position: Int): Int {
        return crimes[position].viewType
    }

    override fun getItemCount() = crimes.size
}
