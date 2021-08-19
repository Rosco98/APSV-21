package es.upm.dit.apsv.gatashop.images;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ImageDisplay extends JFrame{

	private static final int DEFAULT_WIDTH = 100;
	private static final int DEFAULT_HEIGHT = 100;	
	private static final String PATH = "src\\es\\upm\\dit\\apsv\\gatashop\\images\\";
	
	private JPanel panelImagen;
	private JLabel lblImagen;
	private Image picture;
	
	public ImageDisplay() throws MalformedURLException {
		setTitle("ImageTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        BufferedImage img2 = null;
		/*try {
			img = ImageIO.read(new File(PATH + "banana.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		URL img = new URL("https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fb%2Fb6%2FImage_created_with_a_mobile_phone.png&imgrefurl=https%3A%2F%2Fes.m.wikipedia.org%2Fwiki%2FArchivo%3AImage_created_with_a_mobile_phone.png&tbnid=nH5liarSz56duM&vet=12ahUKEwjtr-iXqo3yAhV08eAKHZNrD4kQMygAegUIARDMAQ..i&docid=oZbZ_9fuGU23yM&w=4000&h=3000&q=image&ved=2ahUKEwjtr-iXqo3yAhV08eAKHZNrD4kQMygAegUIARDMAQ");
        ImageIcon icon=new ImageIcon(img);
        JPanel panel=new JPanel(new BorderLayout());
        JLabel label=new JLabel("", icon, JLabel.CENTER);
        panel.add( label, BorderLayout.CENTER );
        
        
        /* JFrame frame=new JFrame(new BorderLayout());
        JLabel lbl=new JLabel("", icon, JLabel.CENTER);
        frame.setLayout(new FlowLayout());
        frame.setSize(DEFAULT_WIDTH*10,DEFAULT_HEIGHT);
        lbl.setIcon(icon);
        lbl.setSize(DEFAULT_WIDTH*3,DEFAULT_HEIGHT*3);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        */
	}
	
	
	
	

	public static void main(String[] args) throws Exception {
		ImageDisplay img = new ImageDisplay();

	}
}
