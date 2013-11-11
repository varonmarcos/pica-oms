/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanTest;

import javax.ejb.Remote;

/**
 *
 * @author Frank
 */
@Remote
public interface testSessionBeanLocal {
    
    public void test();
}
