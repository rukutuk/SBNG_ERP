/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer.hrm.employee.data;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.hrm.cgui.EmployeeEducation;

/**
 *
 * @author nungky
 */
public class ShowEducationRenderer implements ListitemRenderer{   

    public void render(Listitem lstm, Object o) throws Exception {
        EmployeeEducation emp = (EmployeeEducation) o;
        
        Listcell cell = new Listcell(emp.getGrade().toString());
        cell.setParent(lstm);        
        
        cell = new Listcell(emp.getMajorStudy());
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getInstitute());
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getFrom().toString());
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getTo().toString());
        cell.setParent(lstm);
        
        cell = new Listcell(String.valueOf(emp.getGPA()));
        cell.setParent(lstm);
        
        cell = new Listcell(String.valueOf(emp.getMaxGPA()));
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getDescription());
        cell.setParent(lstm);
        
        lstm.setAttribute("data", emp);
    }
}

