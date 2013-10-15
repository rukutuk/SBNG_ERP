
package renderer.hrm.masterdata.absence.leavetype;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.hrm.cgui.LeaveType;

public class ShowLeaveTypeRenderer implements ListitemRenderer{

	public void render(Listitem lstm, Object o) throws Exception {
		LeaveType leaveType = (LeaveType) o;

		Listcell cell = new Listcell(leaveType.getCode());
		cell.setParent(lstm);                
                
		cell = new Listcell(leaveType.getType());
		cell.setParent(lstm);

		cell = new Listcell(leaveType.getDescription());
		cell.setParent(lstm);

		lstm.setAttribute("data", leaveType);
	}
}