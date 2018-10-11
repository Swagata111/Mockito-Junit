package com.capgemini.JavaJunitEngine;

public class Car
{
	private Engine engine;
	private FuelTank fuelTank;
	public Car(Engine engine, FuelTank fuelTank) {
		super();
		this.engine = engine;
		this.fuelTank = fuelTank;
	}
	public void start()
	{
		if(engine.isRunning())
			throw new IllegalStateException("Engine already runnning!!");
		if(fuelTank.getFuel()==0)
			throw new IllegalStateException("Can't start!!No fuel");
		engine.start();
		if(!engine.isRunning())
			throw new IllegalStateException("Engine started but is not runnning!!");
		
	}
	public boolean isRunning()
	{
		return engine.isRunning();
		
	}
}
