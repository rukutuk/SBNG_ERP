package controller.hrm.masterdata.absence.leavetype;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import java.util.HashMap;
import renderer.hrm.masterdata.absence.leavetype.ShowLeaveTypeRenderer;
import org.zkoss.zk.ui.Executions;import org.zkoss.zul.ListModelList;
import pohaci.gumunda.titis.hrm.cgui.LeaveType;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import util.ConnectionUtil;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class ShowLeaveTypeController extends GenericForwardComposer {
	Window  windowShowLeaveType;
	Listbox  listboxLeaveType;
	Toolbarbutton  btnAddLeaveType,btnEditLeaveType,btnDeleteLeaveType;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		prepareList();
	}

	public void prepareList() {
		try {
                    listboxLeaveType.setItemRenderer(new ShowLeaveTypeRenderer());
                    listboxLeaveType.setModel(new ListModelList(HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).getAllLeaveType(0, IDBConstants.MODUL_MASTER_DATA)));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void onClick$btnAddLeaveType() {
		Map map = new HashMap();
		map.put("parent", this);
		Executions.createComponents("/hrm/masterdata/absence/leavetype/add_leave_type.zul", null, map);
	}

	public void onClick$btnEditLeaveType() {
		if (listboxLeaveType.getSelectedItem() != null)
		{
			Map map = new HashMap();
			map.put("parent", this);
                        map.put("obj", ((LeaveType)listboxLeaveType.getSelectedItem().getAttribute("data")));
			Executions.createComponents("/hrm/masterdata/absence/leavetype/edit_leave_type.zul", null, map);
		}
	}

	public void onClick$btnDeleteLeaveType() {
		if (listboxLeaveType.getSelectedItem() != null)
		{
			LeaveType leaveType = (LeaveType)listboxLeaveType.getSelectedItem().getAttribute("data");
			try {
				HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).deleteLeaveType(0, IDBConstants.MODUL_MASTER_DATA, leaveType.getIndex());
				prepareList();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}