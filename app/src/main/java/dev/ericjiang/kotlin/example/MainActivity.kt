package dev.ericjiang.kotlin.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    private val TAG = "@@ACTIVITY/MAIN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stockCode = findViewById<EditText>(R.id.form_edit_text)
        val searchBtn  = findViewById<Button>(R.id.search)

        val txtViewStockCode = findViewById<TextView>(R.id.txtView_StockCode)

        searchBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                /**
                 Accessing context from a qualified this
                 DOC: https://kotlinlang.org/docs/reference/this-expressions.html#qualified
                */
                val queue = Volley.newRequestQueue(this@MainActivity)
                val url = "https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=${stockCode.text}&apikey=${BuildConfig.ALPHAVANTAGE_API_KEY}"

                val stringRequest = JsonObjectRequest(Request.Method.GET, url,null,
                    // OMG lamdas are beautiful in Kotlin
                    Response.Listener { response ->
                        print( "Response is: ${response.toString(2)}")

                        txtViewStockCode.setText(stockCode.text.toString().toUpperCase())
                    },
                    Response.ErrorListener {
                        print("error")
                    })
                queue.add(stringRequest)
            }
        })
    }
}
