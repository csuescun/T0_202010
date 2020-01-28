package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {

	private Modelo modelo;
	private static int CAPACIDAD=100;

	@Before
	public void setUp1() {
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.agregar(i);
		}
	}

	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() 
	{

		assertEquals(0, modelo.darTamano());

		int i = 0; 

		while(i < CAPACIDAD) 
		{
			modelo.agregar(i);
			assertEquals(i+1, modelo.darTamano());
			i++;
		}
	}

	@Test
	public void testAgregar() 
	{
		int i = 0; 

		while(i < CAPACIDAD) 
		{
			modelo.agregar(i);
			assertEquals(i+1, modelo.darTamano());
			i++;
		}
	}

	@Test
	public void testBuscar() 
	{
		setUp2();

		int i = 0; 

		while(i < CAPACIDAD) 
		{
			assertEquals(""+i, modelo.buscar(i));
			i++;
		}

		int ultimo = CAPACIDAD + 1;
		assertEquals(null,modelo.buscar(ultimo));
	}

	@Test
	public void testEliminar() 
	{
		setUp2();

		assertEquals(null, modelo.eliminar(CAPACIDAD+1));

		for(int i= 90; i < CAPACIDAD; i++)
		{
			assertEquals(""+ i,modelo.eliminar(i));
		}

		assertEquals(90, modelo.darTamano());



	}

}
