package controller.hrm.masterdata.absence.officehourperm;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import util.ZKUtil;
import java.util.Map;
import java.util.HashMap;
import renderer.hrm.masterdata.absence.officehourperm.ShowOfficeHourPermissionTypeRenderer;
import org.zkoss.zk.ui.Executions;;
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
			// ZKUtil.renderListbox(listboxOfficeHourPermissionType, NUNUNG , new ShowOfficeHourPermissionTypeRenderer());
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
			// NUNUNG
			// map.put("obj", ((OfficeHourPermissionType)listboxOfficeHourPermissionType.getSelectedItem().getAttribute("data")));
			Executions.createComponents("/hrm/masterdata/absence/officehourperm/edit_office_hour_permission_type.zul", null, map);
		}
	}

	public void onClick$btnDeleteOfficeHourPermissionType() {
		if (listboxOfficeHourPermissionType.getSelectedItem() != null)
		{
			// NUNUNG
			// OfficeHourPermissionType officeHourPermissionType = (OfficeHourPermissionType)listboxOfficeHourPermissionType.getSelectedItem().getAttribute("data");
			try {
				// NUNUNG
				prepareList();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}