
package renderer.hrm.masterdata.absence.permissiontype;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.hrm.cgui.PermitionType;

public class ShowPermissionTypeRenderer implements ListitemRenderer{

	public void render(Listitem lstm, Object o) throws Exception {
		PermitionType permissionType = (PermitionType) o;

		Listcell cell = new Listcell(permissionType.getCode());
		cell.setParent(lstm);

		cell = new Listcell(permissionType.getDescription());
		cell.setParent(lstm);

		
		cell = new Listcell(String.valueOf(permissionType.getDays()));
		cell.setParent(lstm);
                
                cell = new Listcell(String.valueOf(permissionType.getDeduction()));
		cell.setParent(lstm);

		lstm.setAttribute("data", permissionType);
	}
}