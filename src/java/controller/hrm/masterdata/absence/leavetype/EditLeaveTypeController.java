package controller.hrm.masterdata.absence.leavetype;

import controller.hrm.masterdata.payroll.ptkp.ShowPtkpController;
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
public class EditLeaveTypeController extends GenericForwardComposer {
	Window  windowEditLeaveType;
	Textbox  code,description;
	Intbox  deduction;
	Toolbarbutton  btnSaveLeaveType,btnCancelLeaveType;

	ShowLeaveTypeController parent;
	LeaveType leaveType = null;
        long idx = 0;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
            super.doAfterCompose(comp);

            Map map = Executions.getCurrent().getArg();
            parent = (ShowLeaveTypeController) map.get("parent");
	    leaveType = (LeaveType) map.get("obj");
            idx = leaveType.getIndex();
        
            code.setValue(leaveType.getCode());
            description.setValue(leaveType.getDescription());
            deduction.setValue(null);
            windowEditLeaveType.doModal();
	}

	public void onClick$btnCancelLeaveType() {
		closeWindow();
	}

	public void closeWindow() {
            windowEditLeaveType.onClose();
	}

	public void onClick$btnSaveLeaveType() {
            try	{
                        LeaveType leaveType = new LeaveType(idx,code.getValue(), description.getValue(), true);
                        HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).updateLeaveType(0, IDBConstants.MODUL_MASTER_DATA, idx, leaveType);                    
                        parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}