/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

//import beacukai.ekspor.constant.UIConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Paging;

/**
 *
 * @author Tata
 */
public class ZKUtil {

    public static ListModelList renderListbox(Listbox listbox, List list, ListitemRenderer listItemRender) {
//        if (!StringUtil.isListNotEmpty(list)) {
//            list = new ArrayList();
//        }
        if (list == null) {
            list = new ArrayList();
        }
        ListModelList model = new ListModelList(list);
        listbox.setModel(new ListModelList(list));
        listbox.setItemRenderer(listItemRender);
        return model;
    }

    public static ListModelList renderListbox(Listbox listbox, List list, ListitemRenderer listItemRender, Paging paging, int recordCount) {
        if (list == null) {
            list = new ArrayList();
        }
        if (recordCount == 0) {
            paging.setVisible(false);
        } else {
            paging.setVisible(true);
            paging.setTotalSize(recordCount / 10);
            paging.setDetailed(true);
        }
        ListModelList model = new ListModelList(list);
        listbox.setModel(new ListModelList(list));
        listbox.setItemRenderer(listItemRender);
        return model;
    }

    public static void renderCombobox(Combobox combobox, List list, ComboitemRenderer comboItemRender) {
        if (list == null) {
            list = new ArrayList();
        }
        combobox.setModel(new ListModelList(list));
        combobox.setItemRenderer(comboItemRender);
    }

    public static void clearListbox(Listbox listbox) {
        if (listbox != null) {
            ListModelList lml = (ListModelList) listbox.getModel();
            if (lml != null) {
                lml.clear();
            }
        }
    }

    public static void showMenuItem(String url, Div mainInclude, Map map) {
        mainInclude.invalidate();
        mainInclude.getChildren().clear();
        Executions.createComponents(url, mainInclude, map);
    }

    public static void doPopup(Map map, String zulToOpen) {
        Executions.createComponents(zulToOpen, null, map);
    }

    public static Map<String, Object> doAfterCompose() {
        return Executions.getCurrent().getArg();
    }

    public static List getListboxSelectedItems(Listbox listbox) {
//        Set set = listbox.getSelectedItems();
//        Iterator itr = set.iterator();
//        List listObj = new ArrayList();
//        while (itr.hasNext()) {
//            Listitem obj = (Listitem) itr.next();
//            listObj.add(obj.getAttribute("data"));
//        }
//        return listObj;
        return getListboxSelectedItems(listbox, null);
    }

    public static List getListboxSelectedItems(Listbox listbox, String attrKey) {
        if (attrKey == null) {
            attrKey = "data";
        }
        Set set = listbox.getSelectedItems();
        Iterator itr = set.iterator();
        List listObj = new ArrayList();
        while (itr.hasNext()) {
            Listitem obj = (Listitem) itr.next();
            listObj.add(obj.getAttribute(attrKey));
        }
        return listObj;
    }
}
