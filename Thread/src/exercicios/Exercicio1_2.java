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
		int aux = A.length / numThreads;
		int[] B = new int[aux];
		// criando todas as threads
		for (int i = 0; i < numThreads; i++)
		{
			System.arraycopy(A, aux, B, 0, A.length / numThreads);
			threadCollection.add(new Exercicio1_2(x, A, 0));
			//new Exercicio1_2(x, A, 0).start();
			aux = aux + A.length / numThreads;
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