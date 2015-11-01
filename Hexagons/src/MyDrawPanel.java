import javax.swing.*;
import java.awt.*;

/**
 * Created by User1 on 11/1/2015.
 */
public class MyDrawPanel extends JPanel{
    static int XSIZE = 200;
    static int YSIZE = 174;

    public void paintComponent (Graphics g) {
        Polygon hexagon = null;
        hexagon = fillHexagonPolygon(hexagon, 0, 0);

        g.setColor(Color.orange);
        fillWithHexagons(g,this.getWidth(),this.getHeight());

    }

    private Polygon fillHexagonPolygon (Polygon polygon, int xIndex, int yIndex) {
        int[] x,y;

        x = new int[]{150,50,0,50,150,200,150};
        y = new int[]{13,13,100,187,187,100,13};

        polygon = new Polygon(x,y,7);
        return polygon;
    }
    private static void drawHexagon(Graphics g, int xOffset, int yOffset) {
        int[] x,y;

        x = new int[]{XSIZE*3/4,XSIZE*1/4,0,XSIZE*1/4,XSIZE*3/4,XSIZE,XSIZE*3/4};
        y = new int[]{0,0,YSIZE/2,YSIZE,YSIZE,YSIZE/2,0};

        reCalc(x, y, xOffset, yOffset);

        for (int i = 0; i < x.length-1; i ++) {
            g.drawLine(x[i],y[i],x[i+1],y[i+1]);
        }
    }
    static void reCalc(int[] x, int[] y, int xOffset, int yOffset) {
        for (int i = 0; i < x.length; i  ++) {
            x[i]+=xOffset;
            y[i]+=yOffset;
        }
    }
    static void fillWithHexagons (Graphics g, int xWidth, int yHeight) {
        int xq = xWidth / XSIZE;
        int yq = yHeight / YSIZE;

        for (int i = 0; i < xq; i ++) {
            for (int j = 0; j < yq; j ++) {
                drawHexagon(g, (int) (i*XSIZE*1.5), j*YSIZE);
            }
        }
//
//        for (int i = 0; i <xq-1; i ++) {
//            for (int j = 1; j < yq-1; j ++) {
//                drawHexagon(g, (int) (i*XSIZE*1.5+XSIZE), (int) (j*YSIZE+YSIZE*.5));
//            }
//        }

    }


}
