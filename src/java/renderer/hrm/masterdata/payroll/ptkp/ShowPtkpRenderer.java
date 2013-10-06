/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package renderer.hrm.masterdata.payroll.ptkp;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.hrm.cgui.PTKP;

/**
 *
 * @author Tata
 */
public class ShowPtkpRenderer implements ListitemRenderer{

    public void render(Listitem lstm, Object o) throws Exception {
        PTKP ptkp = (PTKP) o;
        
        Listcell cell = new Listcell(ptkp.getName());
        cell.setParent(lstm);
        
        cell = new Listcell(ptkp.getDescription());
        cell.setParent(lstm);
        
        cell = new Listcell(String.valueOf(ptkp.getValue()));
        cell.setParent(lstm);
        
        lstm.setAttribute("data", ptkp);
    }

}
