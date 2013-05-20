package com.kaottessur.pymine.level;

import com.kaottessur.pymine.GridLocationInterface;
import com.kaottessur.pymine.defense.DefenseInterface;

public class GridSquare implements GridLocationInterface {
	private int row;
	private int column;
	private boolean scanned = false;
	private DefenseInterface defense;
	
	public GridSquare(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public boolean isScanned() {
		return scanned;
	}
	
	public void scan(Drone drone) {
		scanned = !scanned;
		if (hasDefense())
			defense.scan(drone);
	}
	
	public boolean hasDefense() {
		return defense != null;
	}
	
	public DefenseInterface getDefense() {
		return defense;
	}
	
	public void setDefense(DefenseInterface defense) {
		this.defense = defense;
	}

	public boolean mined() {
		if (hasDefense())
			return defense.isMine();
		return false;
	}
}
