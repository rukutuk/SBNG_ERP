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
public class AddLeaveTypeController extends GenericForwardComposer {
	Window  windowAddLeaveType;
	Textbox  code,description;
	Intbox  deduction;
	Toolbarbutton  btnSaveLeaveType,btnCancelLeaveType;

	ShowLeaveTypeController parent;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowLeaveTypeController) map.get("parent");
		windowAddLeaveType.doModal();
	}

	public void onClick$btnCancelLeaveType() {
		closeWindow();
	}

	public void closeWindow() {
		windowAddLeaveType.onClose();
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