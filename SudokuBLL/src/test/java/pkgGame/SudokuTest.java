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
}
