package com.sample.main;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sample.load.ClassLoader;
import com.sample.load.XmlLoadder;

public class Boot {
	public static void main(String[] args) {
		try {
			loading();
			boot();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final byte CR = '\r';
	public static final byte LF = '\n';
	private static ServerSocket serverSocket;
 
	/**
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private static void boot() throws IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		serverSocket = new ServerSocket(8000);
		int cnt = 0;
		
		while (true) {
			System.out.println("Waiting for connection............");
			Socket socket = serverSocket.accept();
			InputStream in = socket.getInputStream();
			int oneInt = -1;
			byte oldByte = (byte) -1;
			StringBuilder sb = new StringBuilder();
			int lineNumber = 0;
			boolean bodyFlag = false;
			String method = null;
			String requestUrl = null;
			String httpVersion = null;
			int contentLength = -1;
			int bodyRead = 0;
			List<Byte> bodyByteList = null;
			Map<String, String> headerMap = new HashMap<String, String>();
			int readSize = 0;
			byte[] readBuffer = new byte[128];
			boolean isTerminal = false;
			while (0 < (readSize = in.read(readBuffer))) {
				for (int i = 0; i < readSize; i++) {
					byte thisByte = (byte) readBuffer[i];
					System.out.print((char) thisByte);
					if (bodyFlag) {
						bodyRead++;
						bodyByteList.add(thisByte);
						if (bodyRead >= contentLength) {
							isTerminal = true;
							break;
						}
					} else {
						if (thisByte == Boot.LF && oldByte == Boot.CR) {
							String oneLine = sb.substring(0, sb.length() - 1);
							lineNumber++;
							if (lineNumber == 1) {
								int firstBlank = oneLine.indexOf(" ");
								int secondBlank = oneLine.lastIndexOf(" ");
								method = oneLine.substring(0, firstBlank);
	 
								/***************
								 * 요청url
								 ***************/
								requestUrl = oneLine.substring(firstBlank + 1,
										secondBlank);
	 
								httpVersion = oneLine.substring(secondBlank + 1);
							} else {
								if (oneLine.length() <= 0) {
									bodyFlag = true;
									if ("GET".equals(method)) {
										isTerminal = true;
										break;
									}
									String contentLengthValue = headerMap
											.get("Content-Length");
									if (contentLengthValue != null) {
										contentLength = Integer
												.parseInt(contentLengthValue.trim());
										bodyFlag = true;
										bodyByteList = new ArrayList<Byte>();
									}
									continue;
								}
								int indexOfColon = oneLine.indexOf(":");
								String headerName = oneLine.substring(0,
										indexOfColon);
								String headerValue = oneLine
										.substring(indexOfColon + 1);
								headerMap.put(headerName, headerValue);
							}
							sb.setLength(0);
						} else {
							sb.append((char) thisByte);
						}
					}
					oldByte = (byte) thisByte;
				}
				if (isTerminal) {
					break;
				}
			}
			
			System.out.printf("METHOD: %s REQ: %s HTTP VER. %s\n", method,
					requestUrl, httpVersion);
			Map<String, String> paramMap = new HashMap<String, String>();
			int indexOfQuotation = requestUrl.indexOf("?");
			if (indexOfQuotation > 0) {
				StringTokenizer st = new StringTokenizer(
						requestUrl.substring(indexOfQuotation + 1), "&");
				while (st.hasMoreTokens()) {
					String params = st.nextToken();
					paramMap.put(params.substring(0, params.indexOf("=")),
							params.substring(params.indexOf("=") + 1));
				}
			}
			System.out.println("Header list");
			Set<String> keySet = headerMap.keySet();
			Iterator<String> keyIter = keySet.iterator();
			while (keyIter.hasNext()) {
				String headerName = keyIter.next();
				System.out.printf(" Key: %s Value: %s\n", headerName,
						headerMap.get(headerName));
			}
			if (bodyByteList != null) {
				if ("application/x-www-form-urlencoded".equals(headerMap.get(
						"Content-Type").trim())) {
					int startIndex = 0;
					byte[] srcBytes = new byte[bodyByteList.size()];
					String currentName = null;
					for (int i = 0; i < bodyByteList.size(); i++) {
						byte oneByte = bodyByteList.get(i);
						srcBytes[i] = oneByte;
						if ('=' == oneByte) {
							byte[] one = new byte[i - startIndex];
							System.arraycopy(srcBytes, startIndex, one, 0, i
									- startIndex);
							currentName = URLDecoder.decode(new String(one),
									"CP949");
							startIndex = i + 1;
						} else if ('&' == oneByte) {
							byte[] one = new byte[i - startIndex];
							System.arraycopy(srcBytes, startIndex, one, 0, i
									- startIndex);
							paramMap.put(currentName,
									URLDecoder.decode(new String(one), "CP949"));
							startIndex = i + 1;
						} else if (i == bodyByteList.size() - 1) {
							byte[] one = new byte[i - startIndex + 1];
							System.arraycopy(srcBytes, startIndex, one, 0, i
									- startIndex + 1);
							paramMap.put(currentName,
									URLDecoder.decode(new String(one), "CP949"));
							startIndex = i + 1;
						}
					}
				} else {
					System.out.print("Message Body-->");
					for (byte oneByte : bodyByteList) {
						System.out.print(oneByte);
					}
					System.out.println("<--");
				}
			}
			Set<String> paramKeySet = paramMap.keySet();
			Iterator<String> paramKeyIter = paramKeySet.iterator();
			while (paramKeyIter.hasNext()) {
				String paramName = paramKeyIter.next();
	 
				System.out.printf("paramName: %s paramValue: %s\n", paramName,
						paramMap.get(paramName));
			}
			
			cnt ++;
			System.out.println("================End of HTTP Message."+"("+cnt+")==================");
			
//			in.close();
//			socket.close();
		}
		
		
	}
	
	/**
	 * 로딩하기위한 메소드
	 */
	private static void loading(){
		String libSrc = loadXml();
		loadClass(libSrc);
	}
	
	/**
	 * lib경로를 받아 class파일을 로딩
	 * @param src
	 */
	private static void loadClass(String src){
		// 클래스을 로딩하는 객체
		ClassLoader cl = new ClassLoader();
		cl.init(src);
	}
	
	/**
	 * xml에 정의해놓은 설정파일을 읽음
	 * @return
	 */
	private static String loadXml(){
		XmlLoadder xml = new XmlLoadder();
		try {
			xml.load();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return xml.getLibFileSrc();
	}
	
}
