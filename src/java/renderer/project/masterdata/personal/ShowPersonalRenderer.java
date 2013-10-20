
package renderer.project.masterdata.personal;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.project.cgui.Personal;

public class ShowPersonalRenderer implements ListitemRenderer{

	public void render(Listitem lstm, Object o) throws Exception {
		Personal Personal = (Personal) o;

		 Listcell cell = new Listcell(Personal.getCode());
		 cell.setParent(lstm);

		 cell = new Listcell(Personal.getTitle());
		 cell.setParent(lstm);

		lstm.setAttribute("data", Personal);
	}
}