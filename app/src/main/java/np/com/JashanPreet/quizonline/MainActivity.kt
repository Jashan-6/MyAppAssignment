package np.com.bimalkafle.quizonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import np.com.bimalkafle.quizonline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var quizModelList: MutableList<QuizModel>
    lateinit var adapter: QuizListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizModelList = mutableListOf()

        // ✅ Now we load from local JSON, not Firebase
        getDataFromLocalJson()
    }

    private fun setupRecyclerView() {
        binding.progressBar.visibility = View.GONE
        adapter = QuizListAdapter(quizModelList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    // ✅ New function to read question.json from res/raw
    private fun getDataFromLocalJson() {
        binding.progressBar.visibility = View.VISIBLE

        // Read the JSON file from res/raw/question.json
        val inputStream = resources.openRawResource(R.raw.question)
        val jsonString = inputStream.bufferedReader().use { it.readText() }

        val gson = Gson()
        val listType = object : TypeToken<List<QuizModel>>() {}.type
        val quizzes: List<QuizModel> = gson.fromJson(jsonString, listType)

        quizModelList.clear()
        quizModelList.addAll(quizzes)

        setupRecyclerView()
    }
}
