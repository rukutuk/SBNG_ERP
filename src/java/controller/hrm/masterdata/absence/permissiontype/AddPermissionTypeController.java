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
public class AddPermissionTypeController extends GenericForwardComposer {
	Window  windowAddPermissionType;
	Textbox  code,description;
	Intbox  days,deduction;
	Toolbarbutton  btnSavePermissionType,btnCancelPermissionType;

	ShowPermissionTypeController parent;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowPermissionTypeController) map.get("parent");
		windowAddPermissionType.doModal();
	}

	public void onClick$btnCancelPermissionType() {
		closeWindow();
	}

	public void closeWindow() {
		windowAddPermissionType.onClose();
	}

	public void onClick$btnSavePermissionType() {
		try
		{
                   PermitionType permitionType = new PermitionType(code.getValue(), description.getValue(), days.getValue(),true);
                   HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).createPermitionType(0, IDBConstants.MODUL_MASTER_DATA,  permitionType);
                    parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}