package com.kaottessur.pymine.level;

import com.kaottessur.pymine.GridLocationInterface;
import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.level.clue.Clue;

public class GridSquare implements GridLocationInterface {
	private int row;
	private int column;
	private boolean scanned = false;
	
	private DefenseInterface defense;
	private Clue clue;
	
	public GridSquare(int row, int column) {
		this.row = row;
		this.column = column;
		clue = new Clue();
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public Clue getClue() {
		return clue;
	}
	
	public boolean isScanned() {
		return scanned;
	}
	
	public void scan(Drone drone) {
		scanned = true;
		clue.populate(drone.getMinefield(), drone.getRow(), drone.getColumn());
		if (hasDefense())
			defense.scan(drone);
	}
	
	public void defuse(Drone drone) {
		if (hasDefense())
			defense.defuse(drone);
	}
	
	public void defuseCarefully(Drone drone) {
		if (hasDefense())
			defense.defuseCarefully(drone);
	}
	
	public void performEMP(Drone drone) {
		if (hasDefense())
			defense.hitByEMP(drone);
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
	
	public boolean reversed() {
		if (hasDefense())
			return defense.reverseReadings();
		return false;
	}
	
	public boolean isFragile() {
		if (hasDefense())
			return defense.isFragile();
		return false;
	}
}
