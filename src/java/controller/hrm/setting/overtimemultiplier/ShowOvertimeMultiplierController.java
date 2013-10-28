package controller.hrm.setting.overtimemultiplier;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import java.util.HashMap;
import org.zkoss.zk.ui.Executions;;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class ShowOvertimeMultiplierController extends GenericForwardComposer {
	Window  windowShowOvertimeMultiplier;
	Listbox  listboxOvertimeMultiplier;
	Toolbarbutton  btnAddOvertimeMultiplier,btnEditOvertimeMultiplier,btnDeleteOvertimeMultiplier;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		prepareList();
	}

	public void prepareList() {
		try {
			// ZKUtil.renderListbox(listboxOvertimeMultiplier, NUNUNG , new ShowOvertimeMultiplierRenderer());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void onClick$btnAddOvertimeMultiplier() {
		Map map = new HashMap();
		map.put("parent", this);
		Executions.createComponents("/hrm/setting/overtimemultiplier/add_overtime_multiplier.zul", null, map);
	}

	public void onClick$btnEditOvertimeMultiplier() {
		if (listboxOvertimeMultiplier.getSelectedItem() != null)
		{
			Map map = new HashMap();
			map.put("parent", this);
			// NUNUNG
			// map.put("obj", ((OvertimeMultiplier)listboxOvertimeMultiplier.getSelectedItem().getAttribute("data")));
			Executions.createComponents("/hrm/setting/overtimemultiplier/edit_overtime_multiplier.zul", null, map);
		}
	}

	public void onClick$btnDeleteOvertimeMultiplier() {
		if (listboxOvertimeMultiplier.getSelectedItem() != null)
		{
			// NUNUNG
			// OvertimeMultiplier overtimeMultiplier = (OvertimeMultiplier)listboxOvertimeMultiplier.getSelectedItem().getAttribute("data");
			try {
				// NUNUNG
				prepareList();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}