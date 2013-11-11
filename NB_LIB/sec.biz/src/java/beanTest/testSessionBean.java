/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanTest;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Frank
 */
@Stateless(name = "testSessionBeanTest", mappedName = "testSessionBeanTest")
@Remote(testSessionBeanLocal.class)
public class testSessionBean implements testSessionBeanLocal {

    @Override
    public void test() {
        System.out.println("testSessionBeanTest dice hola");
    }
  
}
