package usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import exercicios.Exercicio1_5;

public class Principal
{
	public static void main(String[] args)
	{
		// popular array list
		List<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < 15_000_000; i++)
		{
			a.add((int) (i * 1.4));
		}
		
		int val = new Random().nextInt(100000);
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
}