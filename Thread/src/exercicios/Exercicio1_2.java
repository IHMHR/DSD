package exercicios;

import java.util.ArrayList;
import java.util.List;

public class Exercicio1_2 extends Thread
{
	private int x;
	private int[] A;
	private int num;
	private static List<Exercicio1_2> threadCollection;
	private int resultado;
	
	public Exercicio1_2(int x, int[] A, int numThreads)
	{
		this.x = x;
		this.A = A;
		this.num = numThreads;
		threadCollection = new ArrayList<Exercicio1_2>();
	}
	
	public static int parallelSearch(int x, int[] A, int numThreads)
	{
		// criando todas as threads
		for (int i = 0; i < numThreads; i++)
		{
			//threadCollection.add(new Exercicio1_2(x, A, 0).start(););
			new Exercicio1_2(x, A, 0).start();
		}
		
		
		return 0;
	}
	
	@Override
	public void run()
	{
		parallelSearch(x, A, num);
	}
	
	public int getResultado()
	{
		return resultado;
	}
}