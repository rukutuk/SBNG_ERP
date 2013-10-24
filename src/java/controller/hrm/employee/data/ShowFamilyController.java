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
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import pohaci.gumunda.titis.hrm.cgui.Employee;
import pohaci.gumunda.titis.hrm.cgui.EmployeeFamily;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import renderer.hrm.employee.data.ShowEducationRenderer;
import renderer.hrm.employee.data.ShowFamilyRenderer;
import util.ConnectionUtil;

/**
 *
 * @author nungky
 */
public class ShowFamilyController extends GenericForwardComposer {
    Employee m_emp = null;    
    Connection m_conn = null;
    Listbox listboxShowFamily;
    Textbox textName, textRelation, textBirthPlace, dateBirthDate, textEducation;
    Textbox textRemark, textJobTitle, textCompany;
    //Toolbarbutton btnAddEmployee, btnEditEmployee, btnDeletePTKP;
    //Button btnCancelPTKP;
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        m_conn =  ConnectionUtil.getInstance().getConn();
        m_emp = HRMBusinessLogic.getInstance(m_conn).getEmployeeByIndex(0, IDBConstants.ATTR_EMPLOYEE,2);
        if (m_emp!=null){
            setEmployeeFamily(m_emp.getIndex());
        }
    }
    
    private void setEmployeeFamily(long index) throws Exception{
      EmployeeFamily[] emp = HRMBusinessLogic.getInstance(m_conn).getEmployeeFamily(0, IDBConstants.ATTR_EMPLOYEE,index);
      if (emp !=null){
        try {
          listboxShowFamily.setItemRenderer(new ShowFamilyRenderer());
          listboxShowFamily.setModel(new ListModelList(emp));           
          setFamily(emp[0]);
        } catch (Exception ex) {
           Logger.getLogger(ShowEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    }
    
    private void setFamily(EmployeeFamily fam) throws Exception
    {
        textName.setValue(fam.getName());
        if (fam.getRelation()!= null)
            textRelation.setValue(fam.getRelation().toString());
        textBirthPlace.setValue(fam.getBirthPlace());
        dateBirthDate.setValue(fam.getBirthDate().toString());
        if (fam.getEducation()!=null)
            textEducation.setValue(fam.getEducation().toString());
        textRemark.setValue(fam.getRemark()); 
        textJobTitle.setValue(fam.getJobTitle());
        textCompany.setValue(fam.getCompany());
    }
        
}
