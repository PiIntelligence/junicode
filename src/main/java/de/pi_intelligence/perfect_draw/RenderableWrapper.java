package de.pi_intelligence.perfect_draw;

import java.awt.*;

/**
 * Created by moe on 25/05/16.
 */
public abstract class RenderableWrapper<E extends Renderable> {

    public RenderableWrapper() {
    }

    public Bounds getPadding() {
        return padding;
    }

    public void setPadding(Bounds padding) {
        this.padding = padding;
    }

    public Bounds getMargin() {
        return margin;
    }

    public void setMargin(Bounds margin) {
        this.margin = margin;
    }

    public Bounds getSize() {
        return size;
    }

    public void setSize(Bounds size) {
        this.size = size;
    }

    private Bounds padding = new Bounds();
    private Bounds margin = new Bounds();
    private Bounds size = new Bounds();
    private E content;

    public RenderableWrapper(E content) {
        this.content = content;
    }


    public E getRawContent() {
        return content;
    }


    public void render(Graphics graphics) {
        content.render(graphics, size, margin, padding);
    }
}
