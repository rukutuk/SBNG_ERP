/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer.hrm.employee.data;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.hrm.cgui.Certification;
import pohaci.gumunda.titis.hrm.cgui.EmployeeFamily;

/**
 *
 * @author nungky
 */
public class ShowCertifiedRenderer implements ListitemRenderer{   

    public void render(Listitem lstm, Object o) throws Exception {
        Certification emp = (Certification) o;
        Listcell cell = new Listcell(emp.getNo());
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getDate().toString());
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getInstitute());
        cell.setParent(lstm);
        
        if (emp.getQualification()!=null){
            cell = new Listcell(emp.getQualification().toString());
            cell.setParent(lstm);
        }
        
        cell = new Listcell(emp.getDescription());
        cell.setParent(lstm);        
        
        if (emp.getStartDate()!=null)
            cell = new Listcell(emp.getStartDate().toString());
        else
            cell = new Listcell("");
        cell.setParent(lstm);
        
        if (emp.getStartDate()!= null)
            cell = new Listcell(emp.getStartDate().toString());
        else
            cell = new Listcell("");
        cell.setParent(lstm);
        
        if (emp.getEndDate()!=null)
            cell = new Listcell(emp.getEndDate().toString());
        else
            cell = new Listcell("");
        cell.setParent(lstm);
        
        if (emp.getExpireDate()!=null)
            cell = new Listcell(emp.getExpireDate().toString());
        else
            cell = new Listcell("");
            
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getResult());
        cell.setParent(lstm);
        
        lstm.setAttribute("data", emp);
    }
}

