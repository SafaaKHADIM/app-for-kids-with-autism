package com.example.asus.autismproject.DAO;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "score")
public class Score {
    @PrimaryKey(autoGenerate = true)
    @NonNull

    private int _id;
    private String _category;
    private int _score;
    private int rightanswers;
    private int falseanswers;

    @NonNull
    public int get_id() {
        return _id;
    }

    public void set_id(@NonNull int _id) {
        this._id = _id;
    }

    public String get_category() {
        return _category;
    }

    public void set_category(String _category) {
        this._category = _category;
    }

    public int get_score() {
        return _score;
    }

    public void set_score(int _score) {
        this._score = _score;
    }

    public int getRightanswers() {
        return rightanswers;
    }

    public void setRightanswers(int rightanswers) {
        this.rightanswers = rightanswers;
    }

    public int getFalseanswers() {
        return falseanswers;
    }

    public void setFalseanswers(int falseanswers) {
        this.falseanswers = falseanswers;
    }

    public Score( int _score, int rightanswers,int falseanswers) {


        this._score = _score;
        this.rightanswers=rightanswers;
        this.falseanswers=falseanswers;
    }
}
