package pkgGame;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SudokuTest {

	@Test
	public void getRegion_Test() {
		int[][] puzzle= {{1, 4, 3, 2}, {3, 2, 1, 4,}, {4, 1, 2, 3}, {2, 3, 4, 1}};
		int[] expectedReg = {4, 1, 2, 3};
		
		int[] region;
		try {
			Sudoku sp= new Sudoku(puzzle);
			region = sp.getRegion(2);
			System.out.println(Arrays.toString(region));			
			assertTrue(Arrays.equals(expectedReg, region));
		}catch (Exception e) {
			fail("test failed");
		}
		
	}

	@Test
	public void isSudoku_Test() {
		int[][] puzzle= {{1, 4, 3, 2}, {3, 2, 1, 4,}, {4, 1, 2, 3}, {2, 3, 4, 1}};
		try {
			Sudoku sp = new Sudoku(puzzle);
			assertTrue(sp.isSudoku());

		} catch (Exception e) {
			fail("test failed");
		}
	}
	
	@Test
	public void PartialSudoku_Test() {
		int[][] puzzle= {{1, 4, 3, 2}, {3, 2, 1, 4,}, {4, 1, 2, 3}, {2, 3, 4, 1}};
		try {
			Sudoku sp = new Sudoku(puzzle);
			assertTrue(sp.isPartialSudoku());

		} catch (Exception e) {
			fail("test failed");
		}
	}
	
	@Test
	public void PrintPuzzle_Test() throws Exception {
		int[][] puzzle= {{1, 4, 3, 2}, {3, 2, 1, 4,}, {4, 1, 2, 3}, {2, 3, 4, 1}};
		
		Sudoku sp;
			sp = new Sudoku(puzzle);
			sp.PrintPuzzle();
	}
	
	@Test
	public void FillDiagonalRegion() throws Exception {
		//Test for setRegion,shuffleRegion,getRegionNbr,shuffleArray additionally
		int[][] puzzle= {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		Sudoku sp= new Sudoku(puzzle);
		sp.FillDiagonalRegions();
		sp.PrintPuzzle();
	}
	@Test
	public void fullSudokuPuzzle_1()
	{
		try {
			Sudoku s1=new Sudoku(9);
			s1.PrintPuzzle();
			assertTrue(s1.isSudoku());
		}catch(Exception e) {
			fail("Failed to build puzzle");
		}
		
	}
	
	@Test
	public void fullSudokuPuzzle_2()
	{
		try {
			Sudoku s2=new Sudoku(9);
			s2.PrintPuzzle();
			assertTrue(s2.isSudoku());
		}catch(Exception e) {
			fail("Failed to build puzzle");
		}
		
	}
	
	@Test
	public void fullSudokuPuzzle_3()
	{
		try {
			Sudoku s3=new Sudoku(9);
			s3.PrintPuzzle();
			assertTrue(s3.isSudoku());
		}catch(Exception e) {
			fail("Failed to build puzzle");
		}
		
	}
}
