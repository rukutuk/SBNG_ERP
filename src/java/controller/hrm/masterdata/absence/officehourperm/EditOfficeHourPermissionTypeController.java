package controller.hrm.masterdata.absence.officehourperm;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.cgui.OfficeHourPermition;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import util.ConnectionUtil;

/* @author Tata */
public class EditOfficeHourPermissionTypeController extends GenericForwardComposer {
	Window  windowEditOfficeHourPermissionType;
	Textbox  code,description;
	Toolbarbutton  btnSaveOfficeHourPermissionType,btnCancelOfficeHourPermissionType;

	ShowOfficeHourPermissionTypeController parent;
	OfficeHourPermition officeHourPermissionType = null;
        long idx = 0;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowOfficeHourPermissionTypeController) map.get("parent");
		officeHourPermissionType = (OfficeHourPermition) map.get("obj");
                windowEditOfficeHourPermissionType.doModal();
                idx = officeHourPermissionType.getIndex();
        
                code.setValue(officeHourPermissionType.getCode());
                description.setValue(officeHourPermissionType.getDescription());
	}

	public void onClick$btnCancelOfficeHourPermissionType() {
		closeWindow();
	}

	public void closeWindow() {
		windowEditOfficeHourPermissionType.onClose();
	}

	public void onClick$btnSaveOfficeHourPermissionType() {
		try
		{
			OfficeHourPermition officeHourPermition = new OfficeHourPermition(idx, code.getValue(), description.getValue());
                        HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).updateOfficeHourPermition(0, IDBConstants.MODUL_MASTER_DATA, idx,  officeHourPermition);
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}