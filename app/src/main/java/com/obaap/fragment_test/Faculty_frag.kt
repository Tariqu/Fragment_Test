package com.obaap.fragment_test

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.home.view.*

class Faculty_frag:Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var v=inflater!!.inflate(R.layout.faculty,container,false)
        v.textView.text="Faculty Fragment"

        return v
    }
}