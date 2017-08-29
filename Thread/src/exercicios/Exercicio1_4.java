package exercicios;

public class Exercicio1_4 extends Thread
{
	private int[] array;
	private int comeco;
	private int fim;
	
	public Exercicio1_4(int[] array)
	{
		this.array = array;
		this.comeco = 0;
		this.fim = array.length - 1;
	}
	
	@Override
	public void run()
	{
		mergeSort(array, new int[array.length], comeco, fim);
	}
	
	private void mergeSort(int[] lista, int[] aux, int comeco, int fim)
	{
		if(comeco < fim)
		{
			int meio = (comeco + fim) / 2;
			Exercicio1_4 t1 = new Exercicio1_4(lista);
			t1.setComeco(comeco);
			t1.setFim(meio);
			t1.start();
			
			Exercicio1_4 t2 = new Exercicio1_4(lista);
			t2.setComeco(meio + 1);
			t2.setFim(fim);
			t2.start();
			try
			{
				t1.join();
				t2.join();			
			}
			catch (InterruptedException e)
			{
				System.err.println(e.getMessage());
			}
			intercalar(lista, aux, comeco, meio, fim);
		}
	}

	private void intercalar(int[] lista, int[] aux, int comeco, int meio, int fim)
	{
		for (int k = comeco; k <= fim; k++)
		{
			aux[k] = lista[k];
		}
		
		int i = comeco;
		int j = meio + 1;
		
		for (int k = comeco; k <= fim; k++)
		{
			if(i > meio)
			{
				lista[k] = aux[j++];
			}
			else if(j > fim)
			{
				lista[k] = aux[i++];
			}
			else if(aux[i] < aux[j])
			{
				lista[k] = aux[i++]; 
			}
			else
			{
				lista[k] = aux[j++];
			}
		}
	}
	
	public int[] getArray()
	{
		return array;
	}

	public void setComeco(int comeco)
	{
		this.comeco = comeco;
	}

	public void setFim(int fim)
	{
		this.fim = fim;
	}
}