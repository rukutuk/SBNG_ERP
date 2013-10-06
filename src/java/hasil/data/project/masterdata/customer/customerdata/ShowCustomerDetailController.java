package hasil.data.project.masterdata.customer.customerdata;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.project.dbapi.IDBConstants;
import pohaci.gumunda.titis.project.logic.ProjectBusinessLogic;
import renderer.project.masterdata.customer.customerdata.ShowCustomerRenderer;
import util.ConnectionUtil;

/* @author Tata */
public class ShowCustomerDetailController extends GenericForwardComposer {

    Window windowShowCustomer;
    Textbox textCode, textName, textCity, textAddress, textPostCode, textProvince, textCountry, textPhone1, textPhone2, textFax1, textFax2, textEmail, textWebsite;
    Listbox listboxCustomer;
    Toolbarbutton btnAddCustomer, btnEditCustomer, btnDeleteCustomer;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        prepareList();
    }
    
    private void prepareList() {
        try {
            listboxCustomer.setItemRenderer(new ShowCustomerRenderer());
            listboxCustomer.setModel(new ListModelList(ProjectBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).getAllCustomer(0, IDBConstants.MODUL_MASTER_DATA)));
        } catch (Exception ex) {
            Logger.getLogger(ShowCustomerDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onClick$btnAddCustomer() {
        
    }
}