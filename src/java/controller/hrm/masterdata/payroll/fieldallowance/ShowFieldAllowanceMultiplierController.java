package controller.hrm.masterdata.payroll.fieldallowance;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import java.util.HashMap;
import renderer.hrm.masterdata.payroll.fieldallowance.ShowFieldAllowanceMultiplierRenderer;
import org.zkoss.zk.ui.Executions;import org.zkoss.zul.ListModelList;

import pohaci.gumunda.titis.hrm.cgui.AllowenceMultiplier;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import util.ConnectionUtil;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class ShowFieldAllowanceMultiplierController extends GenericForwardComposer {
	Window  windowShowFieldAllowanceMultiplier;
	Listbox  listboxFieldAllowanceMultiplier;
	Toolbarbutton  btnAddFieldAllowanceMultiplier,btnEditFieldAllowanceMultiplier,btnDeleteFieldAllowanceMultiplier;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
            super.doAfterCompose(comp);
            prepareList();
	}

	public void prepareList() {
            try {
                listboxFieldAllowanceMultiplier.setItemRenderer(new ShowFieldAllowanceMultiplierRenderer());
                listboxFieldAllowanceMultiplier.setModel(new ListModelList(HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).getAllAllowenceMultiplier(0, IDBConstants.MODUL_MASTER_DATA)));
            } catch (Exception ex) {
		ex.printStackTrace();
            }
	}

	public void onClick$btnAddFieldAllowanceMultiplier() {
		Map map = new HashMap();
		map.put("parent", this);
		Executions.createComponents("/hrm/masterdata/payroll/fieldallowance/add_field_allowance_multiplier.zul", null, map);
	}

	public void onClick$btnEditFieldAllowanceMultiplier() {
		if (listboxFieldAllowanceMultiplier.getSelectedItem() != null)
		{
			Map map = new HashMap();
			map.put("parent", this);
                        map.put("obj", ((AllowenceMultiplier)listboxFieldAllowanceMultiplier.getSelectedItem().getAttribute("data")));
			Executions.createComponents("/hrm/masterdata/payroll/fieldallowance/edit_field_allowance_multiplier.zul", null, map);
		}
	}

	public void onClick$btnDeleteFieldAllowanceMultiplier() {
            if (listboxFieldAllowanceMultiplier.getSelectedItem() != null)
		{
                    AllowenceMultiplier rv = (AllowenceMultiplier)listboxFieldAllowanceMultiplier.getSelectedItem().getAttribute("data");
                    try {
			HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).deleteAllowenceMultiplier(0, IDBConstants.MODUL_MASTER_DATA, rv.getIndex());	
                        prepareList();
                    } catch (Exception ex) {
			ex.printStackTrace();
                    }
		}
	}
}