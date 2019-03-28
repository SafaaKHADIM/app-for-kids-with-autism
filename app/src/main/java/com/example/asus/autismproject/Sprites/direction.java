package com.example.asus.autismproject.Sprites;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;

public class direction extends Sprite{
    public direction(Game game, Image image, int x, int y, int height, int width) {
        super(game, image, x, y, height, width);
        setStatic(false);
    }
}
