package jtms.tutorial.ormLiteTutorial;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import jtms.tutorial.ormLiteTutorial.Data.CommentsRepository;
import jtms.tutorial.ormLiteTutorial.Model.Comment;

public class MainActivity extends Activity {

    private CommentsRepository repos;
    private CommentsListAdapter adapter;
    private EditText txt;
    private Button btn;
    private ArrayList<Comment> comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get UI elements
        ListView listview = (ListView)this.findViewById(R.id.listView);
        btn = (Button)this.findViewById(R.id.button);
        txt = (EditText)this.findViewById(R.id.editText);

        //init the comments repository
        repos = new CommentsRepository(this);
        //get all comments
        comments = (ArrayList<Comment>)repos.getAll();
        //create and set adapter on the listview
        adapter = new CommentsListAdapter(this,comments);
        listview.setAdapter(adapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void OnCreateClick(View view){
        //get the text from the textfield and add it to the db
        Comment comment = new Comment(txt.getText().toString());
        repos.create(comment);
        //add to UI
        comments.add(comment);
        adapter.notifyDataSetChanged();
    }
    
}
