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
public class ShowProfileController extends GenericForwardComposer{
    Textbox textFirstName, textLastName, textJobTitle, textBirthPlace, textSex, textDepartment;
    Textbox textUnitCode, textEducation, textQualification, textReligion, textNationality, textMaritalStatus, textTaxArt21Status;
    Textbox textAddress, textCity, textPostCode, textProvince, textCountry, textPhone, textMobilePhone_1;
    Textbox textMobilePhone_2, textFax, textEmail, textStatus;
    Datebox dateBirthDate;
    Employee m_emp = null;    
    Connection m_conn = null;
    Listbox listboxEmployment;
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        m_conn =  ConnectionUtil.getInstance().getConn();
        m_emp = HRMBusinessLogic.getInstance(m_conn).getEmployeeByIndex(0, IDBConstants.ATTR_EMPLOYEE,2);
        if (m_emp!=null){
            textFirstName.setValue(m_emp.getFirstName());
            textLastName.setValue(m_emp.getLastName());
            textJobTitle.setValue(m_emp.getJobTitleName());
            textBirthPlace.setValue(m_emp.getBirthPlace());            
            textDepartment.setValue(m_emp.getDepartment());
            textUnitCode.setValue("");
            textEducation.setValue("");
            textQualification.setValue(m_emp.getQualificationToString());            
            textNationality.setValue(m_emp.getNationality());            
            textAddress.setValue(m_emp.getAddress());
            textCity.setValue(m_emp.getCity());            
            textProvince.setValue(m_emp.getProvince());
            textCountry.setValue(m_emp.getCountry()); 
            textPhone.setValue(m_emp.getPhone()); 
            textMobilePhone_1.setValue(m_emp.getMobilePhone1());
            textMobilePhone_2.setValue(m_emp.getMobilePhone2()); 
            textFax.setValue(m_emp.getFax()); 
            textEmail.setValue(m_emp.getEmail());
            textStatus.setValue("");
            dateBirthDate.setValue(m_emp.getBirthDate());
            /*textPostCode.setValue(String.valueOf(m_emp.getPostCode()));
            textSex.setValue(String.valueOf(m_emp.getNSex()));
            textReligion.setValue(String.valueOf(m_emp.getNReligion()));
            textMaritalStatus.setValue(String.valueOf(m_emp.getNMarital()));
            textTaxArt21Status.setValue(String.valueOf(m_emp.getNArt21()));*/
        }
    }   
    
}
