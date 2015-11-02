import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by User1 on 11/1/2015.
 */
public class MyDrawPanel extends JPanel {
    static int XSIZE = 200;
    static int YSIZE = 174;
    static int XQ = 0, YQ = 0;
    static ArrayList<Hexagon> hexes = new ArrayList<Hexagon>();

    MyDrawPanel(int width, int height) {
        XQ = width / XSIZE;
        YQ = height / YSIZE;

        getHexes();
    }

    public void paintComponent(Graphics g) {
        fillClickedHexagons(g);
        fillWithHexagons(g);
    }

    private Polygon hexOffsetPolygon(int xOffset, int yOffset) {
        Polygon polygon;
        int[] x, y;

        x = new int[]{XSIZE * 3 / 4, XSIZE * 1 / 4, 0, XSIZE * 1 / 4, XSIZE * 3 / 4, XSIZE, XSIZE * 3 / 4};
        y = new int[]{0, 0, YSIZE / 2, YSIZE, YSIZE, YSIZE / 2, 0};

        for (int i = 0; i < x.length; i++) {
            x[i] += xOffset;
            y[i] += yOffset;
        }

        polygon = new Polygon(x, y, 7);
        return polygon;
    }

    public void fillClickedHexagons(Graphics g) {

        for (int i = 0; i < hexes.size(); i++) {
            if (hexes.get(i).isChecked()) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.LIGHT_GRAY);
            }
            g.fillPolygon(hexOffsetPolygon(hexes.get(i).getMiddlePoint().x - XSIZE / 2, hexes.get(i).getMiddlePoint().y - YSIZE / 2));
        }

    }

    public void changeHexState(Point p) {
        int hexIndex = getNearestHex(p);
        hexes.get(hexIndex).changeState();
    }

    static private int getNearestHex(Point p) {
        long min = XSIZE * XSIZE; //cant be more
        int index = -1;

        for (int i = 0; i < hexes.size(); i++) {
            if (getDistance(p, hexes.get(i).getMiddlePoint()) < min) {
                index = i;
                min = getDistance(p, hexes.get(i).getMiddlePoint());
            }
        }
        return index;
    }

    static private long getDistance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    static private void getHexes() {
        for (int i = 0; i < XQ; i++) {
            for (int j = 0; j < YQ; j++) {
                hexes.add(new Hexagon(new Point((XSIZE * 1 / 2 + i * XSIZE * 3 / 2), YSIZE * j + YSIZE / 2)));
            }
        }

        for (int i = 0; i < XQ - 1; i++) {
            for (int j = 0; j < YQ - 1; j++) {
                hexes.add(new Hexagon(new Point((XSIZE * 5 / 4 + i * XSIZE * 3 / 2), YSIZE * j + YSIZE)));
            }
        }


    }

    private static void drawHexagon(Graphics g, int xOffset, int yOffset) {
        int[] x, y;

        x = new int[]{XSIZE * 3 / 4, XSIZE * 1 / 4, 0, XSIZE * 1 / 4, XSIZE * 3 / 4, XSIZE, XSIZE * 3 / 4};
        y = new int[]{0, 0, YSIZE / 2, YSIZE, YSIZE, YSIZE / 2, 0};

        reCalc(x, y, xOffset, yOffset);

        for (int i = 0; i < x.length - 1; i++) {
            g.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
        }
    }

    static void reCalc(int[] x, int[] y, int xOffset, int yOffset) {
        for (int i = 0; i < x.length; i++) {
            x[i] += xOffset;
            y[i] += yOffset;
        }
    }

    static void fillWithHexagons(Graphics g) {
        g.setColor(Color.black);


        for (int i = 0; i < XQ; i++) {
            for (int j = 0; j < YQ; j++) {
                drawHexagon(g, (i * XSIZE * 3 / 2), j * YSIZE);
            }
        }

        for (int i = 0; i < XQ - 1; i++) {
            for (int j = 0; j < YQ - 1; j++) {
                drawHexagon(g, (i * XSIZE * 3 / 2 + XSIZE * 3 / 4), (int) (j * YSIZE + YSIZE / 2));
            }
        }

    }


}
