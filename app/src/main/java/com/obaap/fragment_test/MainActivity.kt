package com.obaap.fragment_test

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.view.View
import android.support.design.widget.Snackbar

class MainActivity : AppCompatActivity() {
    var fManager:FragmentManager?=null
    var tx:FragmentTransaction?=null
    var home:Home_frag?=null
    var courses:Courses_frag?=null
    var materials:Materials_frag?=null
    var faculty:Faculty_frag?=null
    var aboutUs:AboutUs_frag?=null
    var fab:FloatingActionButton?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        home= Home_frag()
        courses= Courses_frag()
        materials= Materials_frag()
        faculty= Faculty_frag()
        aboutUs= AboutUs_frag()
        fab=findViewById(R.id.fab)
        fManager=fragmentManager
        tx=fManager!!.beginTransaction()
        tx!!.add(R.id.Myfrag,home)
        tx!!.commit()
        fab!!.setOnClickListener {
           var sBar=Snackbar.make(findViewById<CoordinatorLayout>(R.id.clayout),"Are you sure want to exit",Snackbar.LENGTH_LONG)
            sBar.setAction("Yes",{
                this@MainActivity.finish()
            })
            sBar.show()
        }
    }
    fun load(v:View){
        when(v.id){
            R.id.btHome->{
                tx=fManager!!.beginTransaction()
                tx!!.replace(R.id.Myfrag,home)
                tx!!.addToBackStack("true")
            }
            R.id.btCourses->{
                tx=fManager!!.beginTransaction()
                tx!!.replace(R.id.Myfrag,courses)
                tx!!.addToBackStack("true")
            }
            R.id.btMaterials->{
                tx=fManager!!.beginTransaction()
                tx!!.replace(R.id.Myfrag,materials)
                tx!!.addToBackStack("true")
            }
            R.id.btFaculty->{
                tx=fManager!!.beginTransaction()
                tx!!.replace(R.id.Myfrag,faculty)
                tx!!.addToBackStack("true")
            }
            R.id.btAboutUs->{
                tx=fManager!!.beginTransaction()
                tx!!.replace(R.id.Myfrag,aboutUs)
                tx!!.addToBackStack("true")
            }
        }
        tx!!.commit()

    }
}
