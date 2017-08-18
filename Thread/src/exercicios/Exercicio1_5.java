package exercicios;

import java.util.List;

public class Exercicio1_5 extends Thread
{
	private List<Integer> array;
	private Integer num;
	private Boolean encontrou;
	private Boolean pFrente;
	
	public Exercicio1_5()
	{
		this.encontrou = false;
	}
	
	@Override
	public void run()
	{
		percorrerArray();
	}
	
	private void percorrerArray()
	{
		if(this.pFrente)
		{
			for (int i = 0; i < array.size(); i++)
			{
				if (array.get(i).intValue() == this.num)
				{
					this.encontrou = true;
					break;
				}
			}
		}
		else
		{
			for (int i = array.size() - 1; i > 0; i--)
			{
				if (array.get(i).intValue() == this.num)
				{
					this.encontrou = true;
					break;
				}
			}
		}
	}
	
	public void setArray(List<Integer> array)
	{
		this.array = array;
	}
	
	public void setNum(Integer num)
	{
		this.num = num;
	}
	
	public Boolean getEncontrou()
	{
		return encontrou;
	}
	
	public void setpFrente(Boolean pFrente)
	{
		this.pFrente = pFrente;
	}
}