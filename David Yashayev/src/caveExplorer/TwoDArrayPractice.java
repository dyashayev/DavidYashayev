package caveExplorer;

public class TwoDArrayPractice {

	public static void main(String[] args) {
		String[][] pic = new String[6][10];
		for(int row = 0; row < pic.length;row++) {
			for(int col = 0; col < pic[row].length;col++) {
				pic[row][col] = " ";
			}
		}
		//drawHorizontalLine(pic,1);
		//drawVerticalLine(pic,1);
		//drawSlot(pic,4,5);
		drawBox(pic,0,0);
		print(pic);
	}

	/**
	 * A box looks like this
	 * 
	 * 		___
	 * 		|*|
	 * 		|_|
	 * 	
	 * but the * marks the coords of the box
	 * CATCH: No ArrayIndexOutofBoundsException
	 * but draw any portion of the box available	
	 * @param pic
	 * @param i
	 * @param j
	 */
	
	public static void drawBox(String[][] pic, int i, int j) {
		drawSlot(pic,i,j);
		drawSlot(pic,i+1,j);
		drawIfInBounds("_",pic,i+1,j);
		for(int col = j-1; col <= j+1; col++) {
			drawIfInBounds("_",pic,i-1,col);
		}
	}

	public static void drawIfInBounds(String string, String[][] pic, int i, int j) {
		//SPECIAL NOTE: Always check row before column
		//(IOW, check row exists before checking if a column exists in the row
		if(i >= 0 && i < pic.length && j >= 0 && j < pic[i].length) {
			pic[i][j] = string;
		}
		
	}

	/**
	 * A slot looks like this:
	 * 		| |
	 * It is two vertical lines with a space between them
	 * The coordinates, i, j are the coords of the space
	 * In other words, a slot is a vertical line in front of i,j and after i,j
	 * CATCH: No ArrayIndexOutOfBoundExceptions
	 * @param pic
	 * @param i
	 * @param j
	 */
	
	public static void drawSlot(String[][] pic, int i, int j) {
		if(i >= 0 && i < pic.length) {
			if(j > 0) {
				pic[i][j-1] = "|";
			}
			if(j < pic[i].length -1) {
				pic[i][j+1] = "|";
			}
		}
	}

	public static void drawVerticalLine(String[][] pic, int col) {
		for(int row = 0; row < pic.length;row++) {
			pic[row][col] = "|";
		}
	}

	public static void drawHorizontalLine(String[][] pic, int row) {
		for(int col = 0; col < pic[row].length;col++) {
			pic[row][col] = "-";
		}
	}

	public static void print(String[][] pic) {
		String result = "";
		for(int row = 0; row < pic.length;row++) {
			for(int col = 0; col < pic[row].length;col++) {
				result += pic[row][col];
			}
			result += "\n";
		}
	System.out.println(result);
	}

}
