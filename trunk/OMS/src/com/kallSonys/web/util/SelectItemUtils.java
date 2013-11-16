/**
 * 
 */
package com.kallSonys.web.util;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
public class SelectItemUtils {
	
		/**
		 * Este metodo construye un SelectItem a partir de los
		 * parametros pasados
		 * @param elements
		 * @param keyProp
		 * @param valueProp
		 * @param needEmptySelectItem
		 * @return
		 * @throws Exception
		 */
		public static List<SelectItem> buildSelectItems(List<?> elements,String keyProp, String valueProp,boolean needEmptySelectItem) throws Exception{
			List<SelectItem> selectItems = new ArrayList<SelectItem>();
	
			if(needEmptySelectItem){
				selectItems.add(new SelectItem("0","Selecciona..."));
			}
			Object key;
			Object value;
			for(Object object : elements){
				key= BeanUtils.getNestedProperty(object, keyProp);
				value=BeanUtils.getNestedProperty(object, valueProp);
				selectItems.add(new SelectItem(key,value.toString()));
			}
			return selectItems;
		}

}
