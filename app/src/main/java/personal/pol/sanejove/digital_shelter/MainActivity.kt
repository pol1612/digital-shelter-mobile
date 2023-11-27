package personal.pol.sanejove.digital_shelter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.*
import okio.IOException
import personal.pol.sanejove.digital_shelter.databinding.ActivityMainBinding
import personal.pol.sanejove.digital_shelter.model.Dog

class MainActivity : AppCompatActivity() {
    private lateinit var httpClient : OkHttpClient;

    private lateinit var binding : ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = getString(R.string.digital_shelter)

        binding = ActivityMainBinding.inflate(layoutInflater)


        var dogsList = getDogsList()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)


    }
    private fun getDogsList() : List<Dog> {
        var dogs : List<Dog> = mutableListOf<Dog>()

        httpClient =  OkHttpClient()
        var request = Request.Builder()
            .url("https://6ab1235c-32ba-4abd-918a-9731dcbc7593.mock.pstmn.io/dog")
            .build()

        httpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {

                if (response.isSuccessful) {
                    val responseBody = response.body?.string()
                    println(responseBody)
                    dogs = Gson().fromJson(responseBody, Array<Dog>::class.java).toList()

                    // Process the response on the main thread if needed
                    runOnUiThread {
                        // Update UI or perform other actions with the response
                        // For example, you can parse the JSON and display data in the RecyclerView
                        // Add your RecyclerView setup logic here
                    }
                } else {
                    // Handle unsuccessful response
                    println("Error: ${response.code}")
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                // Handle network failure
                println("Network Error: ${e.message}")
            }
        })
        return dogs
    }
}