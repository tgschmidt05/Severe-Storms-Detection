package TVS_V_1;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;

//TEMP//
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;

public class LoadData {
	private static final String imageUrl = "https://radblast.wunderground.com/cgi-bin/radar/WUNIDS_map?station=WHK&brand=wui&num=1&delay=50&type=C0V&frame=0&scale=1.000&noclutter=0&showstorms=0&mapx=400&mapy=240&centerx=400&centery=240&transx=0&transy=0&showlabels=0&severe=0&rainsnow=0&lightning=Hide&smooth=0&rand=24975527&lat=0&lon=0&label=you";
	private static final String destinationFile = "testRadar.gif";
	private static final int yMax = 459;
	private static final int xMax = 459;
	private static final int startX = 170;
	private static final int startY = 10;
	private static final int endX = 629;
	private static final int endY = 469;
	
	//TEMP//
	private static final int labelSize = 22;
	private JFrame frame = new JFrame();
	private JPanel gridPanel = new JPanel();
	private JLabel[] labelArray;
	private static final int neg64Kts = -16777120;
	private static final int neg50Kts = -16748384;
	private static final int neg36Kts = -16727872;
	private static final int neg26Kts = -16718848;
	private static final int neg20Kts = -16736768;
	private static final int neg10Kts = -16752128;
	private static final int neg1Kts = -5197648;
	private static final int zeroKts = -2236963;
	private static final int pos10Kts = -4145152;
	private static final int pos20Kts = -4155392;
	private static final int pos26Kts = -4165632;
	private static final int pos36Kts = -6277120;
	private static final int pos50Kts = -8388608;
	private static final int pos64Kts = -10485760;
	private static final int backround = -7895185;
	
	private static final int pos35or34kts = -6013184;
	private static final int neg30or29kts = -16722872; //2
	private static final int pos24or23kts = -4156672; //3
	private static final int neg25or24kts = -16720872; //4
	private static final int neg33or32kts = -16724872; //5
	private static final int pos32or31kts = -4693504; //6
	private static final int pos25or24kts = -4160512; //7
	private static final int pos19or18kts = -4151552; //8
	private static final int pos6or5kts = -3421381; //9
	private static final int pos33or32kts = -5221376; //10
	private static final int pos28or27kts = -4164352; //11
	private static final int neg34or33kts = -16725872; //12
	private static final int pos39or38kts = -6541056; //13
	private static final int neg3or2kts = -6643302; //14
	private static final int neg13or12kts = -16745728; //15
	private static final int neg22or21kts = -16731136; //16
	private static final int neg12or11kts = -16747520; //17
	private static final int neg19or18kts = -16740352; //18
	private static final int neg23or22kts = -16724992; //19
	private static final int pos18or17kts = -4150272; //20
	private static final int neg8or7kts = -12419774; //21
	private static final int neg35or34kts = -16730436; //22
	private static final int pos20or19kts = -4154112; //23
	private static final int pos34or33kts = -5485312; //24
	private static final int neg41or40kts = -16738128; //25
	private static final int pos47or46kts = -7332864; //26
	private static final int neg38or37kts = -16733000; //27
	private static final int pos63or62kts = -9961472; //28
	private static final int pos3or2kts = -2829172; //29
	private static final int pos11or10kts = -4146432; //30
	private static final int neg16or15kts = -16742144; //31
	private static final int neg55or54kts = -16755568; //32
	private static final int pos12or11kts = -4147712; //33
	private static final int pos57or56kts = -9175040; //34
	private static final int neg52or51kts = -16751976; //35
	private static final int neg61or60kts = -16766344; //36
	private static final int neg47or46kts = -16740692; //37
	private static final int pos4or3kts = -3026575; //38
	//private static final int zeroKts = -2236963; //39 (COPY)
	private static final int pos45or44kts = -7068928; //40 
	private static final int pos43or42kts = -6804992; //41
	private static final int pos49or48kts = -8124672; //42
	private static final int neg11or10kts = -15308010; //43
	private static final int neg4or3kts = -9531538; //44
	private static final int pos48or47kts = -7860736; //45
	private static final int neg57or56kts = -16759160; //46
	private static final int neg62or61kts = -16769936; //47
	private static final int neg48or47kts = -16745820; //48
	private static final int neg39or38kts = -16735564; //49
	private static final int pos62or61kts = -9699328; //50
	private static final int pos52or51kts = -8912896; //51
	private static final int pos51or50kts = -8650752; //52
	private static final int neg58or57kts = -16762752; //53
	private static final int pos61or60kts = -9437184; //54
	private static final int pos2or1kts = -2434366; //55
	private static final int neg63or62kts = -16773528; //56
	private static final int neg2or1kts = -4210753; //57
	private static final int whiteText1 = -1052689;
	private static final int water1 = -16769948; //America out of range water
	private static final int water2 = -16767874; //America in range water
	private static final int water3 = -15324579; //Canada out of range water
	private static final int water4 = -14928523; //Canada in range water
	
	private Color color0 = new Color(neg63or62kts); //EXTRA//
	private Color color1 = new Color(neg63or62kts);
	private Color color2 = new Color(neg62or61kts);
	private Color color3 = new Color(neg61or60kts);
	private Color color4 = new Color(neg58or57kts);
	private Color color5 = new Color(neg57or56kts);
	private Color color6 = new Color(neg55or54kts);
	private Color color7 = new Color(neg52or51kts);
	private Color color8 = new Color(neg48or47kts);
	private Color color9 = new Color(neg47or46kts);
	private Color color10 = new Color(neg41or40kts);
	private Color color11 = new Color(neg39or38kts);
	private Color color12 = new Color(neg38or37kts);
	private Color color13 = new Color(neg35or34kts);
	private Color color14 = new Color(neg34or33kts);
	private Color color15 = new Color(neg33or32kts);
	private Color color16 = new Color(neg30or29kts);
	private Color color17 = new Color(neg25or24kts);
	private Color color18 = new Color(neg23or22kts);
	private Color color19 = new Color(neg22or21kts);
	private Color color20 = new Color(neg19or18kts);
	private Color color21 = new Color(neg16or15kts);
	private Color color22 = new Color(neg13or12kts);
	private Color color23 = new Color(neg12or11kts);
	private Color color24 = new Color(neg11or10kts);
	private Color color25 = new Color(neg8or7kts);
	private Color color26 = new Color(neg4or3kts);
	private Color color27 = new Color(neg3or2kts);
	private Color color28 = new Color(neg2or1kts);
	private Color color29 = new Color(zeroKts);
	private Color color30 = new Color(pos2or1kts);
	private Color color31 = new Color(pos3or2kts);
	private Color color32 = new Color(pos4or3kts);
	private Color color33 = new Color(pos6or5kts);
	private Color color34 = new Color(pos11or10kts);
	private Color color35 = new Color(pos12or11kts);
	private Color color36 = new Color(pos18or17kts);
	private Color color37 = new Color(pos19or18kts);
	private Color color38 = new Color(pos20or19kts);
	private Color color39 = new Color(pos24or23kts);
	private Color color40 = new Color(pos25or24kts);
	private Color color41 = new Color(pos28or27kts);
	private Color color42 = new Color(pos32or31kts);
	private Color color43 = new Color(pos33or32kts);
	private Color color44 = new Color(pos34or33kts);
	private Color color45 = new Color(pos35or34kts);
	private Color color46 = new Color(pos39or38kts);
	private Color color47 = new Color(pos43or42kts);
	private Color color48 = new Color(pos45or44kts);
	private Color color49 = new Color(pos47or46kts);
	private Color color50 = new Color(pos48or47kts);
	private Color color51 = new Color(pos49or48kts);
	private Color color52 = new Color(pos51or50kts);
	private Color color53 = new Color(pos52or51kts);
	private Color color54 = new Color(pos57or56kts);
	private Color color55 = new Color(pos61or60kts);
	private Color color56 = new Color(pos62or61kts);
	private Color color57 = new Color(pos63or62kts);
	//END TEMP//
	
	
	private boolean velocityData = true;
	private boolean localHost = true;
	private URL url;
	private BufferedImage radarImage;
	private int[][] radarArray = null;
	

	private void saveImage() {
		try {
			URL url = new URL(imageUrl);
		    InputStream inputStream = url.openStream();
		    OutputStream outputStream = new FileOutputStream(destinationFile);

		    byte[] b = new byte[2048];
		    int length;
		    while ((length = inputStream.read(b)) != -1) {
		        outputStream.write(b, 0, length);
		    }

		    inputStream.close();
		    outputStream.close();
		}
		catch (IOException e) {
			System.out.println("URL exception encountered. Closing program...");
			System.exit(0);
		} 
	}
	
	public int[][] createArray() {
		radarArray = new int[endX - startX + 1][endY - startY + 1];
		try {
			if (!localHost) {
				this.saveImage();
				url = new URL(imageUrl);
				radarImage = ImageIO.read(url);
			}
			else {
				File fileLocation = new File(destinationFile);
				radarImage = ImageIO.read(fileLocation);
			}
			
			for (int xCount = startX; xCount <= endX; xCount++) {
				for (int yCount = startY; yCount <= endY; yCount++) {
					radarArray[xCount - 170][yCount - 10] = radarImage.getRGB(xCount, yCount);
				}
			}
		}
		catch (IOException e) {
			System.out.println("File reading during createArray() exception encountered. Closing program...");
			System.exit(0);
		}
		return radarArray;
	}
	
	/*
	 * Temporary methods for displaying an order of the missing pixels.
	 */
	public void displayTempPixels() {
		int frameSize = 58 * labelSize;
		labelArray = new JLabel[58];
		frame.setSize(frameSize, labelSize);
    	frame.setUndecorated(true);
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	gridPanel.setLayout(new GridLayout(0,58));
    	
    	
		for (int listIncrement = 0; listIncrement < 58; listIncrement++) {
			labelArray[listIncrement] = new JLabel();
    		gridPanel.add(labelArray[listIncrement]);
    		String textInt = Integer.toString(listIncrement);
    		labelArray[listIncrement].setText(textInt);
	        labelArray[listIncrement].setPreferredSize(new Dimension(labelSize, labelSize));
		    labelArray[listIncrement].setOpaque(true);
		}
		labelArray[0].setBackground(color0);
		labelArray[1].setBackground(color1);
		labelArray[2].setBackground(color2);
		labelArray[3].setBackground(color3);
		labelArray[4].setBackground(color4);
		labelArray[5].setBackground(color5);
		labelArray[6].setBackground(color6);
		labelArray[7].setBackground(color7);
		labelArray[8].setBackground(color8);
		labelArray[9].setBackground(color9);
		labelArray[10].setBackground(color10);
		labelArray[11].setBackground(color11);
		labelArray[12].setBackground(color12);
		labelArray[13].setBackground(color13);
		labelArray[14].setBackground(color14);
		labelArray[15].setBackground(color15);
		labelArray[16].setBackground(color16);
		labelArray[17].setBackground(color17);
		labelArray[18].setBackground(color18);
		labelArray[19].setBackground(color19);
		labelArray[20].setBackground(color20);
		labelArray[21].setBackground(color21);
		labelArray[22].setBackground(color22);
		labelArray[23].setBackground(color23);
		labelArray[24].setBackground(color24);
		labelArray[25].setBackground(color25);
		labelArray[26].setBackground(color26);
		labelArray[27].setBackground(color27);
		labelArray[28].setBackground(color28);
		labelArray[29].setBackground(color29);
		labelArray[30].setBackground(color30);
		labelArray[31].setBackground(color31);
		labelArray[32].setBackground(color32);
		labelArray[33].setBackground(color33);
		labelArray[34].setBackground(color34);
		labelArray[35].setBackground(color35);
		labelArray[36].setBackground(color36);
		labelArray[37].setBackground(color37);
		labelArray[38].setBackground(color38);
		labelArray[39].setBackground(color39);
		labelArray[40].setBackground(color40);
		labelArray[41].setBackground(color41);
		labelArray[42].setBackground(color42);
		labelArray[43].setBackground(color43);
		labelArray[44].setBackground(color44);
		labelArray[45].setBackground(color45);
		labelArray[46].setBackground(color46);
		labelArray[47].setBackground(color47);
		labelArray[48].setBackground(color48);
		labelArray[49].setBackground(color49);
		labelArray[50].setBackground(color50);
		labelArray[51].setBackground(color51);
		labelArray[52].setBackground(color52);
		labelArray[53].setBackground(color53);
		labelArray[54].setBackground(color54);
		labelArray[55].setBackground(color55);
		labelArray[56].setBackground(color56);
		labelArray[57].setBackground(color57);
		
		
		frame.add(gridPanel);
    	frame.pack();
    	frame.setVisible(true);
	}
	
	/*
	 *Temporary method for tracking down missing pixels from the identifiers.
	 */
	public void missingPixels() {
		ArrayList<Integer> missingPixels = new ArrayList<Integer>();
		for (int yIncrement = 0; yIncrement <= yMax; yIncrement++) {
			for (int xIncrement = 0; xIncrement <= xMax; xIncrement++) {
				if ((radarArray[xIncrement][yIncrement] != neg64Kts) && (radarArray[xIncrement][yIncrement] != neg50Kts) && 
						(radarArray[xIncrement][yIncrement] != neg36Kts) && (radarArray[xIncrement][yIncrement] != neg26Kts) && 
						(radarArray[xIncrement][yIncrement] != neg20Kts) && (radarArray[xIncrement][yIncrement] != neg10Kts) && 
						(radarArray[xIncrement][yIncrement] != neg1Kts) && (radarArray[xIncrement][yIncrement] != zeroKts) && 
						(radarArray[xIncrement][yIncrement] != pos10Kts) && (radarArray[xIncrement][yIncrement] != pos20Kts) && 
						(radarArray[xIncrement][yIncrement] != pos26Kts) && (radarArray[xIncrement][yIncrement] != pos36Kts) && 
						(radarArray[xIncrement][yIncrement] != pos50Kts) && (radarArray[xIncrement][yIncrement] != pos64Kts) && 
						(radarArray[xIncrement][yIncrement] != backround) && (radarArray[xIncrement][yIncrement] != -9671592) && 
						(radarArray[xIncrement][yIncrement] != -3618784) && (radarArray[xIncrement][yIncrement] != -16777216) &&
						(radarArray[xIncrement][yIncrement] != -1) && (!missingPixels.contains(radarArray[xIncrement][yIncrement])) && 
						(radarArray[xIncrement][yIncrement] != pos35or34kts) && (radarArray[xIncrement][yIncrement] != neg30or29kts) && 
						(radarArray[xIncrement][yIncrement] != pos24or23kts) && (radarArray[xIncrement][yIncrement] != neg25or24kts) && 
						(radarArray[xIncrement][yIncrement] != neg33or32kts) && (radarArray[xIncrement][yIncrement] != pos32or31kts) && 
						(radarArray[xIncrement][yIncrement] != pos25or24kts) && (radarArray[xIncrement][yIncrement] != pos19or18kts) && 
						(radarArray[xIncrement][yIncrement] != pos6or5kts) && (radarArray[xIncrement][yIncrement] != pos34or33kts) && 
						(radarArray[xIncrement][yIncrement] != pos28or27kts) && (radarArray[xIncrement][yIncrement] != neg35or34kts) && 
						(radarArray[xIncrement][yIncrement] != pos43or42kts) && (radarArray[xIncrement][yIncrement] != neg3or2kts) && 
						(radarArray[xIncrement][yIncrement] != neg13or12kts) && (radarArray[xIncrement][yIncrement] != neg22or21kts) &&
						(radarArray[xIncrement][yIncrement] != neg12or11kts) && (radarArray[xIncrement][yIncrement] != neg19or18kts) && 
						(radarArray[xIncrement][yIncrement] != neg23or22kts) && (radarArray[xIncrement][yIncrement] != pos18or17kts) &&
						(radarArray[xIncrement][yIncrement] != neg8or7kts) && (radarArray[xIncrement][yIncrement] != neg39or38kts) && 
						(radarArray[xIncrement][yIncrement] != pos20or19kts) && (radarArray[xIncrement][yIncrement] != pos33or32kts) &&
						(radarArray[xIncrement][yIncrement] != neg41or40kts) && (radarArray[xIncrement][yIncrement] != pos47or46kts) && 
						(radarArray[xIncrement][yIncrement] != neg34or33kts) && (radarArray[xIncrement][yIncrement] != pos63or62kts) &&
						(radarArray[xIncrement][yIncrement] != pos4or3kts) && (radarArray[xIncrement][yIncrement] != pos12or11kts) && 
						(radarArray[xIncrement][yIncrement] != neg16or15kts) && (radarArray[xIncrement][yIncrement] != neg57or56kts) &&
						(radarArray[xIncrement][yIncrement] != pos11or10kts) && (radarArray[xIncrement][yIncrement] != pos57or56kts) && 
						(radarArray[xIncrement][yIncrement] != neg52or51kts) && (radarArray[xIncrement][yIncrement] != neg62or61kts) &&
						(radarArray[xIncrement][yIncrement] != neg47or46kts) && (radarArray[xIncrement][yIncrement] != pos3or2kts) && 
						(radarArray[xIncrement][yIncrement] != whiteText1) && (radarArray[xIncrement][yIncrement] != pos45or44kts) && 
						(radarArray[xIncrement][yIncrement] != pos39or38kts) && (radarArray[xIncrement][yIncrement] != pos49or48kts) &&
						(radarArray[xIncrement][yIncrement] != neg11or10kts) && (radarArray[xIncrement][yIncrement] != neg4or3kts) && 
						(radarArray[xIncrement][yIncrement] != pos48or47kts) && (radarArray[xIncrement][yIncrement] != neg55or54kts) &&
						(radarArray[xIncrement][yIncrement] != neg61or60kts) && (radarArray[xIncrement][yIncrement] != neg48or47kts) && 
						(radarArray[xIncrement][yIncrement] != neg38or37kts) && (radarArray[xIncrement][yIncrement] != pos62or61kts) && 
						(radarArray[xIncrement][yIncrement] != pos52or51kts) && (radarArray[xIncrement][yIncrement] != pos51or50kts) && 
						(radarArray[xIncrement][yIncrement] != neg58or57kts) && (radarArray[xIncrement][yIncrement] != pos61or60kts) && 
						(radarArray[xIncrement][yIncrement] != pos2or1kts) && (radarArray[xIncrement][yIncrement] != neg63or62kts) && 
						(radarArray[xIncrement][yIncrement] != neg2or1kts) && (radarArray[xIncrement][yIncrement] != water3) &&
						(radarArray[xIncrement][yIncrement] != water4)) {
					missingPixels.add(radarImage.getRGB(xIncrement + 170, yIncrement + 10));
				}	
			}
		}
		/////temp//////
		missingPixels.add(radarImage.getRGB(417, 126));
		missingPixels.add(radarImage.getRGB(417, 127));
		/////end temp///
		if (missingPixels.size() != 0) {
			int frameSize = missingPixels.size() * labelSize;
			labelArray = new JLabel[missingPixels.size()];
			frame.setSize(frameSize, labelSize);
	    	frame.setUndecorated(true);
		    frame.setResizable(false);
		    frame.setLocationRelativeTo(null);
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	gridPanel.setLayout(new GridLayout(0,missingPixels.size()));
	    	System.out.print("[");
			for (int listIncrement = 0; listIncrement < missingPixels.size(); listIncrement++) {
				System.out.print(missingPixels.get(listIncrement));
				System.out.print("(" + (listIncrement + 1) + "), ");
				Color pixelColor = new Color(missingPixels.get(listIncrement));
				labelArray[listIncrement] = new JLabel();
        		gridPanel.add(labelArray[listIncrement]);
        		labelArray[listIncrement].setBackground(pixelColor);
        		String textInt = Integer.toString(listIncrement + 1);
        		labelArray[listIncrement].setText(textInt);
		        labelArray[listIncrement].setPreferredSize(new Dimension(labelSize, labelSize));
    		    labelArray[listIncrement].setOpaque(true);
			}
			System.out.println("]");
			frame.add(gridPanel);
	    	frame.pack();
	    	frame.setVisible(true);
		}
		else {
			System.out.println("No missing pixels detected...");
		}
	}
	
	public void displayLegend() {
		try {
			if (!localHost) {
				url = new URL(imageUrl);
				radarImage = ImageIO.read(url);
			}
			else {
				File fileLocation = new File(destinationFile);
				radarImage = ImageIO.read(fileLocation);
			}
			if (velocityData) {
				System.out.print("Dark Blue | -64 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,175));
				System.out.print("Blue | -50 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,195));
				System.out.print("Light Blue | -36 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,215));
				System.out.print("Light Green | -26 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,235));
				System.out.print("Green | -20 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,255));
				System.out.print("Dark Green | -10 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,275));
				System.out.print("Gray | -1 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,295));
				System.out.print("White | 0 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,315));
				System.out.print("Yellow | +10 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,335));
				System.out.print("Dark Yellow | +20 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,355));
				System.out.print("Orange | +26 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,375));
				System.out.print("Brown Red | +36 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,395));
				System.out.print("Red | +50 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,415));
				System.out.print("Extreme Red | +64 kts | RGB: ");
				System.out.println(radarImage.getRGB(108,435));
				System.out.print("Light Brown/Gray | Backround | RGB: ");
				System.out.println(radarImage.getRGB(170, 10));
			}
			else {
				System.out.print("Lightest Green | 5 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,175));
				System.out.print("Light Medium Green | 10 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,195));
				System.out.print("Medium Green | 15 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,215));
				System.out.print("Dark Medium Green | 20 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,235));
				System.out.print("Darkest Green | 25 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,255));
				System.out.print("Yellow | 30 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,275));
				System.out.print("Yellow Orange | 35 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,295));
				System.out.print("Orange | 40 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,315));
				System.out.print("Dark Orange | 45 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,335));
				System.out.print("Red | 50 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,355));
				System.out.print("Dark Red | 55 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,375));
				System.out.print("Pink | 60 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,395));
				System.out.print("Light Purple | 65 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,415));
				System.out.print("Purple | 70 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,435));
				System.out.print("Dark Purple | 75 dBZ | RGB: ");
				System.out.println(radarImage.getRGB(108,455));
				System.out.print("Light Brown/Gray | Backround | RGB: ");
				System.out.println(radarImage.getRGB(170, 10));
			}
		}
		catch (IOException e) {
			System.out.println("File reading during displayLegend() exception encountered. Closing program...");
			System.exit(0);
		}
	}
	
	//UNUSED//
	public void displayTextRadar() {
		System.out.println("");
		for (int yIncrement = 0; yIncrement <= yMax; yIncrement++) {
			for (int xIncrement = 0; xIncrement <= xMax; xIncrement++) {
				System.out.print("(" + xIncrement + "),");
				System.out.print("(" + yIncrement + ")");
				System.out.print(radarArray[xIncrement][yIncrement]);
				System.out.print("| ");
			}
			System.out.println("");
		}
	}
}