package Homework3;

import java.util.ArrayList;
import java.util.List;

public class CustomerBean {
	
	  List<Customer> entries;

	    public CustomerBean()
	    {
	        entries = new ArrayList<Customer>();
	    }

	    public void setAddEntry( String dummy )
	    {
	        Customer entry = new Customer();
	        entries.add( entry );
	    }

	    public Customer getLastEntry()
	    {
	        return entries.get( entries.size() - 1 );
	    }

	    public List<Customer> getEntries()
	    {
	        return entries;
	    }

	    public void setEntries( List<Customer> entries )
	    {
	        this.entries = entries;
	    }
}
 