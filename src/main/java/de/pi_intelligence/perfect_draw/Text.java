package de.pi_intelligence.perfect_draw;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by moe on 25/05/16.
 */
public class Text implements Renderable {
    private String text;
    private Map<? extends AttributedCharacterIterator.Attribute, ?> styleMap = new HashMap<>();

    public Text(String text, Map<? extends AttributedCharacterIterator.Attribute, ?> styleMap) {
        this.text = text;
        if (styleMap == null) {
            this.styleMap = new HashMap<>();
        } else {
            this.styleMap = styleMap;
        }

    }


    @Override
    public void render(Graphics graphics, Bounds size, Bounds margin, Bounds padding) {
        Graphics2D g2d = (Graphics2D) graphics;
        FontRenderContext context = g2d.getFontRenderContext();
       //Todo: do this somewhere else
        g2d.setColor(Color.black);
        g2d.setFont(g2d.getFont().deriveFont(20f));
        //Todo: use attribute
        AttributedString attributedString = new AttributedString(this.text, this.styleMap);
        LineBreakMeasurer measurer = new LineBreakMeasurer(attributedString.getIterator(), context);

        //This is the visual capital that we have
        float wrappingWidth = (float) (size.getWidth() - padding.getLeft() - padding.getRight());

        //TODO: if(wrappingWidth<=0) throw new Exception()
        while (measurer.getPosition() < this.text.length()) {

            TextLayout layout = measurer.nextLayout(wrappingWidth);

            size.offset(0, layout.getAscent());
            float dx = layout.isLeftToRight() ?
                    0 : (wrappingWidth - layout.getAdvance());
            Point offset = size.getOffset();
            layout.draw(g2d, (float) offset.getX() + dx, (float) offset.getY());
            size.offset(0, layout.getDescent() + layout.getLeading());
        }

    }

    public Text repeat(int repeat) {

        final String current = this.text;
        StringBuilder s = new StringBuilder();


        for (int i = 0; i < repeat; i++) {
            s.append(current);
        }

        this.text = s.toString();
        return this;


    }

}
