package de.pi_intelligence.perfect_draw;

import java.awt.*;

/**
 * Created by moe on 25/05/16.
 */
public interface Renderable {

    public void render(Graphics graphics, Bounds size, Bounds margin, Bounds padding);

    public default void render(Graphics graphics, Bounds size) {
        render(graphics, size, new Bounds(), new Bounds());
    }


}
