package dbManager;
import java.util.List;

import javax.jdo.PersistenceManager;

import pcrecipes.server.recipe;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
public final class DataBaseManager
 {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    PersistenceManager pm = PMF.get().getPersistenceManager();
    private DataBaseManager() {}
    private static DataBaseManager instance = null;
    public static DataBaseManager getInstance()
    {
        if (instance == null)
            instance = new DataBaseManager();
        return instance;
    }
    
    
    public void insertNewRecipe(recipe r)
    {
    	pm.makePersistent(r);
    }
    public List<recipe> getRecipe(String name)
    {
    	System.out.println("getting Recipe" + name);
    	javax.jdo.Query q = pm.newQuery(recipe.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	return (List<recipe>)q.execute(name);
    }
    public List<recipe> getAllRecipes()
    {
    	javax.jdo.Query q = pm.newQuery(recipe.class);
    	return (List<recipe>)q.execute();
    }

}
