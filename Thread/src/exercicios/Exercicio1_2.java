package exercicios;

public class Exercicio1_2 extends Thread
{
	private int x;
	private int[] A;
	private Auxiliar extremidade;
	private int resultado;
	
	public Exercicio1_2(int numero, Auxiliar extremidade, int[] Array)
	{
		this.x = numero;
		this.extremidade = extremidade;
		this.A = Array;
		this.resultado = -1;
	}

	private void procurarValor(int valor, Auxiliar extremidades)
	{
		for (int i = extremidades.getStartIndex(); i < extremidades.getEndIndex(); i++)
		{
			if (this.isInterrupted())
			{
				break;
			}
			else if(A[i] == x)
			{
				resultado = i;
				for (Exercicio1_2 cowork : Auxiliar.threadCollection)
				{
					cowork.interrupt();
				}
				break;
			}
		}
	}

	@Override
	public void run()
	{
		procurarValor(x, extremidade);
	}
	
	public int getResultado()
	{
		return resultado;
	}
}
