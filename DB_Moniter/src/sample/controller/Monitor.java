package sample.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import sample.dao.SampleDao;

public class Monitor extends Thread {

	private int iPreCnt = 0;
	private int iCurCnt = 0;
	private SampleDao oDao = null;
	private boolean bChk = false;
	private String strTime = "";
	private static Logger logger = Logger.getLogger("sample.controller.Monitor");
	
	public Monitor(String pTime) {
		oDao = new SampleDao();
		iPreCnt = Integer.parseInt(oDao.getBoardCnt());
		this.strTime = pTime;
	}

	public boolean checkData(int pCurCnt) {
		logger.log(Level.INFO, "checkData!!" + "전 = "+iPreCnt + "행 / " + "후 = "+iCurCnt + "행");
		if (iPreCnt != pCurCnt) { // 데이터가 변화된경우.
			logger.log(Level.INFO, "데이터 변화가 있습니다!!");
			bChk = true;
		} else {
			bChk = false;
		}
		// 현재cnt를 이전 cnt로
		iPreCnt = pCurCnt;

		return bChk;
	}

	public void run() {
		while (true) {
			iCurCnt = Integer.parseInt(oDao.getBoardCnt());
			checkData(iCurCnt);
			try {
				sleep(Integer.parseInt(this.strTime)* 1000);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
