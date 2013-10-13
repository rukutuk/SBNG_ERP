package controller.hrm.masterdata.payroll.taxart21tariff;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import util.ZKUtil;
import java.util.Map;
import java.util.HashMap;
import renderer.hrm.masterdata.payroll.taxart21tariff.ShowTaxArt21TariffRenderer;
import org.zkoss.zk.ui.Executions;;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;

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
			// ZKUtil.renderListbox(listboxTaxArt21Tariff, NUNUNG , new ShowTaxArt21TariffRenderer());
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
			// NUNUNG
			// map.put("obj", ((TaxArt21Tariff)listboxTaxArt21Tariff.getSelectedItem().getAttribute("data")));
			Executions.createComponents("/hrm/masterdata/payroll/taxart21tariff/edit_tax_art_21_tariff.zul", null, map);
		}
	}

	public void onClick$btnDeleteTaxArt21Tariff() {
		if (listboxTaxArt21Tariff.getSelectedItem() != null)
		{
			// NUNUNG
			// TaxArt21Tariff taxArt21Tariff = (TaxArt21Tariff)listboxTaxArt21Tariff.getSelectedItem().getAttribute("data");
			try {
				// NUNUNG
				prepareList();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}