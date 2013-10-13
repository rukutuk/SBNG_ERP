package controller.hrm.masterdata.payroll.fieldallowance;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class AddFieldAllowanceMultiplierController extends GenericForwardComposer {
	Window  windowAddFieldAllowanceMultiplier;
	Textbox  code,description;
	Toolbarbutton  btnSaveFieldAllowanceMultiplier,btnCancelFieldAllowanceMultiplier;

	ShowFieldAllowanceMultiplierController parent;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowFieldAllowanceMultiplierController) map.get("parent");
		windowAddFieldAllowanceMultiplier.doModal();
	}

	public void onClick$btnCancelFieldAllowanceMultiplier() {
		closeWindow();
	}

	public void closeWindow() {
		windowAddFieldAllowanceMultiplier.onClose();
	}

	public void onClick$btnSaveFieldAllowanceMultiplier() {
		try
		{
			// FieldAllowanceMultiplier fieldAllowanceMultiplier = new FieldAllowanceMultiplier();
			// fieldAllowanceMultiplier.setCode(code.getValue());
			// fieldAllowanceMultiplier.setDescription(description.getValue());
			// NUNUNG
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}