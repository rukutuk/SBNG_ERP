
package renderer.project.masterdata.partner.partnergroup;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.project.cgui.CompanyGroup;

public class ShowPartnerGroupRenderer implements ListitemRenderer{

	public void render(Listitem lstm, Object o) throws Exception {
		 CompanyGroup partnerGroup = (CompanyGroup) o;                 
                  Listcell cell = new Listcell(partnerGroup.getName());
                  cell.setParent(lstm);

		 cell = new Listcell(partnerGroup.getDescription());
		 cell.setParent(lstm);

		lstm.setAttribute("data", partnerGroup);
	}
}