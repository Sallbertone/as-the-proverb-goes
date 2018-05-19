package pl.tatastruga.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proverbs")
public class Proverb
{
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="proverb")
	private String proverb;
	
	@Column(name="meaning")
	private String meaning;
	
	public Proverb(int id, String proverb, String meaning)
	{
		this.id = id;
		this.proverb = proverb;
		this.meaning = meaning;
	}

	public Proverb(String proverb, String meaning)
	{
		this.proverb = proverb;
		this.meaning = meaning;
	}

	public Proverb()
	{
		
	}

	public int getId()
	{
		return id;
	}

	public String getProverb()
	{
		return proverb;
	}

	public String getMeaning()
	{
		return meaning;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setProverb(String proverb)
	{
		this.proverb = proverb;
	}

	public void setMeaning(String meaning)
	{
		this.meaning = meaning;
	}

	@Override
	public String toString()
	{
		return "Proverb [id=" + id + ", proverb=" + proverb + ", meaning=" + meaning + "]";
	}
	
	
	
}
