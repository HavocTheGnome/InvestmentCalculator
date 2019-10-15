import java.util.ArrayList;

public class Investment 
{
	ArrayList<Contribution> theContributions;
	
	public Investment()
	{
		this.theContributions = new ArrayList<Contribution>();
	}
	
	void addContribution(Contribution c)
	{
		this.theContributions.add(c);
	}
	double addInterest(double existingValue)
	{
		return existingValue + (existingValue * (.0067));
	}
	double contributionsPresent(int month)
	{
		double included = 0;
		for(int i = 0; i < theContributions.size(); i = i + 1)
		{
			Contribution a = theContributions.get(i);
			if(month >= a.monthNumber)
			{
				included = included + a.amount;
			}
			if(month < a.monthNumber)
			{
				return included;
			}
		}
		return included;
	}
	double getCurrentValue(int afterHowManyMonth)
	{
		double currentValue = 0;
		double contributions = 0;
		
		for(int i = 0; i < afterHowManyMonth; i = i + 1)
		{
			if(contributions < contributionsPresent(i+1))
			{
				currentValue = currentValue + (contributionsPresent(i+1) - contributions);
				contributions = contributionsPresent(i+1);
			}
			currentValue = addInterest(currentValue);
			System.out.println(currentValue);
		}
		return currentValue;
	}

	double getTotalContributions()
	{
		double total = 0;
		for(int i = 0; i < theContributions.size(); i = i + 1)
		{
			Contribution b = theContributions.get(i);
			total = total + b.amount;
		}
		return total;
	}
	
}
