
package renderer.hrm.masterdata.payroll.taxart21tariff;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.hrm.cgui.TaxArt21Tariff;

public class ShowTaxArt21TariffRenderer implements ListitemRenderer{

	public void render(Listitem lstm, Object o) throws Exception {
		 TaxArt21Tariff taxArt21Tariff = (TaxArt21Tariff) o;

		 Listcell cell = new Listcell(String.valueOf(taxArt21Tariff.getMaximum()));
		 cell.setParent(lstm);

		 cell = new Listcell(String.valueOf(taxArt21Tariff.getMinimum()));
		 cell.setParent(lstm);

		 cell = new Listcell(String.valueOf(taxArt21Tariff.getTariff()));
		 cell.setParent(lstm);

		lstm.setAttribute("data", taxArt21Tariff);
	}
}