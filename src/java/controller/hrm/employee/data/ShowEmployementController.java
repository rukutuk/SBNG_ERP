/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.hrm.employee.data;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import pohaci.gumunda.titis.hrm.cgui.Employee;
import pohaci.gumunda.titis.hrm.cgui.Employment;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import renderer.hrm.employee.data.ShowEmploymentRenderer;
import util.ConnectionUtil;

/**
 *
 * @author nungky
 */
public class ShowEmployementController extends GenericForwardComposer {
    Textbox textJobTitle,textDepartment, textUnitCode, textRefNo, textTMT, textWorkAgreement, textDescription;
    Datebox  dateRefDate, dateEndDate;
    Employee m_emp = null;
    Connection m_conn = null;
    Listbox listboxEmployment;
    //Toolbarbutton btnAddEmployee, btnEditEmployee, btnDeletePTKP;
    //Button btnCancelPTKP;
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        m_conn =  ConnectionUtil.getInstance().getConn();
        m_emp = HRMBusinessLogic.getInstance(m_conn).getEmployeeByIndex(0, IDBConstants.ATTR_EMPLOYEE,1);
        if (m_emp!=null){
            setEmployeeEmployment(m_emp.getIndex());
        }
    }
    
    private void setEmployeeEmployment(long index) throws Exception{
      Employment[] emp = HRMBusinessLogic.getInstance(m_conn).getEmployeeEmployment(0, IDBConstants.ATTR_EMPLOYEE,index);
      if (emp !=null){
        try {
          listboxEmployment.setItemRenderer(new ShowEmploymentRenderer());
          listboxEmployment.setModel(new ListModelList(emp));          
          setEmployment(emp[0]);
        } catch (Exception ex) {
           Logger.getLogger(ShowEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
       }     
    }
    
    private void setEmployment(Employment emp) throws Exception
    {
        //Textbox textJobTitle,textDepartment, textUnitCode, textRefNo, textTMT, textWorkAgreement, textDescription;
        //Datebox  dateRefDate, dateEndDate;
        if (emp.getJobTitle()!=null)
            textJobTitle.setValue(emp.getJobTitle().toString());
        if (emp.getDepartment()!=null)
            textDepartment.setValue(emp.getDepartment().toString());
        if (emp.getUnit()!=null)
            textUnitCode.setValue(emp.getUnit().toString());
        
        textRefNo.setValue(emp.getReferenceNo());
        textTMT.setValue(emp.getTMT().toString());
        textWorkAgreement.setValue(emp.getDescription());
        dateRefDate.setValue(emp.getReferenceDate());
        dateEndDate.setValue(emp.getEndDate());
        textDescription.setValue(emp.getDescription());
    }
}
