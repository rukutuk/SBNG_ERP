package hasil.data.hrm.masterdata.absence.leavetype;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import controller.hrm.employee.data.ShowEmployeeController;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import renderer.hrm.masterdata.absence.leavetype.ShowLeaveTypeRenderer;
import util.ConnectionUtil;
/**
 *
 * @author nungky
 */
public class ShowLeaveTypeController extends GenericForwardComposer{
    Listbox listboxLeaveType;
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        System.out.println("masuk");
        prepareList();
    }   
    
     public void prepareList() {
      try {
         listboxLeaveType.setItemRenderer(new ShowLeaveTypeRenderer());
         listboxLeaveType.setModel(new ListModelList(HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).getAllLeaveType(0, IDBConstants.MODUL_MASTER_DATA)));
      } catch (Exception ex) {
         Logger.getLogger(ShowEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
}
