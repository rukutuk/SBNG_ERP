package controller.hrm.masterdata.absence.permissiontype;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.cgui.PermitionType;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import util.ConnectionUtil;

/* @author Tata */
public class EditPermissionTypeController extends GenericForwardComposer {
	Window  windowEditPermissionType;
	Textbox  code,description;
	Intbox  days,deduction;
	Toolbarbutton  btnSavePermissionType,btnCancelPermissionType;

	ShowPermissionTypeController parent;
	PermitionType permissionType = null;
        long idx = 0;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowPermissionTypeController) map.get("parent");
		permissionType = (PermitionType) map.get("obj");
		windowEditPermissionType.doModal();
                idx = permissionType.getIndex();
        
                code.setValue(permissionType.getCode());
                description.setValue(permissionType.getDescription());
                //deduction.setValue(permissionType.getDeduction());
                days.setValue(permissionType.getDays());
	}

	public void onClick$btnCancelPermissionType() {
		closeWindow();
	}

	public void closeWindow() {
		windowEditPermissionType.onClose();
	}

	public void onClick$btnSavePermissionType() {
		try
		{
			PermitionType permitionType = new PermitionType(idx, code.getValue(), description.getValue(), days.getValue(),true);
                        HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).updatePermitionType(0, IDBConstants.MODUL_MASTER_DATA, idx,  permitionType);
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}