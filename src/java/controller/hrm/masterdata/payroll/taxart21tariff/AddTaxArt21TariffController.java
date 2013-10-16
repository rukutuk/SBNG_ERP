package controller.hrm.masterdata.payroll.taxart21tariff;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.cgui.TaxArt21Tariff;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import util.ConnectionUtil;

/* @author Tata */
public class AddTaxArt21TariffController extends GenericForwardComposer {
	Window  windowAddTaxArt21Tariff;
	Toolbarbutton  btnSaveTaxArt21Tariff,btnCancelTaxArt21Tariff;

	ShowTaxArt21TariffController parent;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		Map map = Executions.getCurrent().getArg();
		parent = (ShowTaxArt21TariffController) map.get("parent");
		windowAddTaxArt21Tariff.doModal();
	}

	public void onClick$btnCancelTaxArt21Tariff() {
		closeWindow();
	}

	public void closeWindow() {
		windowAddTaxArt21Tariff.onClose();
	}

	public void onClick$btnSaveTaxArt21Tariff() {
		try
		{
			TaxArt21Tariff leaveType = new TaxArt21Tariff(1, 1,1);
                        HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).createTaxArt21Tariff(0, IDBConstants.MODUL_MASTER_DATA, leaveType);                    
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}