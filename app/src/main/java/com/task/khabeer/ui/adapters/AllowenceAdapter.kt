package com.task.khabeer.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.task.domain.entities.model.response.allowences.Allowences
import com.task.khabeer.R
import com.task.khabeer.databinding.AdapterAllowencesBinding


class AllowenceAdapter(var context: Context, var results: ArrayList<Allowences>) :
RecyclerView.Adapter<AllowenceAdapter.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.getContext())
        val binding :AdapterAllowencesBinding=
            DataBindingUtil.inflate(layoutInflater, R.layout.adapter_allowences, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result=results[position]
        if (position>0)
        result.position=position.toString()
        holder.binding.result=result

        when(result.SAL_COMP_CODE)
        {
            "0"->{
                holder.binding.parent.setBackgroundColor(context.resources.getColor(R.color.plue1))
            }
            "1"->{
                holder.binding.parent.setBackgroundColor(context.resources.getColor(R.color.white))
            }
            "2"->{
                holder.binding.parent.setBackgroundColor(context.resources.getColor(R.color.plue2))

            }
            "101"->{
                holder.binding.parent.setBackgroundColor(context.resources.getColor(R.color.red1))

            }

        }


    }

    override fun getItemCount(): Int {
        return results.size
    }

    inner class ViewHolder( val binding: AdapterAllowencesBinding) :
        RecyclerView.ViewHolder(binding.getRoot()) {
    }






}