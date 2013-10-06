/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beacukai.ekspor.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tata
 */
public class MapUtil{
    private static MapUtil mapUtil = null;
    private static Map map = new HashMap();

    public static MapUtil put(String key, Object val) {
        if (mapUtil == null) {
            mapUtil = new MapUtil();
        }
        if (map == null)
        {
            map = new HashMap();
        }
        map.put(key, val);
        return mapUtil;
    }
    public static Map xtract()
    {
        Map map2 = map;
        map = null;
        return map2;
    }
    
    public static void main(String[] args) {
        Map map = mapUtil.put("1", "1").put("2", "2").put("3", "3").xtract();
        System.out.println("map = " + map);
        map = mapUtil.put("4", "4").put("5", "5").put("6", "6").xtract();
        System.out.println("map = " + map);
    }
    
    
}
