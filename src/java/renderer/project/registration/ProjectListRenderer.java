/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package renderer.project.registration;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.project.cgui.ProjectData;

/**
 *
 * @author Tata
 */
public class ProjectListRenderer implements ListitemRenderer{

    public void render(Listitem lstm, Object o) throws Exception {
        ProjectData data = (ProjectData) o;
        Listcell cell = new Listcell(data.getORNo());
        cell.setParent(lstm);
        
        cell = new Listcell(data.getCode());
        cell.setParent(lstm);
        
        cell = new Listcell(data.getCustname());
        cell.setParent(lstm);
        
        cell = new Listcell(data.getWorkDescription());
        cell.setParent(lstm);
        
        cell = new Listcell(data.getAct());
        cell.setParent(lstm);
        
        cell = new Listcell(data.getORNo());
        cell.setParent(lstm);
        
        if (data.getORDate()!=null)
            cell = new Listcell(data.getORDate().toString());
        else
            cell = new Listcell("");
        cell.setParent(lstm);
        
        cell = new Listcell(data.getPONo());
        cell.setParent(lstm);
        
        if (data.getPODate()!=null)
            cell = new Listcell(data.getPODate().toString());
        else
            cell = new Listcell("");
        cell.setParent(lstm);
        
        cell = new Listcell(data.getIPCNo());
        cell.setParent(lstm);
        
        if (data.getIPCDate()!=null)
            cell = new Listcell(data.getIPCDate().toString());
        else
            cell = new Listcell("");
        cell.setParent(lstm);
        
        if (data.getStartdate()!=null)
            cell = new Listcell(data.getStartdate().toString());
        else
            cell = new Listcell("");        
        cell.setParent(lstm);
        
        if (data.getEnddate()!=null)
            cell = new Listcell(data.getEnddate().toString());
        else
            cell = new Listcell("");        
        cell.setParent(lstm);
        
        if (data.getValidation()!=null)
            cell = new Listcell(data.getValidation().toString());
        else
            cell = new Listcell("");        
        cell.setParent(lstm);
        
        lstm.setAttribute("data", data);
    } 

}
