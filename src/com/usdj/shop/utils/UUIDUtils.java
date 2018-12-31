/**
 * 
 */
package com.usdj.shop.utils;

import java.util.UUID;

/**
 * @author gerrydeng
 *
 */
public class UUIDUtils {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
