package com.example.asus.autismproject.Sprites.Static_Object;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;
public class Myobject extends Sprite {
    public Myobject(Image image, int x, int y, int height, int width) {
        super( image, x, y, height, width);
        setStatic(true);
    }

}
