package kotleon;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class KsiazkiPerspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		// TODO Auto-generated method stub
		layout.setEditorAreaVisible(true);
		layout.setFixed(true);
		layout.addView("KotLeon.viewPrzegladajKsiazki", IPageLayout.TOP,
		        IPageLayout.RATIO_MAX, IPageLayout.ID_EDITOR_AREA);
		layout.addView("KotLeon.SzczegolyView", IPageLayout.TOP,
		        IPageLayout.RATIO_MAX, IPageLayout.ID_EDITOR_AREA);
	}
}
