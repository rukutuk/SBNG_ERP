package controller.hrm.masterdata.absence.leavetype;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.cgui.LeaveType;
import pohaci.gumunda.titis.hrm.cgui.PTKP;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import util.ConnectionUtil;

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
                    LeaveType leaveType = new LeaveType(code.getValue(), description.getValue(), true);
                    HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).createLeaveType(0, IDBConstants.MODUL_MASTER_DATA, leaveType);                    
		   parent.prepareList();
                    closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}