package aufgabe41.phong;

import aufgabe41.*;

import java.awt.*;

/**
 * Created by Julian on 10.06.2014.
 */
public class Scene {

	private final Sphere[] ELEMENTS = new Sphere[] {
			new Sphere(new Vector3(105, 165, 50), 40),
			new Sphere(new Vector3(205, 165, 50), 40),
			new Sphere(new Vector3(305, 165, 50), 40),
			new Sphere(new Vector3(405, 165, 50), 40),
			new Sphere(new Vector3(505, 165, 50), 40)

			, new Sphere(new Vector3(115, 150, 160), 40),
			new Sphere(new Vector3(215, 150, 160), 40),
			new Sphere(new Vector3(315, 150, 160), 40),
			new Sphere(new Vector3(415, 150, 160), 40),
			new Sphere(new Vector3(515, 150, 160), 40)

            ,new Sphere(new Vector3(105, 265, 50), 40),
            new Sphere(new Vector3(205, 265, 50), 40),
            new Sphere(new Vector3(305, 265, 50), 40),
            new Sphere(new Vector3(405, 265, 50), 40),
            new Sphere(new Vector3(505, 265, 50), 40)

            ,new Sphere(new Vector3(105, 365, 50), 40),
            new Sphere(new Vector3(205, 365, 50), 40),
            new Sphere(new Vector3(305, 365, 50), 40),
            new Sphere(new Vector3(405, 365, 50), 40),
            new Sphere(new Vector3(505, 365, 50), 40)

            ,new Sphere(new Vector3(105, 465, 50), 40, new Vector3(1, 0, 0), 0.2),
            new Sphere(new Vector3(205, 465, 50), 40, new Vector3(0,1, 0), 0),
            new Sphere(new Vector3(305, 465, 50), 40, new Vector3(0.1, 1, 0.1), 0.7),
            new Sphere(new Vector3(405, 465, 50), 40, new Vector3(0, 0, 1), 0.4),
            new Sphere(new Vector3(505, 465, 50), 40, new Vector3(1, 0, 1), 0.25)

    };

	protected LightSource[] lights = new LightSource[] {
			new LightSource(new Vector3(200, 200, -100), new Vector3(0.6, 0.2,
					.2)),
			new LightSource(new Vector3(200, 0, -100), new Vector3(0.3, 0.3,
					.3)),

			new LightSource(new Vector3(600, 200, -100), new Vector3(0.3, 0.3,

					.3)) };

	private final AmbientLight ambient = new AmbientLight(new Vector3(0.1, 0.1,
			0.1));

	private final int H, W;

	public Scene(int w, int h) {
		this.H = h;
		this.W = w;
	}

	public void render(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.W, this.H);

		for (LightSource l : this.lights) {
			l.ZBuffer = new ZBuffer(l.position(), ELEMENTS, this.W, this.H);
		}

		ZBuffer view = new ZBuffer(ELEMENTS, this.W, this.H);

		Vector3 V = new Vector3(0, 0, 1);

		for (int x = 0; x < this.W; x++) {
			for (int y = 0; y < this.H; y++) {

				for (Sphere s : this.ELEMENTS) {

					if (s.test(x, y)) {
						Vector3 P = s.intersection(new Ray(x, y));
						if (P != null) {

							Vector3 N = P.subtract(s.position);

							if (view.isVisibleAt(x, y, s)) {
								Vector3 I = Vector3.Null();

								for (LightSource d : this.lights) {


									I = I.add(d.intensity(P, N, V, s.K, s.k_sp));
								}

                                I = I.add(ambient.intensity(s.K));

								draw(g, x, y, I.x, I.y, I.z);
							}
						}

					}

				}

			}
		}

	}

	public static void draw(Graphics g, int x, int y, double R, double G,
			double B) {
		g.setColor(new Color((float) Utils.clamp(R, 0, 1), (float) Utils.clamp(
				G, 0, 1), (float) Utils.clamp(B, 0, 1)));
		g.drawRect(x, y, 1, 1);
	}

}
