package aufgabe41.phong;

import aufgabe41.*;

import java.awt.*;

/**
 * Created by Julian on 10.06.2014.
 */
public class Scene {

    private final double RADIUS = 30;

    private final Sphere[] ELEMENTS = new Sphere[]{
            new Sphere(new Vector3(105, 165, 10), RADIUS),
            new Sphere(new Vector3(205, 165, 10), RADIUS),
            new Sphere(new Vector3(305, 165, 10), RADIUS),
            new Sphere(new Vector3(405, 165, 10), RADIUS),
            new Sphere(new Vector3(505, 165, 10), RADIUS)

            , new Sphere(new Vector3(115, 150, 120), RADIUS),
            new Sphere(new Vector3(215, 150, 120), RADIUS),
            new Sphere(new Vector3(315, 150, 120), RADIUS),
            new Sphere(new Vector3(415, 150, 120), RADIUS),
            new Sphere(new Vector3(515, 150, 120), RADIUS)

            , new Sphere(new Vector3(105, 265, 10), RADIUS),
            new Sphere(new Vector3(205, 265, 10), RADIUS),
            new Sphere(new Vector3(305, 265, 10), RADIUS),
            new Sphere(new Vector3(405, 265, 10), RADIUS),
            new Sphere(new Vector3(505, 265, 10), RADIUS)

            , new Sphere(new Vector3(115, 250, 120), RADIUS),
            new Sphere(new Vector3(215, 250, 120), RADIUS),
            new Sphere(new Vector3(315, 250, 120), RADIUS),
            new Sphere(new Vector3(415, 250, 120), RADIUS),
            new Sphere(new Vector3(515, 250, 120), RADIUS)

            , new Sphere(new Vector3(105, 365, 10), RADIUS),
            new Sphere(new Vector3(205, 365, 10), RADIUS),
            new Sphere(new Vector3(305, 365, 10), RADIUS),
            new Sphere(new Vector3(405, 365, 10), RADIUS),
            new Sphere(new Vector3(505, 365, 10), RADIUS)

            , new Sphere(new Vector3(115, 350, 120), RADIUS),
            new Sphere(new Vector3(215, 350, 120), RADIUS),
            new Sphere(new Vector3(315, 350, 120), RADIUS),
            new Sphere(new Vector3(415, 350, 120), RADIUS),
            new Sphere(new Vector3(515, 350, 120), RADIUS)

            , new Sphere(new Vector3(105, 465, 10), RADIUS),
            new Sphere(new Vector3(205, 465, 10), RADIUS),
            new Sphere(new Vector3(305, 465, 10), RADIUS),
            new Sphere(new Vector3(405, 465, 10), RADIUS),
            new Sphere(new Vector3(505, 465, 10), RADIUS)

            , new Sphere(new Vector3(115, 450, 120), RADIUS),
            new Sphere(new Vector3(215, 450, 120), RADIUS),
            new Sphere(new Vector3(315, 450, 120), RADIUS),
            new Sphere(new Vector3(415, 450, 120), RADIUS),
            new Sphere(new Vector3(515, 450, 120), RADIUS)
    };

    protected DiffuseLight[] lights = new DiffuseLight[]{
            new DiffuseLight(new Vector3(200, 200, -200), new Vector3(0.1, 0.1, .9)),
            new DiffuseLight(new Vector3(200, 400, -200), new Vector3(0.9, 0.1, .1)),
            new DiffuseLight(new Vector3(600, 200, -200), new Vector3(0.1, 0.9, .1))
    };

    private final AmbientLight ambient = new AmbientLight(new Vector3(0.2, 0.2, 0.2));

    private final int H, W;

    public Scene(int w, int h) {
        this.H = h;
        this.W = w;
    }

    public void render(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.W, this.H);

        for (DiffuseLight l : this.lights) {
            l.ZBuffer = new ZBuffer(l.position(), ELEMENTS, this.W, this.H);
        }

        ZBuffer view = new ZBuffer(ELEMENTS, this.W, this.H);

        Vector3 V = new Vector3(0, 0, 1);

        for (int x = 0; x < this.W; x++) {
            for (int y = 0; y < this.H; y++) {

                for (Sphere s : this.ELEMENTS) {

                    if (s.test(x, y)) {
                        Vector3[] NORMAL_POSITION = s.normal(x, y);
                        Vector3 N = NORMAL_POSITION[0];
                        Vector3 P = NORMAL_POSITION[1];

                        if (view.isVisibleAt(x, y, s)) {
                            Vector3 I = Vector3.Null();
                            for (DiffuseLight d : this.lights) {
                                I = I.add(d.intensity(P, N, V, s.K));
                            }

                            I = I.add(ambient.intensity(s.K));

                            draw(g, x, y, I.x, I.y, I.z);
                        }


                    }

                }

            }
        }

    }

    public static void draw(Graphics g, int x, int y, double R, double G, double B) {
        g.setColor(new Color((float) Utils.clamp(R, 0, 1), (float) Utils.clamp(G, 0, 1), (float) Utils.clamp(B, 0, 1)));
        g.drawRect(x, y, 1, 1);
    }


}
