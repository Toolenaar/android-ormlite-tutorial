package jtms.tutorial.ormLiteTutorial.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by alienware18 on 9-8-13.
 */

@DatabaseTable(tableName = "comments")
public class Comment {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField
    public String text;

    public Comment() {
        // ORMLite needs a no-arg constructor
    }

    public Comment(String text){
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
