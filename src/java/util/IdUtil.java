/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beacukai.ekspor.util;

import java.util.UUID;

/**
 *
 * @author User
 */
public class IdUtil {

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
