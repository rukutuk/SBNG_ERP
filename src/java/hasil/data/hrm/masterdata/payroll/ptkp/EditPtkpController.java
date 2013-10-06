package hasil.data.hrm.masterdata.payroll.ptkp;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.cgui.PTKP;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import util.ConnectionUtil;

/* @author Tata */
public class EditPtkpController extends GenericForwardComposer {

    Window windowEditPTKP;
    Textbox textName, textDescription;
    Doublebox bdValueYearly;
    Toolbarbutton btnAddPTKP, btnEditPTKP, btnDeletePTKP;
    ShowPtkpController parent;
    long idx = 0;
    PTKP ptkp = null;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        Map map = Executions.getCurrent().getArg();
        parent = (ShowPtkpController) map.get("parent");
//        idx = (Long) map.get("obj");
        ptkp = (PTKP) map.get("obj");
        idx = ptkp.getIndex();
        
        textName.setValue(ptkp.getName());
        textDescription.setValue(ptkp.getDescription());
        bdValueYearly.setValue(ptkp.getValue());
        
        
        
        windowEditPTKP.doModal();
    }

    public void onClick$btnSavePTKP() {
        try {
            PTKP ptkp = new PTKP(idx, textName.getValue(), textDescription.getValue(), bdValueYearly.getValue());
            HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).updatePTKP(0, IDBConstants.MODUL_MASTER_DATA, idx, ptkp);
            parent.prepareList();
            closeWindow();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(AddPtkpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onClick$btnCancelPTKP() {
        closeWindow();
    }

    private void closeWindow() {
        windowEditPTKP.onClose();
    }
}