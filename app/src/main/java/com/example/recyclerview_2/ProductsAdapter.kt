package com.example.recyclerview_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// Adapter class for the RecyclerView
class ProductsAdapter(
    private val products: ArrayList<Product> // List of products to display
) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    // ViewHolder for each product item
    inner class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        // Views in the item layout
        val imgProduct: ImageView
        val txtProductTitle: TextView
        val txtProductPrice: TextView

        init {
            // Initialize views
            imgProduct = view.findViewById(R.id.imgProduct)
            txtProductTitle = view.findViewById(R.id.txtProductTitle)
            txtProductPrice = view.findViewById(R.id.txtProductPrice)

            // Set click listener to show a toast when item is clicked
            view.setOnClickListener {
                val product = products[adapterPosition]
                Toast.makeText(it.context, "Product Selected: ${product.title}", Toast.LENGTH_LONG).show()
            }
        }
    }

    // Return the number of items in the list
    override fun getItemCount() = products.size

    // Create a new ViewHolder instance
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.product_view, null)
        return ProductViewHolder(view)
    }

    // Bind data to the views in a ViewHolder
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.imgProduct.setImageResource(product.imageId)
        holder.txtProductPrice.text = product.title
        holder.txtProductTitle.text = "${product.price}"
    }
}
