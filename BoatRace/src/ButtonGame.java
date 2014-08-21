import java.applet.AudioClip;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ButtonGame implements KeyListener {

	int player1 = 0;

	int player2 = 0;

	JLabel tf = new JLabel();

	JLabel tf1 = new JLabel();

	JLabel tf2 = new JLabel();

	JLabel tf3 = new JLabel();

	RiverPainting rp = new RiverPainting();

	int HEIGHT = 1000;

	int WIDTH = 1000;

	public static void main(String[] args) {

		ButtonGame game = new ButtonGame();

		JOptionPane
				.showMessageDialog(
						null,
						"Instruction:\n Press the key as fast as you can to get your boat to the end. \n Key number 1 is for player one. \n Key number 0 is for player two.");

		game.frame();

		playSound();
	}

	public void frame() {

		JFrame f = new JFrame();

		f.add(rp);

		f.setSize(HEIGHT, WIDTH);

		f.setVisible(true);

		JPanel p = new JPanel();

		f.add(p);

		f.addKeyListener(this);

		p.add(tf);

		p.setSize(700, 700);

		tf.setVisible(true);

		p.add(tf1);

		tf1.setVisible(true);

		tf.setText("Player 1 - ");

		p.add(tf2);

		tf1.setText("       ");

		tf2.setVisible(true);

		tf2.setText("Player 2 - ");

		p.add(tf3);

		tf3.setVisible(true);

		tf3.setText("       ");

		// tf.setText("" + player1);

		// tf1.setText("" + player2);

		// f.pack();

	}

	private void showImage(String fileName) {

		JFrame frame = new JFrame();

		URL imageURL = getClass().getResource("PlayerOne.png");

		// URL imageURL2 = getClass().getResource("PlayerTwo.png");

		Icon icon = new ImageIcon(imageURL);

		JLabel image = new JLabel(icon);

		frame.add(image);

		frame.setVisible(true);

		frame.pack();

	}

	public static void playSound() {

		AudioClip scream = JApplet.newAudioClip(ButtonGame.class
				.getResource("RowRowRowYourBoat.aif"));

		scream.play();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		System.out.println(e.getKeyCode());

		if (e.getKeyCode() == 39) {

			player1++;

			tf1.setText("" + player1);

			rp.increaseX();

		}
		if (e.getKeyCode() == 37) {

			player2++;

			tf3.setText("" + player2);

			rp.increaseX2();
		}

		rp.winner();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}