package com.obaap.fragment_test

import android.content.Context
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.my_layout.view.*
import java.io.File

class MyAdapter:RecyclerView.Adapter<MyAdapter.MyHolder> {
    var inflater:LayoutInflater?=null
    var context:Context?=null
    var path:String?=null
    var file:File?=null
    var files:Array<File>?=null
    var bid:CoordinatorLayout?=null
    constructor(context: Context, bid: CoordinatorLayout){
        this.bid=bid
        this.context=context
        path="/storage/emulated/0/WhatsApp/Media/WhatsApp Images/"
        file= File(path)
        if (!file!!.exists()){
            path="/storage/sdcard0/WhatsApp/Media/WhatsApp Images/"
        }
        files=file!!.listFiles()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        inflater= LayoutInflater.from(context)
        var v=inflater!!.inflate(R.layout.my_layout,parent,false)

        return MyHolder(v)
    }

    override fun getItemCount(): Int {
            return files!!.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var f = files!!.get(position)
        var size="${f.length()} bytes"
        var bmp=BitmapFactory.decodeFile(f.path)
        var t_bmp= ThumbnailUtils.extractThumbnail(bmp,150,150)
        holder.iview!!.setImageBitmap(t_bmp)
        holder.name.text=f.name
        holder.size.text=size
        holder.delete.setOnClickListener {
            var sBar= Snackbar.make(bid!!,"Are you sure want to delete?",Snackbar.LENGTH_LONG)
            sBar.setAction("Yes", View.OnClickListener {
                f.delete()
                files=file!!.listFiles()
                this@MyAdapter.notifyDataSetChanged()
            })
            sBar.show()
        }
    }

    class MyHolder(itemView:View?):RecyclerView.ViewHolder(itemView){
        var iview=itemView!!.iview
        var name=itemView!!.name
        var size=itemView!!.size
        var delete=itemView!!.delete

    }
}