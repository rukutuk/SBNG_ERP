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
        //if (emp.getCertificate()!=null){
            Listcell cell = new Listcell(emp.getNo());
            cell.setParent(lstm);        
        //}                
        lstm.setAttribute("data", emp);
    }
}

