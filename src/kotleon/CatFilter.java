package kotleon;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class CatFilter extends ViewerFilter{
	
	private String searchString;

	public void setSearchString(String toSearch) {
		this.searchString = ".*" + toSearch + ".*";
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
	    if (searchString == null || searchString.length() == 0) {
	      return true;
	    }
	    Cat cat = (Cat) element;
	    
	    if (cat.getName().matches(searchString)) {
	      return true;
	    }

	    return false;
	  }

}
