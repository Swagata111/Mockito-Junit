package com.capgemini.JavaJunitEngine;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class CarTest 
{
	private Car car;
	private Engine engine;
	private FuelTank fuelTank;
	
	@Rule
	public ExpectedException expected=ExpectedException.none();
	
	@Before
	public void setup()
	{	
		engine=Mockito.mock(Engine.class);
		fuelTank=Mockito.mock(FuelTank.class);
		car=new Car(engine,fuelTank);
	}

	
	@Test
	public void isRunning() 
	{
		 when(engine.isRunning()).thenReturn(true);
	          assertEquals(true, car.isRunning());
	        when(engine.isRunning()).thenReturn(false);
	        assertEquals(false, car.isRunning());
	}
	
	  @Test
	    public void start() {
	        when(engine.isRunning()).thenReturn(false, true);
	        when(fuelTank.getFuel()).thenReturn(100);
	        car.start();
	    }

	    @Test
	    public void start_NoFuel() {
	        expected.expect(IllegalStateException.class);
	        expected.expectMessage("Can't start!!No fuel");
	        when(engine.isRunning()).thenReturn(false);
	        when(fuelTank.getFuel()).thenReturn(0);
	        car.start();
	    }
	
	@Test
	public void start_IsNotRunning() 
	{
		expected.expect(IllegalStateException.class);
		expected.expectMessage("Engine started but is not runnning!!");
		when(engine.isRunning()).thenReturn(false,false);
		when(fuelTank.getFuel()).thenReturn(100);
		car.start();
	}
	
	
	@Test
	public void start_IsRunning() 
	{
		expected.expect(IllegalStateException.class);
		expected.expectMessage("Engine already runnning!!");
		when(fuelTank.getFuel()).thenReturn(100);
		when(engine.isRunning()).thenReturn(true);
		car.start();	
	}

}
