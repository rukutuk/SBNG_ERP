/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer.hrm.masterdata.customer.customergroup;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.project.cgui.CompanyGroup;

/**
 *
 * @author nungky
 */
public class ShowCustomerGroupRenderer implements ListitemRenderer{

    public void render(Listitem lstm, Object o) throws Exception {        
        CompanyGroup cGroup = (CompanyGroup) o;
        
        Listcell cell = new Listcell(cGroup.getName());
        cell.setParent(lstm);
        
        cell = new Listcell(cGroup.getDescription());
        cell.setParent(lstm);
                
        lstm.setAttribute("data", cGroup);
    }
    
}
