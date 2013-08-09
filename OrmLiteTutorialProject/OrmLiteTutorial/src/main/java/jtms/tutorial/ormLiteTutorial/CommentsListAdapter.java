package jtms.tutorial.ormLiteTutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import jtms.tutorial.ormLiteTutorial.Model.Comment;

/**
 * Created by alienware18 on 9-8-13.
 */
public class CommentsListAdapter  extends BaseAdapter {


    private Context mContext;
    private ArrayList<Comment> mComments;
    private LayoutInflater inflater;

    public CommentsListAdapter(Context c, ArrayList<Comment> comments) {
        inflater = LayoutInflater.from(c);
        mContext = c;
        mComments = comments;
    }

    @Override
    public int getCount() {
        return mComments.size();
    }

    @Override
    public Object getItem(int position) {
        return mComments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TextView text;

        if(v == null) {
            v = inflater.inflate(R.layout.comment_list_item, parent, false);
            v.setTag(R.id.comment_list_item_textView, v.findViewById(R.id.comment_list_item_textView));
        }

        text = (TextView)v.getTag(R.id.comment_list_item_textView);
        //get the current item and set the text
        Comment item = (Comment)getItem(position);
        text.setText(item.getText());

        return v;
    }
}
