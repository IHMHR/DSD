package usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import exercicios.Auxiliar;
import exercicios.Exercicio1_2;
import exercicios.Exercicio1_5;

public class Principal
{
	public static void main(String[] args)
	{
		
		
		
		
		// popular array list
		List<Integer> a = new ArrayList<Integer>();
		int[] array = new int[15_000];
		for (int i = 0; i < 15_000; i++)
		{
			int temp = (int) (i * 1.4);
			a.add(temp);
			array[i] = i + 1;
		}
		
		int val = new Random().nextInt(15000);
		
		System.out.println(parallelSearch(888, array, 15));

		System.exit(0);		
		
		
		
		System.out.println("Vamos tentar encontrar o valor: " + val + " - " + a.contains(val) + " - " + a.size());
		
		Exercicio1_5 t1 = new Exercicio1_5();
		t1.setArray(a);
		t1.setNum(val);
		t1.setpFrente(true);
		
		Exercicio1_5 t2 = new Exercicio1_5();
		t2.setArray(a);
		t2.setNum(val);
		t2.setpFrente(false);
		
		t1.start();
		t2.start();
		
		try
		{
			if(t1.getEncontrou())
			{
				t2.interrupt();
			}
			else if(t2.getEncontrou())
			{
				t1.interrupt();
			}
			
			t1.join();
			t2.join();
		}
		catch (InterruptedException e)
		{
			System.err.println(e.getMessage());
		}
		
		System.out.println(t1.getEncontrou());
		System.out.println(t2.getEncontrou());
	}
	
	public static int parallelSearch(int x, int[] A, int numThreads)
	{
		int aux = -1;
		// dividir o array
		Auxiliar.dividirArray(A, numThreads);
		// para cada pedaço criar uma nova thread e pesquisar
		for (Auxiliar extremidade : Auxiliar.extremidades)
		{
			Auxiliar.threadCollection.add(new Exercicio1_2(x, extremidade, A));
		}
		
		for (Exercicio1_2 thread : Auxiliar.threadCollection)
		{
			thread.start();
			try
			{
				thread.join();
			}
			catch (InterruptedException e)
			{
				System.err.println(e.getMessage());
			}
			aux = aux > thread.getResultado() ? aux : thread.getResultado();
		}
		
		return aux;
	}
}