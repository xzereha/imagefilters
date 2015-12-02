package imagefilters;

import java.awt.Color;

import se.lth.cs.pt.images.ImageFilter;

public class GrayScaleFilter extends ImageFilter{
	//Vektor inneh�llande alla olika nyanser av gr�
	private Color[] graylevels = new Color[256];
	
	protected GrayScaleFilter(String name) {
		super(name);
		
		//Fyller vektorn med alla f�rger i gr�skalan
		for (int i = 0; i<=255; i++){
			graylevels[i] = new Color(i,i,i);
		}
		
	}

	
	@Override
	/**
	 * Ers�tter bilden med en gr�skalig bild
	 */
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		//Skapar en matris med intensiteten f�r varje pixel
		short[][] intensity = computeIntensity(inPixels);
		
		//G�r igenom bild matrisen och ers�tter alla pixlar med motsvarande gr�skala
		for (int i = 0; i < inPixels.length; i++) {
			for (int j = 0; j < inPixels[0].length; j++) {
				inPixels[i][j]=graylevels[intensity[i][j]];
			}
		}
		
		return inPixels;
	}

}
