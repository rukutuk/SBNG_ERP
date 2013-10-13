package controller.project.masterdata.partner.partnerdata.specificaddress;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class AddSpecificAddressController extends GenericForwardComposer {
	Window  windowAddSpecificAddress;
	Textbox  addressname,city,country,fax1,phone1,province,street;
	Intbox  partnerindex,postalcode;
	Toolbarbutton  btnSaveSpecificAddress,btnCancelSpecificAddress;

	ShowSpecificAddressController parent;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowSpecificAddressController) map.get("parent");
		windowAddSpecificAddress.doModal();
	}

	public void onClick$btnCancelSpecificAddress() {
		closeWindow();
	}

	public void closeWindow() {
		windowAddSpecificAddress.onClose();
	}

	public void onClick$btnSaveSpecificAddress() {
		try
		{
			// SpecificAddress specificAddress = new SpecificAddress();
			// specificAddress.setAddressname(addressname.getValue());
			// specificAddress.setCity(city.getValue());
			// specificAddress.setCountry(country.getValue());
			// specificAddress.setFax1(fax1.getValue());
			// specificAddress.setPartnerindex(partnerindex.getValue());
			// specificAddress.setPhone1(phone1.getValue());
			// specificAddress.setPostalcode(postalcode.getValue());
			// specificAddress.setProvince(province.getValue());
			// specificAddress.setStreet(street.getValue());
			// NUNUNG
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}