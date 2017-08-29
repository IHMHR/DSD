package exercicios;

import java.util.ArrayList;
import java.util.List;

public class Auxiliar
{
	public static List<Auxiliar> extremidades = new ArrayList<Auxiliar>();
	public static List<Exercicio1_2> threadCollection = new ArrayList<Exercicio1_2>();
	private int startIndex;
	private int endIndex;
		
	public Auxiliar(int startIndex, int endIndex)
	{
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public int getStartIndex()
	{
		return startIndex;
	}

	public int getEndIndex()
	{
		return endIndex;
	}

	public static void dividirArray(int[] A, int numThreads)
	{
		for (int i = 0; i < A.length; i += A.length / numThreads)
		{
			extremidades.add(new Auxiliar(i, Math.min(A.length, i + A.length / numThreads)));
		}		
	}
}