package com.example.applistproduct.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.applistproduct.R
import com.example.applistproduct.database.AppDatabase
import com.example.applistproduct.models.Product
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class ProductAdapter(val products: List<Product>, val context: Context) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view){
        val tvId = view.findViewById<TextView>(R.id.tvId)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val imPhoto = view.findViewById<ImageView>(R.id.imPhoto)
        val ibFavorite = view.findViewById<ImageButton>(R.id.ibFavorite)
        val cvProduct = view.findViewById<CardView>(R.id.cvProduct)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.prototype_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        holder.tvId.text = product.id.toString()
        holder.tvName.text = product.title

        val picassoBuilder = Picasso.Builder(context)

        picassoBuilder.downloader(OkHttp3Downloader(context))

        picassoBuilder.build().load(product.image)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imPhoto)

        holder.ibFavorite.setOnClickListener{
            AppDatabase.getInstance(context).getDao().insertProduct(product)
            Toast.makeText(context, "Added!", Toast.LENGTH_SHORT).show()
        }
    }
}