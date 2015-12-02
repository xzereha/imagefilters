package imagefilters;

import java.awt.Color;

import se.lth.cs.pt.images.ImageFilter;

public class GrayScaleFilter extends ImageFilter{
	//Vektor innehållande alla olika nyanser av grå
	private Color[] graylevels = new Color[256];
	
	protected GrayScaleFilter(String name) {
		super(name);
		
		//Fyller vektorn med alla färger i gråskalan
		for (int i = 0; i<=255; i++){
			graylevels[i] = new Color(i,i,i);
		}
		
	}

	
	@Override
	/**
	 * Ersätter bilden med en gråskalig bild
	 */
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		//Skapar en matris med intensiteten för varje pixel
		short[][] intensity = computeIntensity(inPixels);
		
		//Går igenom bild matrisen och ersätter alla pixlar med motsvarande gråskala
		for (int i = 0; i < inPixels.length; i++) {
			for (int j = 0; j < inPixels[0].length; j++) {
				inPixels[i][j]=graylevels[intensity[i][j]];
			}
		}
		
		return inPixels;
	}

}
