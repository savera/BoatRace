import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class RiverPainting extends JComponent {

	static BufferedImage boat;

	static BufferedImage boat2;

	int x = 0;

	int y = 100;

	int x2 = 0;

	int y2 = 500;

	public static void main(String[] args) {

	}

	RiverPainting() {

		try {

			boat = ImageIO.read(getClass().getResource("PlayerOne.png"));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		try {

			boat2 = ImageIO.read(getClass().getResource("PlayerTwo.png"));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();
		}

	}

	public void paint(Graphics g) {

		// g.drawOval(10, 10, 10, 10);

		g.drawImage(boat, x, y, null);

		g.drawImage(boat2, x2, y2, null);
	}

	public void increaseX() {

		x = x + 5;

		repaint();

	}

	public void increaseX2() {

		x2 = x2 + 5;

		repaint();

	}

	public void winner() {

		if (x == 425) {

			JOptionPane.showMessageDialog(null, "Player One WINS!!!!");

		} else if (x2 == 425) {

			JOptionPane.showMessageDialog(null, "Player Two WINS!!!!");

		}

	}
}
