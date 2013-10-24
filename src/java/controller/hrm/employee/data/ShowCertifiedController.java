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
import pohaci.gumunda.titis.hrm.cgui.Certification;
import pohaci.gumunda.titis.hrm.cgui.Employee;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import renderer.hrm.employee.data.ShowCertifiedRenderer;
import util.ConnectionUtil;

/**
 *
 * @author nungky
 */
public class ShowCertifiedController extends GenericForwardComposer {
    Employee m_emp = null;    
    Connection m_conn = null;
    Listbox listboxShowCertification;
    Textbox textCertificateNo, textInstitution, textQualification, textDescription, textResult;
    Datebox dateCertificateDate, dateStartCourseDate, dateEndCourseDate, dateExpiryDate;
    //Toolbarbutton btnAddEmployee, btnEditEmployee, btnDeletePTKP;
    //Button btnCancelPTKP;
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        m_conn =  ConnectionUtil.getInstance().getConn();
        m_emp = HRMBusinessLogic.getInstance(m_conn).getEmployeeByIndex(0, IDBConstants.ATTR_EMPLOYEE,2);
        if (m_emp!=null){
            setEmployeeEducation(m_emp.getIndex());
        }
    }
    
    private void setEmployeeEducation(long index) throws Exception{
      Certification[] emp = HRMBusinessLogic.getInstance(m_conn).getEmployeeCertification(0, IDBConstants.ATTR_EMPLOYEE,index);
      if (emp !=null){
        try {
          listboxShowCertification.setItemRenderer(new ShowCertifiedRenderer());
          listboxShowCertification.setModel(new ListModelList(emp));          
          setAccount(emp[0]);
        } catch (Exception ex) {
           Logger.getLogger(ShowEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
       }     
    }
    
    private void setAccount(Certification emp) throws Exception
    {
        textCertificateNo.setValue(emp.getNo());
        textInstitution.setValue(emp.getInstitute());
        if (emp.getQualification()!=null)
            textQualification.setValue(emp.getQualification().toString());        
        textDescription.setValue(emp.getDescription()); 
        textResult.setValue(emp.getResult());
        if (emp.getDate()!=null)
            dateCertificateDate.setValue(emp.getDate()); 
        if (emp.getStartDate()!=null)
            dateStartCourseDate.setValue(emp.getStartDate());
        if (emp.getEndDate()!=null)
            dateEndCourseDate.setValue(emp.getEndDate()); 
        if (emp.getExpireDate() != null)
            dateExpiryDate.setValue(emp.getExpireDate());
    }
        
}
