package controller.hrm.setting.overtimemultiplier;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class AddOvertimeMultiplierController extends GenericForwardComposer {
	Window  windowAddOvertimeMultiplier;
	Intbox  hourmax,hourmin,type;
	Decimalbox  multiplier;
	Toolbarbutton  btnSaveOvertimeMultiplier,btnCancelOvertimeMultiplier;

	ShowOvertimeMultiplierController parent;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowOvertimeMultiplierController) map.get("parent");
		windowAddOvertimeMultiplier.doModal();
	}

	public void onClick$btnCancelOvertimeMultiplier() {
		closeWindow();
	}

	public void closeWindow() {
		windowAddOvertimeMultiplier.onClose();
	}

	public void onClick$btnSaveOvertimeMultiplier() {
		try
		{
			// OvertimeMultiplier overtimeMultiplier = new OvertimeMultiplier();
			// overtimeMultiplier.setHourmax(hourmax.getValue());
			// overtimeMultiplier.setHourmin(hourmin.getValue());
			// overtimeMultiplier.setMultiplier(multiplier.getValue());
			// overtimeMultiplier.setType(type.getValue());
			// NUNUNG
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}