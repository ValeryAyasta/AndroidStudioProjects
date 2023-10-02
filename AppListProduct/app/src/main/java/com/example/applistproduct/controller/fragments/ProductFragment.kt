package com.example.applistproduct.controller.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applistproduct.R
import com.example.applistproduct.adapter.ProductAdapter
import com.example.applistproduct.models.ApiResponseHeader
import com.example.applistproduct.models.Product
import com.example.applistproduct.network.ProductService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductFragment : Fragment() {

    var products: List<Product> = ArrayList()
    lateinit var rvProduct: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvProduct = view.findViewById<RecyclerView>(R.id.rvProducts)

        val etProduct = view.findViewById<EditText>(R.id.tieProduct)
        val btFind = view.findViewById<Button>(R.id.btFind)

        var query : String

        btFind.setOnClickListener{
            query = etProduct.text.toString()
            loadProducts(view.context, query)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }


    private fun loadProducts(context: Context, query : String) {


        //llamar a retrofit

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/food/products/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val productService: ProductService = retrofit.create(ProductService::class.java)

        val apiKey : String = "42505b0feafb4b36a4f17ccb0d0ce4ad"

        val request = productService.getProducts(query, 50, apiKey)

        request.enqueue(object : Callback<ApiResponseHeader> {
            override fun onResponse(
                call: Call<ApiResponseHeader>,
                response: Response<ApiResponseHeader>
            ) {
                if (response.isSuccessful){
                    val products : List<Product> = response.body()!!.products

                    rvProduct.layoutManager = LinearLayoutManager(context)
                    rvProduct.adapter = ProductAdapter(products, context)

                }
            }

            override fun onFailure(call: Call<ApiResponseHeader>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}