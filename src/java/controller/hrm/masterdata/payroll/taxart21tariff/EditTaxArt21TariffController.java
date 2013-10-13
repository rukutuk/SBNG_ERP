package controller.hrm.masterdata.payroll.taxart21tariff;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class EditTaxArt21TariffController extends GenericForwardComposer {
	Window  windowEditTaxArt21Tariff;
	Toolbarbutton  btnSaveTaxArt21Tariff,btnCancelTaxArt21Tariff;

	ShowTaxArt21TariffController parent;
	// TaxArt21Tariff taxArt21Tariff = null;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowTaxArt21TariffController) map.get("parent");
		// taxArt21Tariff = (TaxArt21Tariff) map.get("obj");
		windowEditTaxArt21Tariff.doModal();
	}

	public void onClick$btnCancelTaxArt21Tariff() {
		closeWindow();
	}

	public void closeWindow() {
		windowEditTaxArt21Tariff.onClose();
	}

	public void onClick$btnSaveTaxArt21Tariff() {
		try
		{
			// TaxArt21Tariff taxArt21Tariff = new TaxArt21Tariff();
			// NUNUNG
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}