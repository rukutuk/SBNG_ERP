package hasil.data.hrm.masterdata.payroll.ptkp;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.cgui.PTKP;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import renderer.hrm.masterdata.payroll.ptkp.ShowPtkpRenderer;
import util.ConnectionUtil;

/* @author Tata */
public class ShowPtkpController extends GenericForwardComposer {

    Window windowShowPtkp;
    Listbox listboxPtkp;
    Toolbarbutton btnAddPTKP, btnEditPTKP, btnDeletePTKP;
    

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        prepareList();
    }

    public void onClick$btnAddPTKP() {
        Map map = new HashMap();
        map.put("parent", this);
        Executions.createComponents("/hrm/masterdata/payroll/ptkp/add_ptkp.zul", null, map);
    }

    public void onClick$btnEditPTKP() {
        if (listboxPtkp.getSelectedItem() != null)
        {
            Map map = new HashMap();
            map.put("parent", this);
            map.put("obj", ((PTKP)listboxPtkp.getSelectedItem().getAttribute("data")));
            Executions.createComponents("/hrm/masterdata/payroll/ptkp/edit_ptkp.zul", null, map);
        }
    }

    public void onClick$btnDeletePTKP() {
        if (listboxPtkp.getSelectedItem() != null)
        {
            PTKP ptkp = (PTKP)listboxPtkp.getSelectedItem().getAttribute("data");
            try {
                HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).deletePTKP(0, IDBConstants.MODUL_MASTER_DATA, ptkp.getIndex());
                prepareList();
            } catch (Exception ex) {
                Logger.getLogger(ShowPtkpController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void prepareList() {
        try {
            listboxPtkp.setItemRenderer(new ShowPtkpRenderer());
            listboxPtkp.setModel(new ListModelList(HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).getAllPTKP(0, IDBConstants.MODUL_MASTER_DATA)));
        } catch (Exception ex) {
            Logger.getLogger(ShowPtkpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}