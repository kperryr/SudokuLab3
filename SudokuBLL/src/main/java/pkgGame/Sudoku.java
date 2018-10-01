package pkgGame;

import java.security.SecureRandom;


import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare{
	
	private int iSize;
	private int iSqrtSize;

	public Sudoku(int iSize) throws Exception {
		this.iSize=iSize;
		
		double sudosqrt= Math.sqrt(iSize);
		if (sudosqrt==Math.floor(sudosqrt)){
				if(!Double.isInfinite(sudosqrt)) {
					this.iSqrtSize= (int) sudosqrt;
				}
				else{
					throw new Exception("This cannot be a Sudoku size");
				}
		}	
	}
	
	
	public Sudoku(int[][] puzzle) throws Exception{
		super(puzzle);
		this.iSize=puzzle.length;
		
		double sudosqrt=Math.sqrt(iSize);
		if (sudosqrt==Math.floor(sudosqrt)){
			if(!Double.isInfinite(sudosqrt)) {
				this.iSqrtSize= (int) sudosqrt;
			}
			else{
				throw new Exception("This cannot be a  Sudoku size");
			}
		}	
	}
	
	
	protected int[][] getPuzzle(){
		return super.getLatinSquare();	
	}
	
	protected int[] getRegion(int iCol, int iRow) {
		int ireg =(iCol/iSqrtSize)+((iRow/iSqrtSize)*iSqrtSize);
		return getRegion(ireg);
	}
	
	protected int[] getRegion(int r) {
		int[] areg = new int[super.getLatinSquare().length];
		
		int row = (r / iSqrtSize)* iSqrtSize;
		int col = (r % iSqrtSize)* iSqrtSize;
		int colMax = col + iSqrtSize;
		int rowMax = row + iSqrtSize;
		int count = 0;
		
		for (;row < rowMax ; row++) {
			for(col = (r % iSqrtSize) * iSqrtSize; col < colMax; col++) {
				areg[count++]=super.getLatinSquare()[row][col];
			}
		}
		return areg;	
	}

	
	
	protected boolean isPartialSudoku() {
		boolean validPartial = true;

				if (hasDuplicates()==true)
					validPartial = false;
				if (ContainsZero() == false) {
					validPartial = false;
				}
				return validPartial;
	}
	
	protected boolean isSudoku(){
		boolean validSudoku = true;
		validSudoku = super.isLatinSquare();
		int x = (super.getLatinSquare().length -1);
		
		if (hasDuplicates() == true) {
			validSudoku = false;
		}
		if (super.isLatinSquare() == false) {
			validSudoku = false;
		}
		for (int i = 1; i <= x; i++) {
			if (hasAllValues(getRow(0), getRegion(i)) == false) {
				validSudoku = false;
			}
		}
		if (ContainsZero() == true) {
			validSudoku = false;
		}
		return validSudoku;
	}
	
	protected boolean isValidValue(int iCol, int iRow, int iValue) {
		boolean valCol = !(doesElementExist(getColumn(iCol),iValue));
		boolean valRow = !(doesElementExist(getColumn(iRow),iValue));
		boolean valValue = !(doesElementExist(getRegion(iCol,iRow),iValue));
		
		if( valCol && valRow && valValue == true) {
			return true;
		} else {
			return false;}
	}

	public void FillDiagonalRegion() {
		this.iSize=this.getPuzzle().length;
		for (int i=0;i<iSize;i+=iSqrtSize) {
			getRegionNbr(i,i);
			setRegion(getRegionNbr(i,i));
			shuffleRegion(getRegionNbr(i,i));
		}
	}
	public void PrintPuzzle() {
		this.iSize=this.getPuzzle().length;
		for (int i=0; i<iSize; i++) {
			System.out.print(" \n");
			for(int j=0; j<iSize; j++) {
				System.out.print(" ");
				int[][] puzz = this.getPuzzle();
				System.out.print(puzz[i][j]);
			}
					
			}
		}
	public static void shuffleArray(int[] ar) {
		SecureRandom rnum = new SecureRandom();  // Random number generator			

		for (int k=0; k <= ar.length -1; k++) {
		    int rP = rnum.nextInt(ar.length);
		    int temporary = ar[k];
		    ar[k] = ar[rP];
		    ar[rP] = temporary;
		}
	}

	public void shuffleRegion(int numReg) {

		int [] region = getRegion(numReg);
		shuffleArray(region);
		int[][] puzz= getPuzzle();

		int num=0;
		for (int i=(numReg/iSqrtSize)*iSqrtSize;i<((numReg/iSqrtSize)*iSqrtSize)+iSqrtSize;i++) {
			for (int j=(numReg%iSqrtSize)*iSqrtSize;j<((numReg%iSqrtSize)*iSqrtSize)+iSqrtSize;j++) {
				puzz[i][j] = region[num];
				num++;
			}

		}
	}

	public void setRegion(int numReg){
		int inum=1;
		int[][] puzz = getPuzzle();
		for (int i=(numReg/iSqrtSize)*iSqrtSize;i<((numReg/iSqrtSize)*iSqrtSize)+iSqrtSize;i++) {
			for (int j=(numReg%iSqrtSize)*iSqrtSize;j<((numReg%iSqrtSize)*iSqrtSize)+iSqrtSize;j++) {
				puzz[i][j]=inum++;
			}	
	}
	}


	public int getRegionNbr(int iCol, int iRow){
		int i = (iCol/iSqrtSize) + ((iRow/iSqrtSize)*iSqrtSize);
		return i;
	}
	
	
}

	

