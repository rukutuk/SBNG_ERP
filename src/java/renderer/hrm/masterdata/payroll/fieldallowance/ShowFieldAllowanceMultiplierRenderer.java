
package renderer.hrm.masterdata.payroll.fieldallowance;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.hrm.cgui.AllowenceMultiplier;

public class ShowFieldAllowanceMultiplierRenderer implements ListitemRenderer{

	public void render(Listitem lstm, Object o) throws Exception {
		AllowenceMultiplier fieldAllowanceMultiplier = (AllowenceMultiplier) o;

		Listcell cell = new Listcell(fieldAllowanceMultiplier.getAreaCode());
		cell.setParent(lstm);

		cell = new Listcell(fieldAllowanceMultiplier.getDescription());
		cell.setParent(lstm);

		cell = new Listcell(String.valueOf(fieldAllowanceMultiplier.getMuliplier()));
		cell.setParent(lstm);

		lstm.setAttribute("data", fieldAllowanceMultiplier);
	}
}