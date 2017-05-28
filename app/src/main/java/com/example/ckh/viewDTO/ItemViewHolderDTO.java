package com.example.ckh.viewDTO;

import android.widget.TextView;

/**
 * Created by kalin on 2017-05-28.
 */

public class ItemViewHolderDTO {
    private TextView writer;
    private TextView score;
    private TextView date;
    private TextView contents;

    public TextView getWriter() {
        return writer;
    }

    public void setWriter(TextView writer) {
        this.writer = writer;
    }

    public TextView getScore() {
        return score;
    }

    public void setScore(TextView score) {
        this.score = score;
    }

    public TextView getDate() {
        return date;
    }

    public void setDate(TextView date) {
        this.date = date;
    }

    public TextView getContents() {
        return contents;
    }

    public void setContents(TextView contents) {
        this.contents = contents;
    }


}
