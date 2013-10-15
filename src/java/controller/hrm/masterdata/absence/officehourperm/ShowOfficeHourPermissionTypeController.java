package controller.hrm.masterdata.absence.officehourperm;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import util.ZKUtil;
import java.util.Map;
import java.util.HashMap;
import renderer.hrm.masterdata.absence.officehourperm.ShowOfficeHourPermissionTypeRenderer;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import renderer.hrm.masterdata.absence.permissiontype.ShowPermissionTypeRenderer;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import util.ConnectionUtil;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.cgui.OfficeHourPermition;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import renderer.hrm.masterdata.absence.permissiontype.ShowPermissionTypeRenderer;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import util.ConnectionUtil;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.cgui.PermitionType;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import renderer.hrm.masterdata.absence.permissiontype.ShowPermissionTypeRenderer;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import util.ConnectionUtil;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.cgui.OfficeHourPermition;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import renderer.hrm.masterdata.absence.permissiontype.ShowPermissionTypeRenderer;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import util.ConnectionUtil;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class ShowOfficeHourPermissionTypeController extends GenericForwardComposer {
	Window  windowShowOfficeHourPermissionType;
	Listbox  listboxOfficeHourPermissionType;
	Toolbarbutton  btnAddOfficeHourPermissionType,btnEditOfficeHourPermissionType,btnDeleteOfficeHourPermissionType;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
            super.doAfterCompose(comp);
            prepareList();
	}

	public void prepareList() {
            try {
		listboxOfficeHourPermissionType.setItemRenderer(new ShowOfficeHourPermissionTypeRenderer());
                listboxOfficeHourPermissionType.setModel(new ListModelList(HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).getAllOfficeHourPermition(0, IDBConstants.MODUL_MASTER_DATA)));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
	}

	public void onClick$btnAddOfficeHourPermissionType() {
            Map map = new HashMap();
            map.put("parent", this);
            Executions.createComponents("/hrm/masterdata/absence/officehourperm/add_office_hour_permission_type.zul", null, map);
	}

	public void onClick$btnEditOfficeHourPermissionType() {
            if (listboxOfficeHourPermissionType.getSelectedItem() != null)
            {
		Map map = new HashMap();
		map.put("parent", this);
                map.put("obj", ((OfficeHourPermition)listboxOfficeHourPermissionType.getSelectedItem().getAttribute("data")));
                Executions.createComponents("/hrm/masterdata/absence/officehourperm/edit_office_hour_permission_type.zul", null, map);
            }
	}

	public void onClick$btnDeleteOfficeHourPermissionType() {
            if (listboxOfficeHourPermissionType.getSelectedItem() != null)
            {
		OfficeHourPermition officeHourPermition = (OfficeHourPermition)listboxOfficeHourPermissionType.getSelectedItem().getAttribute("data");
		try {
                    HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).deleteOfficeHourPermition(0, IDBConstants.MODUL_MASTER_DATA, officeHourPermition.getIndex());
                    prepareList();
		} catch (Exception ex) {
                    ex.printStackTrace();
		}
            }
	}
}