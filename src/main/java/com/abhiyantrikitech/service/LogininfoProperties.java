package com.abhiyantrikitech.service;

import org.springframework.stereotype.Service;

import com.abhiyantrikitech.model.Logininfo;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

@Service
public class LogininfoProperties {

		
	   public static Logininfo getLogininfo(String username){
			
		InetAddress ip;
		Logininfo logininfo=null;
		String ipAdd=null;
		String hostName=null;
		try {
				
			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());
			ipAdd=ip.getHostAddress();
			System.out.println("Current Host name : " + ip.getHostName());
			hostName=ip.getHostName();
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
				
			byte[] mac = network.getHardwareAddress();
				
			System.out.print("Current MAC address : "+mac);
				
			StringBuilder sb = new StringBuilder();
			
			if(mac!=null){
				System.out.println("mac object"+mac);
			
			
				for (int i = 0; i < mac.length; i++) {
					sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));		
				}
			
			}
			System.out.println(sb.toString());
			
			logininfo=new Logininfo();
			
			logininfo.setLdCrtBy(username);
			logininfo.setLdIp(ipAdd);
			logininfo.setLdLoginId(username);
			logininfo.setLdMacId(sb.toString());
			logininfo.setLdHostName(hostName);
			
				
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			
		} catch (SocketException e){
				
			e.printStackTrace();
				
		}
		
		return logininfo;
		    
	   }
	   
	   public static Logininfo getRemoteMachineinfo(String username,HttpServletRequest request){
			
		   String ip;
			Logininfo logininfo=null;
			String ipAdd=null;
			String hostName=null;
			String str = ""; 
		    String output = "";
		    String macAddress = "";
			try {
					
				ip = request.getRemoteAddr();
				System.out.println("Remote IP address : " + ip);
				/*System.out.println("111 IP request.getHeader()=="+request.getHeader("X-Forwarded-For"));
				System.out.println("222 IP request.getHeader()=="+request.getHeader("Proxy-Client-IP"));
				System.out.println("333 IP request.getHeader()=="+request.getHeader("WL-Proxy-Client-IP"));
				System.out.println("444 IP request.getHeader()=="+request.getHeader("HTTP_CLIENT_IP"));
				System.out.println("555 IP request.getHeader()=="+request.getHeader("HTTP_X_FORWARDED_FOR"));				
				System.out.println("666 IP request.getHeader()=="+request.getHeader("HTTP_X_FORWARDED"));
				System.out.println("777 IP request.getHeader()=="+request.getHeader("HTTP_X_CLUSTER_CLIENT_IP"));
				System.out.println("888 IP request.getHeader()=="+request.getHeader("HTTP_FORWARDED"));
				System.out.println("999 IP request.getHeader()=="+request.getHeader("HTTP_VIA"));
				System.out.println("000 IP request.getHeader()=="+request.getHeader("REMOTE_ADDR"));
				System.out.println("121 IP request.getHeader()=="+request.getHeader("X-Real-IP"));*/
				
				
				
				
				
				
				
				
				
				hostName=request.getRemoteHost();
				System.out.println("Remote Host name : " + hostName);
				
				
				
				/////////////////////////////////////////////////////////
				
							
				/*Process p = Runtime.getRuntime().exec("cmd /c arp -a "+ip); 
		          InputStreamReader ir = new InputStreamReader(p.getInputStream()); 
		          LineNumberReader input = new LineNumberReader(ir); 
		         System.out.println("input="+input);
		          for (int i = 1; i <5; i++) { 
		               str = input.readLine(); 
		              // System.out.println("str="+i+"=="+str);
		               if (str != null && i==4) { 
		                    
		            	   output = str.trim().replaceAll("\\s{1,}", ",");
		                       
		               } 
		          } 
		          	//System.out.println("output==="+output);
		          	
		          	//System.out.println("index==="+output.indexOf(",")+","+output.lastIndexOf(","));
		            if (output.indexOf(",")==output.lastIndexOf(","))
		        	{
		            	macAddress=output.substring(output.indexOf(",")+1);
		            	
		        	}
		        	else
		        	{
		        		macAddress=output.substring(output.indexOf(",")+1, output.lastIndexOf(","));
		        	}*/
				
		          System.out.println("Remote MAC Address==="+macAddress);
				
				//////////////////////////////////////////////////////////
				
				logininfo=new Logininfo();
				
				logininfo.setLdCrtBy(username);
				logininfo.setLdIp(ip);
				logininfo.setLdLoginId(username);
				logininfo.setLdMacId(macAddress);
				logininfo.setLdHostName(hostName);
				
					
			
					
			}
			catch (Exception e){
				
				e.printStackTrace();
					
			}
			
			return logininfo;
			    
		   }


	}
