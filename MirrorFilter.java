package imagefilters;

import java.awt.Color;

import se.lth.cs.pt.images.ImageFilter;

public class MirrorFilter extends ImageFilter{

	protected MirrorFilter(String name) {
		super(name);
	}

	@Override
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		//Skapar en ny matris som skall inehålla kopian
		Color[][] mirrored = new Color[inPixels.length][inPixels[0].length];
		
		for(int i = 0; i < inPixels.length; i++) {
			for(int j = 0; j < inPixels[0].length; j++) {
				//Kopierar varje pixel till dess speglade position
				mirrored[i][inPixels[0].length-j-1]=inPixels[i][j];
			}
		}
		
		return mirrored;
	}

}
