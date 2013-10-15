
package renderer.hrm.masterdata.absence.officehourperm;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.hrm.cgui.OfficeHourPermition;

public class ShowOfficeHourPermissionTypeRenderer implements ListitemRenderer{

	public void render(Listitem lstm, Object o) throws Exception {
		OfficeHourPermition officeHourPermissionType = (OfficeHourPermition) o;

		Listcell cell = new Listcell(officeHourPermissionType.getCode());
		cell.setParent(lstm);

		cell = new Listcell(officeHourPermissionType.getDescription());
		cell.setParent(lstm);

		lstm.setAttribute("data", officeHourPermissionType);
	}
}