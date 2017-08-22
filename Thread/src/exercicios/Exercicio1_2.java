package exercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicio1_2 extends Thread
{
	private int x;
	private int[] A;
	private int num;
	private static List<Exercicio1_2> threadCollection;
	private static int resultado;
	private static List<int[]> arrayCollection;
	
	public Exercicio1_2(int x, int[] A, int numThreads)
	{
		this.x = x;
		this.A = A;
		this.num = numThreads;
		resultado = 0;
		threadCollection = new ArrayList<Exercicio1_2>();
		arrayCollection = new ArrayList<int[]>();
	}
	
	public static int parallelSearch(int x, int[] A, int numThreads)
	{
		dividirArray(A, numThreads);

		// verificamos se foi dividido
		for (int i = 0; i < arrayCollection.size() - 1; i++)
		{
			System.err.println(threadCollection.add(new Exercicio1_2(x, arrayCollection.get(i), 1)));
			threadCollection.get(i).start();
		}
		
		loop:
		while (true)
		{
			boolean encerrar = false;
			for (int i = 0; i < threadCollection.size(); i++)
			{
				if(!threadCollection.get(i).isAlive())
				{
					encerrar = true;
				}
				
				procurarValor(x, threadCollection.get(i).A);

				if(encerrar || threadCollection.get(i).resultado == 1)
				{
					for (int t = 0; t < threadCollection.size(); t++)
					{
						threadCollection.get(t).interrupt();
					}
					break loop;
				}
			}
		}
		
		return resultado == 0 ? -1 : resultado;
	}

	private static void procurarValor(int valor, int[] array)
	{
		for (int i : array)
		{
			if (i == valor)
			{
				resultado = 1;
			}
		}
	}

	private static void dividirArray(int[] A, int numThreads)
	{
		// PESQUISAR DE i ATÉ Math.min(A.length, i + numThreads)
		for(int i = 0; i < A.length; i += numThreads)
		{
			arrayCollection.add(Arrays.copyOfRange(A, i, Math.min(A.length, i + numThreads)));
		}
	}

	@Override
	public void run()
	{
		parallelSearch(x, A, num);
	}
	
	public static int getResultado()
	{
		return resultado;
	}
}
