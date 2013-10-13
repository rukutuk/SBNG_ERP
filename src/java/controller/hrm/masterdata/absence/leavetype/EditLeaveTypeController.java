package controller.hrm.masterdata.absence.leavetype;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class EditLeaveTypeController extends GenericForwardComposer {
	Window  windowEditLeaveType;
	Textbox  code,description;
	Intbox  deduction;
	Toolbarbutton  btnSaveLeaveType,btnCancelLeaveType;

	ShowLeaveTypeController parent;
	// LeaveType leaveType = null;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowLeaveTypeController) map.get("parent");
		// leaveType = (LeaveType) map.get("obj");
		windowEditLeaveType.doModal();
	}

	public void onClick$btnCancelLeaveType() {
		closeWindow();
	}

	public void closeWindow() {
		windowEditLeaveType.onClose();
	}

	public void onClick$btnSaveLeaveType() {
		try
		{
			// LeaveType leaveType = new LeaveType();
			// leaveType.setCode(code.getValue());
			// leaveType.setDeduction(deduction.getValue());
			// leaveType.setDescription(description.getValue());
			// NUNUNG
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}