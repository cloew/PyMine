package com.kaottessur.pymine.defense.adder;

import java.util.Random;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;

public class StandardDefenseAdder implements DefenseAdderInterface {
	static Random random = new Random();
	
	 public StandardDefenseAdder() {
		 
	 }
	 
	 public void addDefense(DefenseInterface defense, Minefield minefield) {
		 while (true) {
			 GridSquare gridSquare = getRandomGridSquare(minefield);
			 if (gridSquare.hasDefense())
			 	continue;
			 else {
				 gridSquare.setDefense(defense);
				 defense.setGridSquare(gridSquare);
				 break;
			 }
		 }
	 }
	 
	 public GridSquare getRandomGridSquare(Minefield minefield) {
		 int row = random.nextInt(minefield.getRowCount());
		 int column = random.nextInt(minefield.getColumnCount() -1) + 1;
		 return minefield.getGridSquareAt(row, column);
	 }
}
