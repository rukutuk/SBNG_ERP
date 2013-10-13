package controller.hrm.masterdata.absence.permissiontype;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class EditPermissionTypeController extends GenericForwardComposer {
	Window  windowEditPermissionType;
	Textbox  code,description;
	Intbox  days,deduction;
	Toolbarbutton  btnSavePermissionType,btnCancelPermissionType;

	ShowPermissionTypeController parent;
	// PermissionType permissionType = null;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowPermissionTypeController) map.get("parent");
		// permissionType = (PermissionType) map.get("obj");
		windowEditPermissionType.doModal();
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
			// PermissionType permissionType = new PermissionType();
			// permissionType.setCode(code.getValue());
			// permissionType.setDays(days.getValue());
			// permissionType.setDeduction(deduction.getValue());
			// permissionType.setDescription(description.getValue());
			// NUNUNG
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}