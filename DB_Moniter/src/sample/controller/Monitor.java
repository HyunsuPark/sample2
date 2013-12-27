package sample.controller;

import sample.dao.SampleDao;

public class Monitor extends Thread {

	int preCnt = 0;
	int curCnt = 0;
	SampleDao dao = null;
	boolean chk = false;
	String time = "";

	public Monitor(String time) {
		dao = new SampleDao();
		preCnt = Integer.parseInt(dao.getBoardCnt());
		this.time = time;
	}

	public boolean checkData(int p_curCnt) {
		System.out.println("checkData!!");
		System.out.println("전 : "+preCnt);
		System.out.println("후 : "+curCnt);
		if (preCnt != p_curCnt) { // 데이터가 변화된경우.
			System.out.println("변화!!");
			chk = true;
		} else {
			chk = false;
		}
		// 현재cnt를 이전 cnt로
		preCnt = p_curCnt;

		return chk;
	}

	public void run() {
		while (true) {
			curCnt = Integer.parseInt(dao.getBoardCnt());
			checkData(curCnt);
			try {
				sleep(Integer.parseInt(this.time)* 1000);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
