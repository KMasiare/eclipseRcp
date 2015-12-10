package kotleon;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;

public class DialogModalny extends Dialog {
	private Text noweImie;
	private String zmienioneImie;

	public String getZmienioneImie() {
		return zmienioneImie;
	}

	protected DialogModalny(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(2, false));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblNoweImie = new Label(container, SWT.NONE);
		lblNoweImie.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNoweImie.setText("nowe imie");
		
		noweImie = new Text(container, SWT.BORDER);
		noweImie.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		return container;
	}
	


		  @Override
		  protected void okPressed() {
			  zmienioneImie = noweImie.getText();
		    super.okPressed();
		  }


	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Ustawianie nowego imienia kota");
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
}
