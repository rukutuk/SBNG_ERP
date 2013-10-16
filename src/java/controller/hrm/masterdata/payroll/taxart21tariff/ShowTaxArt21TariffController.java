package controller.hrm.masterdata.payroll.taxart21tariff;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import java.util.HashMap;
import org.zkoss.zk.ui.Executions;import org.zkoss.zul.ListModelList;
import pohaci.gumunda.titis.hrm.cgui.TaxArt21Tariff;
import renderer.hrm.masterdata.payroll.fieldallowance.ShowFieldAllowanceMultiplierRenderer;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import util.ConnectionUtil;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.cgui.AllowenceMultiplier;
import renderer.hrm.masterdata.payroll.taxart21tariff.ShowTaxArt21TariffRenderer;

/* @author Tata */
public class ShowTaxArt21TariffController extends GenericForwardComposer {
	Window  windowShowTaxArt21Tariff;
	Listbox  listboxTaxArt21Tariff;
	Toolbarbutton  btnAddTaxArt21Tariff,btnEditTaxArt21Tariff,btnDeleteTaxArt21Tariff;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		prepareList();
	}

	public void prepareList() {
		try {
                    listboxTaxArt21Tariff.setItemRenderer(new ShowTaxArt21TariffRenderer());
                    listboxTaxArt21Tariff.setModel(new ListModelList(HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).getAllTaxArt21Tariff(0, IDBConstants.MODUL_MASTER_DATA)));
		} catch (Exception ex) {
                    ex.printStackTrace();
		}
	}

	public void onClick$btnAddTaxArt21Tariff() {
		Map map = new HashMap();
		map.put("parent", this);
		Executions.createComponents("/hrm/masterdata/payroll/taxart21tariff/add_tax_art_21_tariff.zul", null, map);
	}

	public void onClick$btnEditTaxArt21Tariff() {
		if (listboxTaxArt21Tariff.getSelectedItem() != null)
		{
			Map map = new HashMap();
			map.put("parent", this);
			map.put("obj", ((TaxArt21Tariff)listboxTaxArt21Tariff.getSelectedItem().getAttribute("data")));
			Executions.createComponents("/hrm/masterdata/payroll/taxart21tariff/edit_tax_art_21_tariff.zul", null, map);
		}
	}

	public void onClick$btnDeleteTaxArt21Tariff() {
		if (listboxTaxArt21Tariff.getSelectedItem() != null)
		{
			TaxArt21Tariff rv = (TaxArt21Tariff)listboxTaxArt21Tariff.getSelectedItem().getAttribute("data");
                    try {
			HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).deleteTaxArt21Tariff(0, IDBConstants.MODUL_MASTER_DATA, rv.getIndex());	
				prepareList();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}