package controller.hrm.masterdata.payroll.fieldallowance;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.cgui.AllowenceMultiplier;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import util.ConnectionUtil;

/* @author Tata */
public class EditFieldAllowanceMultiplierController extends GenericForwardComposer {
	Window  windowEditFieldAllowanceMultiplier;
	Textbox  code,description;
	Toolbarbutton  btnSaveFieldAllowanceMultiplier,btnCancelFieldAllowanceMultiplier;

	ShowFieldAllowanceMultiplierController parent;
	AllowenceMultiplier fieldAllowanceMultiplier = null;
        long idx = -1;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
            super.doAfterCompose(comp);

            Map map = Executions.getCurrent().getArg();
            parent = (ShowFieldAllowanceMultiplierController) map.get("parent");
            fieldAllowanceMultiplier = (AllowenceMultiplier) map.get("obj");
                
            idx = fieldAllowanceMultiplier.getIndex();
        
            code.setValue(fieldAllowanceMultiplier.getAreaCode());
            description.setValue(fieldAllowanceMultiplier.getDescription());
            windowEditFieldAllowanceMultiplier.doModal();
	}

	public void onClick$btnCancelFieldAllowanceMultiplier() {
		closeWindow();
	}

	public void closeWindow() {
		windowEditFieldAllowanceMultiplier.onClose();
	}

	public void onClick$btnSaveFieldAllowanceMultiplier() {
		try
		{
			AllowenceMultiplier rv = new AllowenceMultiplier(idx,code.getValue(), description.getValue(), 1);
                        HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).updateAllowenceMultiplier(0, IDBConstants.MODUL_MASTER_DATA, idx, rv);                                            
			// NUNUNG
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}