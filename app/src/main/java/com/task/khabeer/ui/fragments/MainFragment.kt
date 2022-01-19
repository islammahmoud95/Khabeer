package com.task.khabeer.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.khabeer.R
import com.task.khabeer.app.ApplicationApp
import com.task.khabeer.databinding.FragmentMainBinding
import com.task.khabeer.ui.base.BaseFragment

import com.anychart.AnyChartView

import com.anychart.chart.common.dataentry.ValueDataEntry

import com.anychart.chart.common.dataentry.DataEntry

import com.anychart.AnyChart

import com.anychart.charts.Pie
import com.task.domain.entities.model.response.allowences.Allowences
import com.task.domain.entities.model.response.user.User
import com.task.khabeer.ui.adapters.AllowenceAdapter


class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun getLayoutId(): Int =R.layout.fragment_main
    val viewModel: MainViewModel by viewModels {
        MainViewModel.AttachedViewModelFactory(
            ((activity?.application) as ApplicationApp).payRollUseCases
        )
    }

    val allowences=ArrayList<Allowences>()
    val adapter by lazy {
        activity?.let { AllowenceAdapter(it,allowences) }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        InitObserver()
        viewModel.getPayRoll()
        mViewDataBinding.listItem.layoutManager=LinearLayoutManager(activity)
        mViewDataBinding.listItem.adapter=adapter

    }


    fun InitObserver(){

        viewModel.loading.observe(viewLifecycleOwner, {
            ShowProgress(it)

        })
        viewModel.viewModelChanged.observe(viewLifecycleOwner, {
            mViewDataBinding.viewModel=viewModel

        })

        viewModel.response.observe(viewLifecycleOwner, {
            showLongToast(it.Activation.toString())
            viewModel.employee= it.Payroll?.Employee?.get(0) ?: User()
            viewModel.allowences= (it.Payroll?.Allowences ?: ArrayList<Allowences>()) as ArrayList<Allowences>
            val pie = AnyChart.pie()

            val data: MutableList<DataEntry> = ArrayList()
            data.add(ValueDataEntry("",0))
            data.add(ValueDataEntry("",0))
            data.add(ValueDataEntry("",1000))
            data.add(ValueDataEntry("",2000))
            pie.labels().position("inside");
            pie.data(data)
            mViewDataBinding.anyChartView .setChart(pie)
            mViewDataBinding.date .text= it.Payroll?.Date ?: ""

            mViewDataBinding.viewModel=viewModel
            allowences.clear()
            allowences.add(Allowences("م",0,"","البند","","القيمة","0",true))
            it.Payroll?.Allowences?.let { it1 -> allowences.addAll(it1) }
            it.Payroll?.Deduction?.let { it1 -> allowences.addAll(it1) }

            adapter?.notifyDataSetChanged()
        })
        viewModel.errorResponse.observe(viewLifecycleOwner, {
            showLongToast(it)
        })

    }

}