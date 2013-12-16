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


public class Boot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			boot();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static final byte CR = '\r';
	public static final byte LF = '\n';
	private static ServerSocket serverSocket;
	// 클래스을 로딩하는 객체
	private static ClassLoader cl = new ClassLoader();
 
	private static void boot() throws IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		serverSocket = new ServerSocket(8000);
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
		in.close();
		socket.close();
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
		System.out.println("End of HTTP Message.");
	}
	
}
