package com.obaap.fragment_test

import android.app.Fragment
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.about_us.view.*

class AboutUs_frag:Fragment() {
    var lManager:RecyclerView.LayoutManager?=null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var v=inflater!!.inflate(R.layout.about_us,container,false)
        lManager=LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        v.rview!!.layoutManager=lManager
        var bid=v.findViewById<CoordinatorLayout>(R.id.bid)
        v.rview!!.adapter=MyAdapter(context,bid)

        return v
    }
}