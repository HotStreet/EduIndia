package hotstreet.com.eduindia;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class HomeActivity extends ActionBarActivity {

    public static final String STUDENTS_INDEX_URL= "http://eduindia.herokuapp.com/students.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ListView listView = (ListView)findViewById(R.id.list);
        AsyncTask<String, Void, String> students = getAllStudents();

//        for(int i =0;i<students.length();i++){

//        }
//        ArrayAdapter<String> studentsAdapters = new ArrayAdapter<String>(this, R.id.kuj_vi, students);
//        listView.setAdapter(studentsAdapters);
        try {
            String values = students.get();
//            JSONObject jsonObject = new JSONObject(values.);
//            for(int i=0;i<values.length;i++)
            System.out.println(values+">>>>>>>");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public android.os.AsyncTask<String, Void, String> getAllStudents(){
        JsonParser jsonParser = new JsonParser();
        return jsonParser.execute(STUDENTS_INDEX_URL);
    }
}
