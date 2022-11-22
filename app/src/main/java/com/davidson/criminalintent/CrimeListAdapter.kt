package com.davidson.criminalintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.davidson.criminalintent.databinding.ListItemCrimeBinding
import java.text.SimpleDateFormat
import java.util.*

val simpleDateFormat = SimpleDateFormat("EEEE, LLL dd, yyyy - HH:mm:ss aaa z")


class CrimeHolder(private val binding: ListItemCrimeBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime, onCrimeClicked: (crimeId: UUID) -> Unit) {
        binding.tvCrimeTitle.text = crime.title
        val dateFormatted = simpleDateFormat.format(crime.date)
        binding.tvCrimeDate.text = dateFormatted


        binding.root.setOnClickListener {
            onCrimeClicked(crime.id)
        }
        binding.ivCrimeSolved.visibility = if (crime.isSolved) View.VISIBLE else View.INVISIBLE
    }

}


class CrimeListAdapter(
    private val crimes: List<Crime>,
    private val onCrimeClicked: (crimeId: UUID) -> Unit
) :
    RecyclerView.Adapter<CrimeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime, onCrimeClicked)
    }

    override fun getItemCount(): Int {
        return crimes.size
    }
}