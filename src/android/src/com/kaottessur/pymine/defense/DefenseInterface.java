package com.kaottessur.pymine.defense;

import com.kaottessur.pymine.defense.adder.DefenseAdderInterface;

public interface DefenseInterface {

	public boolean isDeactivated();
	public DefenseAdderInterface getDefenseAdder();
}
