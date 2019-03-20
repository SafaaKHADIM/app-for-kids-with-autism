package com.example.asus.autismproject.DAO;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Implementation.AndroidSound;

@Entity(tableName = "object")

public class Object {
    @PrimaryKey
    @NonNull
    private String description;
    private String image;
    private String voice;
    private String categorie;

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Object(@NonNull String description, String image, String voice, String categorie) {
        this.description = description;
        this.image = image;
        this.voice = voice;
        this.categorie = categorie;
    }
}
