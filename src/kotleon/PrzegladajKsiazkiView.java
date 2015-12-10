package kotleon;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Button;

public class PrzegladajKsiazkiView extends ViewPart {

	private TableViewer viewer;
	private CatFilter catFilter;
	private WritableList input;

	public PrzegladajKsiazkiView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayout layout = new GridLayout(2, false);
	    parent.setLayout(layout);
	    Label searchLabel = new Label(parent, SWT.NONE);
	    searchLabel.setText("Szukaj: ");
	    final Text searchText = new Text(parent, SWT.BORDER | SWT.SEARCH);
	    GridData gd_searchText = new GridData(GridData.GRAB_HORIZONTAL
	        | GridData.HORIZONTAL_ALIGN_FILL);
	    gd_searchText.widthHint = 307;
	    searchText.setLayoutData(gd_searchText);
	    createTableViewer(parent);

	    searchText.addKeyListener(new KeyAdapter() {
	      public void keyReleased(KeyEvent ke) {
	        catFilter.setSearchString(searchText.getText());
	        viewer.refresh();
	      }

	    });
	    catFilter = new CatFilter();
	    viewer.addFilter(catFilter);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	private void createTableViewer(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
		    public void selectionChanged(final SelectionChangedEvent event) {
		        IStructuredSelection selection = (IStructuredSelection)event.getSelection();
		        getSite().getWorkbenchWindow().getActivePage().findView("KotLeon.SzczegolyView").setFocus();
		    }
		});

		createColumns(parent, viewer);

		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		viewer.setContentProvider(new ArrayContentProvider());
	    
		input = new WritableList(ModelProvider.INSTANCE.getCats(), Cat.class);;
	    viewer.setInput(input);
	    
	    ViewerSupport.bind(viewer, input, 
	    	    BeanProperties.
	    	    values(new String[] { "name", "gender", "age", "owner" })); 

	    
	    getSite().setSelectionProvider(viewer);

	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    viewer.getControl().setLayoutData(gridData);
	}

	private void createColumns(final Composite parent, final TableViewer viewer) {
		String[] titles = { "imie", "plec", "wiek", "wlasciciel" };
		int[] bounds = { 100, 100, 100, 100 };

		TableViewerColumn column = createTableViewerColumn(titles[0], bounds[0], 0);
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Cat cat = (Cat) element;
				return cat.getName();
			}
		});

		column = createTableViewerColumn(titles[1], bounds[1], 1);
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Cat cat = (Cat) element;
				return cat.getGender();
			}
		});

		column = createTableViewerColumn(titles[2], bounds[2], 2);
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Cat cat = (Cat) element;
				return String.valueOf(cat.getAge());
			}
		});

		column = createTableViewerColumn(titles[3], bounds[3], 3);
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Cat cat = (Cat) element;
				return cat.getOwner();
			}
		});
	}

	private TableViewerColumn createTableViewerColumn(String title, int bound, int number) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}
}
