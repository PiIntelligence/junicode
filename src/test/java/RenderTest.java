import de.pi_intelligence.perfect_draw.*;
import de.pi_intelligence.perfect_draw.Point;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by moe on 25/05/16.
 */
public class RenderTest {


    private BufferedImage getBufferedImage(int width, int height) {
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    @Test
    public void renderTest() {

        try {
            render(getOutputfile("rendertest.png"), new Text("Hallo Christian ", null).repeat(100));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private File getOutputfile(String s) {
        return new File(System.getProperty("user.dir") + "/out/rendertest/" + s);
    }

    private void render(File output, Renderable... renderable) throws IOException {
        BufferedImage bufferedImage = getBufferedImage(1024, 1024);
        Graphics graphics = bufferedImage.getGraphics();
        for (Renderable r : renderable) {
            r.render(graphics, new Bounds(0, 0, 700, 700,new Point((1024d-700d)/2d,50)));
        }
        ImageIO.write(bufferedImage, "PNG", output);
    }


}
