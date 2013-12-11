package pcrecipes.server;

public class seacrh extends recipes{

	public recipe searchByName(String name)
	{
		recipe newRecipe = new recipe (""); //-1 is for temp recipe
		int i=0;
		for(i=0; i< recipeArr.length; i++)
		{
			if(name.equals(recipeArr[i].get_name()))
			{
				newRecipe.set_name( name);
				newRecipe.set_id(recipeArr[i].get_id());
				newRecipe.set_product(recipeArr[i].get_product());
				newRecipe.set_category(recipeArr[i].get_category());
				return newRecipe;
			}
		}		
		return null;
	}
}
