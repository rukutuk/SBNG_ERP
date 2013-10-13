package controller.hrm.masterdata.absence.officehourperm;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class AddOfficeHourPermissionTypeController extends GenericForwardComposer {
	Window  windowAddOfficeHourPermissionType;
	Textbox  code,description;
	Toolbarbutton  btnSaveOfficeHourPermissionType,btnCancelOfficeHourPermissionType;

	ShowOfficeHourPermissionTypeController parent;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowOfficeHourPermissionTypeController) map.get("parent");
		windowAddOfficeHourPermissionType.doModal();
	}

	public void onClick$btnCancelOfficeHourPermissionType() {
		closeWindow();
	}

	public void closeWindow() {
		windowAddOfficeHourPermissionType.onClose();
	}

	public void onClick$btnSaveOfficeHourPermissionType() {
		try
		{
			// OfficeHourPermissionType officeHourPermissionType = new OfficeHourPermissionType();
			// officeHourPermissionType.setCode(code.getValue());
			// officeHourPermissionType.setDescription(description.getValue());
			// NUNUNG
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}