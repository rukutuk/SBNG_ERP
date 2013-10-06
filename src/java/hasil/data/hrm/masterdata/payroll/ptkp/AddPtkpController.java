package hasil.data.hrm.masterdata.payroll.ptkp;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Doublebox;
import pohaci.gumunda.titis.hrm.cgui.PTKP;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import util.ConnectionUtil;

/* @author Tata */
public class AddPtkpController extends GenericForwardComposer {

    Window windowAddPTKP;
    Textbox textName, textDescription;
    Doublebox bdValueYearly;
    ShowPtkpController parent;
    Button btnCancelPTKP;
            

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        Map map = Executions.getCurrent().getArg();
        parent = (ShowPtkpController) map.get("parent");
        windowAddPTKP.doModal();
    }

    public void onClick$btnSavePTKP() {
        try {
            PTKP ptkp = new PTKP(1, textName.getValue(), textDescription.getValue(), bdValueYearly.getValue());
            HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).createPTKP(0, IDBConstants.MODUL_MASTER_DATA, ptkp);
            parent.prepareList();
            closeWindow();
        } catch (Exception ex) {
            Logger.getLogger(AddPtkpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onClick$btnCancelPTKP() {        
        closeWindow();
    }
    
    private void closeWindow()
    {
        windowAddPTKP.onClose();        
    }
}