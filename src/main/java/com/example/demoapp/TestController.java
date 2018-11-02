/*************************************************************************
* 
* SATIN CREDITCARE NETWORK LIMITED CONFIDENTIAL
* __________________
* 
*  [2018] SATIN CREDITCARE NETWORK LIMITED
*  All Rights Reserved.
* 
* NOTICE:  All information contained herein is, and remains the property of SATIN CREDITCARE NETWORK LIMITED, and
* The intellectual and technical concepts contained herein are proprietary to SATIN CREDITCARE NETWORK LIMITED
* and may be covered by India and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
* Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission
* is obtained from SATIN CREDITCARE NETWORK LIMITED.
*/
package com.example.demoapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> hello(HttpServletRequest request) {

		return new ResponseEntity<Object>("Hi Your Public IP is : " + request.getRemoteAddr(), HttpStatus.OK);
	}

	@RequestMapping(value = "/world", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> world(HttpServletRequest request) {

		return new ResponseEntity<Object>(new Person("Shahzad", "Hussain", 26), HttpStatus.OK);
	}

	@RequestMapping(value = "/getAddress", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getRemoteAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		System.out.println(ip);
		String remoteAddr = "";
		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
		}
		System.out.println("Success : \t " + remoteAddr);
		return new ResponseEntity<Object>("Hi Your Public IP is : \t " + remoteAddr + "", HttpStatus.OK);
	}

}
