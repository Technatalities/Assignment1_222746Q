package a222746q.com.example.assignment1

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_movie_activity.add_movie_description
import kotlinx.android.synthetic.main.add_movie_activity.conditional_language_checkbox
import kotlinx.android.synthetic.main.add_movie_activity.conditional_violence_checkbox
import kotlinx.android.synthetic.main.add_movie_activity.add_movie_language
import kotlinx.android.synthetic.main.add_movie_activity.add_movie_name
import kotlinx.android.synthetic.main.add_movie_activity.add_movie_release_date
import kotlinx.android.synthetic.main.add_movie_activity.submit_new_movie
import kotlinx.android.synthetic.main.add_movie_activity.not_suitable_for_all_checkbox

class AddMovieActivity : AppCompatActivity() {
    var checkedMovieLanguage: String = "English"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_movie_activity)
        add_movie_language.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedLang: Int) {
                when (checkedLang) {
                    R.id.english_language -> checkedMovieLanguage = "English"
                    R.id.chinese_language -> checkedMovieLanguage = "Chinese"
                    R.id.malay_language -> checkedMovieLanguage = "Malay"
                    R.id.tamil_language -> checkedMovieLanguage = "Tamil"
                }
            }
        })
        add_movie_language.check(R.id.english_language)

//        add_movie_language.setOnCheckedChangeListener(object: RadioGroup.OnCheckedChangeListener{
//            override fun onCheckedChanged(group: RadioGroup?, chekedLang: Int) {
//                if (chekedLang == R.id.english_language){
//                    checkedMovieLanguage = "English"
//                }
//                else if (chekedLang == R.id.chinese_language){
//                    checkedMovieLanguage = "Chinese"
//                }
//                else if (chekedLang == R.id.malay_language){
//                    checkedMovieLanguage = "Malay"
//                }
//                else if (chekedLang == R.id.tamil_language){
//                    checkedMovieLanguage = "Tamil"
//                }
//            }
//        })

        not_suitable_for_all_checkbox.setOnClickListener(){
            if (not_suitable_for_all_checkbox.isChecked) {
                conditional_violence_checkbox.visibility = CheckBox.VISIBLE
                conditional_language_checkbox.visibility = CheckBox.VISIBLE
            }
            else{
                conditional_violence_checkbox.visibility = CheckBox.GONE
                conditional_language_checkbox.visibility = CheckBox.GONE
            }
        }

        submit_new_movie.setOnClickListener{
            var error_bool : Boolean = false
            if (add_movie_name.text.toString().isEmpty())
            {
                error_bool = true
                add_movie_name.error = "Field Empty"
            }
            if (add_movie_description.text.toString().isEmpty())
            {
                error_bool = true
                add_movie_description.error = "Field Empty"
            }
            if (add_movie_release_date.text.toString().isEmpty())
            {
                error_bool = true
                add_movie_release_date.error = "Field Empty"
            }

            if (!error_bool){
                var conditional_violence : String = " "
                var conditional_language : String = " "
                var not_suitable_for_all : String = "False"

                val movie_name = add_movie_name.text
                val movie_description = add_movie_description.text
                val movie_release_date = add_movie_release_date.text
                if (not_suitable_for_all_checkbox.isChecked)
                {
                   not_suitable_for_all = "True"
                }
                if (conditional_violence_checkbox.isChecked)
                {
                    conditional_violence = "Violence"
                }
                if (conditional_language_checkbox.isChecked)
                {
                    conditional_language = "Language"
                }

                Toast.makeText(this, "Movie Title: $movie_name\n" +
                        "Movie Description: $movie_description\n" +
                        "Movie Release Date: $movie_release_date\n" +
                        "Movie Language: $checkedMovieLanguage\n" +
                        "Not Suitable For All: $not_suitable_for_all\n" +
                        "Conditional Violence: $conditional_violence\n" +
                        "Conditional Language: $conditional_language", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_movie, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}

