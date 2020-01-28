package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements IArregloDinamico<T>
{
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private Object[] elementos;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Object[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public <T> void agregar( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T[ ] copia = (T[]) elementos;
			elementos =  (T[]) new Object[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = (T) copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = (T) dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public T darElemento(int i) 
	{
		T elemento = null; 

		if( i >= 0 && i < tamanoAct)
		{
			elemento = (T) elementos[i];
		}

		return elemento;

	}

	public T buscar(T dato) 
	{	
		for(int i = 0; i < tamanoAct; i++)
		{
			T comparado = (T) elementos[i];
			if(comparado.compareTo(dato) == 0)
			{
				return comparado;
			}
		}

		return null;
	}

	public T eliminar(T dato) {


		int pos  = 0;
		boolean encontre = false;
		T buscado  = null;

		for(int i = 0; i < tamanoAct && !encontre; i++ )
		{
			T comparado = (T) elementos[i];
			if(comparado.compareTo(dato) == 0)
			{
				encontre = true;
				buscado  = comparado;
				pos = i;
			}

		}

		if(buscado  == null)
		{
			return null;
		}

		else
		{
			for (int j  = pos; j < tamanoAct -1; j++)
			{
				elementos[j] = elementos[j+1];
			}

			tamanoAct = tamanoAct-1;
			return buscado;
		}


	}

}
