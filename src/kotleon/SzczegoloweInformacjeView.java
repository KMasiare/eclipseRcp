package kotleon;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;



public class SzczegoloweInformacjeView extends ViewPart {
	
	ISelectionListener listener = new ISelectionListener() {
		
		@Override
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			if (!(selection instanceof IStructuredSelection))
	               return;
	            IStructuredSelection ss = (IStructuredSelection) selection;
	            Object o = ss.getFirstElement();
	            if (o instanceof Cat) {
	            	nazwaKota.setText(((Cat) o).getName());
	            	wiekKota.setText(((Cat) o).getAge().toString());
	            	plecKota.setText(((Cat) o).getGender());
	            	imieWlasciciela.setText(((Cat) o).getOwner());
	            }
		}
	};
	private Text nazwaKota;
	private Text wiekKota;
	private Text plecKota;
	private Text imieWlasciciela;

	public SzczegoloweInformacjeView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(4, false));
		
		Label lblNazwaKota = new Label(parent, SWT.NONE);
		lblNazwaKota.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNazwaKota.setText("nazwa kota:");
		
		nazwaKota = new Text(parent, SWT.BORDER);
		GridData gd_nazwaKota = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_nazwaKota.widthHint = 183;
		nazwaKota.setLayoutData(gd_nazwaKota);
		new Label(parent, SWT.NONE);
		
		Button zmienImiebtn = new Button(parent, SWT.NONE);
		zmienImiebtn.setText("zmien imie");
		
		Label lblWiekKota = new Label(parent, SWT.NONE);
		lblWiekKota.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWiekKota.setText("wiek kota:");
		
		wiekKota = new Text(parent, SWT.BORDER);
		wiekKota.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblPlecKota = new Label(parent, SWT.NONE);
		lblPlecKota.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPlecKota.setText("plec kota:");
		
		plecKota = new Text(parent, SWT.BORDER);
		plecKota.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblImieWlasciciela = new Label(parent, SWT.NONE);
		lblImieWlasciciela.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblImieWlasciciela.setText("imie wlasciciela:");
		
		imieWlasciciela = new Text(parent, SWT.BORDER);
		imieWlasciciela.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		wiekKota.setEditable(false);
    	plecKota.setEditable(false);
		
		getSite().getPage().addSelectionListener(listener);
		
		zmienImiebtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				String stareImie = nazwaKota.getText();
				DialogModalny dm = new DialogModalny(activeShell);
				if(dm.open() == Window.OK) {
					String zmienioneImie = dm.getZmienioneImie();
					ModelProvider.INSTANCE.zmienImieKota(stareImie, zmienioneImie);
				};
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
