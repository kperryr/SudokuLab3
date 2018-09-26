package pkgGame;

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

	@Override
	public boolean hasDuplicates()
	{
		if (super.hasDuplicates())
			return true;
		
		for (int i = 0; i < this.getPuzzle().length; i++) {
			if (super.hasDuplicates(getRegion(i))) {
				return true;
			}
		}
	
		return false;
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
}

	

