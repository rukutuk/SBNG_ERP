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
import pohaci.gumunda.titis.hrm.cgui.EmployeeFamily;

/**
 *
 * @author nungky
 */
public class ShowFamilyRenderer implements ListitemRenderer{   

    public void render(Listitem lstm, Object o) throws Exception {
        EmployeeFamily emp = (EmployeeFamily) o;
        Listcell cell = null;        
        
        if (emp.getRelation()!=null)
            cell = new Listcell(emp.getRelation().toString());            
        else
            cell = new Listcell("");            
        cell.setParent(lstm);        
        
        cell = new Listcell(emp.getName());
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getBirthPlace().toString());
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getBirthDate().toString());
        cell.setParent(lstm);
        
        if (emp.getEducation()!=null)
            cell = new Listcell(emp.getEducation().toString());
        else
            cell = new Listcell("");
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getJobTitle());
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getCompany());
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getCompany());
        cell.setParent(lstm);
        
        lstm.setAttribute("data", emp);
    }
}

