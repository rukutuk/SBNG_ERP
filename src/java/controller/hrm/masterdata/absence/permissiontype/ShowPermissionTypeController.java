package controller.hrm.masterdata.absence.permissiontype;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import java.util.HashMap;
import renderer.hrm.masterdata.absence.permissiontype.ShowPermissionTypeRenderer;
import org.zkoss.zk.ui.Executions;import org.zkoss.zul.ListModelList;
import pohaci.gumunda.titis.hrm.cgui.PermitionType;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import util.ConnectionUtil;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class ShowPermissionTypeController extends GenericForwardComposer {
	Window  windowShowPermissionType;
	Listbox  listboxPermissionType;
	Toolbarbutton  btnAddPermissionType,btnEditPermissionType,btnDeletePermissionType;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		prepareList();
	}

	public void prepareList() {
		try {
                    listboxPermissionType.setItemRenderer(new ShowPermissionTypeRenderer());
                    listboxPermissionType.setModel(new ListModelList(HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).getAllPermitionType(0, IDBConstants.MODUL_MASTER_DATA)));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void onClick$btnAddPermissionType() {
		Map map = new HashMap();
		map.put("parent", this);
		Executions.createComponents("/hrm/masterdata/absence/permissiontype/add_permission_type.zul", null, map);
	}

	public void onClick$btnEditPermissionType() {
		if (listboxPermissionType.getSelectedItem() != null)
		{
			Map map = new HashMap();
			map.put("parent", this);
			map.put("obj", ((PermitionType)listboxPermissionType.getSelectedItem().getAttribute("data")));
			Executions.createComponents("/hrm/masterdata/absence/permissiontype/edit_permission_type.zul", null, map);
		}
	}

	public void onClick$btnDeletePermissionType() {
		if (listboxPermissionType.getSelectedItem() != null)
		{
			PermitionType permissionType = (PermitionType)listboxPermissionType.getSelectedItem().getAttribute("data");
			try {
                            HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).deletePermitionType(0, IDBConstants.MODUL_MASTER_DATA, permissionType.getIndex());
				prepareList();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}