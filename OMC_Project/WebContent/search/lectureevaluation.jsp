<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�����򰡵��</title>
<link rel="stylesheet" href="./css/omc.css" type="text/css">
</head>
<body onload='javascript:alert("��ϱⰣ�� �ƴմϴ�");'>
	<table border="0" width="85%">
		<tr>
			<td align="center"><b>���� | �����򰡵��</b></td>
		</tr>
		<tr>
		<td align="right"><input type="button" onclick="search(curi_num1.value,curi_nm1.value,kor_nm1.value,smt.value)" value="��ȸ">
			<input type="button" value="����"></td>
		</tr>
	</table>
	<br>
	<table border='1' width="85%" cellpadding="0" cellspacing="0">
		<tr>
			<td id=listTitle>�˻�����&nbsp;</td>
		</tr>
		<tr align="left">
			<td align="left" colspan="2">
				<table border='1' width="100%" cellpadding="0" cellspacing="0">
						<tr align="center">
							<td id=title width="5%" align="center">�г⵵</td>
							<td width="5%" align="center"><input type="text" size="4" value="2011"></td>
							<td id=title width="4%" align="center">�б�</td>
							<td width="5%" align="center"><select name="smt">
								<option value="10">1�б�</option>
								<option value="11">�����б�</option>
								<option value="20">2�б�</option>
								<option value="21">�ܿ��б�</option>
								</select>
							</td>
							<td id=title  width="5%" align="center">�򰡴�����</td>
							<td width="5%"><select name="smt">
								<option value="10">������ �Ⱓ�� �ƴմϴ�.</option>
								</select></td>
						</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table border='1' width="100%" cellpadding="0" cellspacing="0" id="searchTable">
					<tr>
						<td id=title colspan="4" width="100%">DATA&nbsp; *�������� ��� ���¿� ���� �����Ժ� �����򰡸� ����ؾ� �����б� ������ȸ�� �����մϴ�. �̹� �Ϸ�� ���´� ��ȸ,������ �Ұ��մϴ�.</td>
					</tr>
						<tr><td>
							<table border='1' width="100%" cellpadding="0" cellspacing="0">
								<col width="50">
								<col width="100">
								<col width="400">
								<col width="50">
								<col width="50">
								<col width="50">
								<col width="50">
								<col width="50">
								<tr id=listTitle>
									<td align="center">����</td>
									<td align="center">�򰡱���</td>
									<td align="center">���׸�</td>
									<td align="center">�ſ�׷���</td>
									<td align="center">���ݱ׷���</td>
									<td align="center">�����̴�</td>
									<td align="center">�׷����ʴ�</td>
									<td align="center">�ſ�׷����ʴ�</td>
								</tr>
								<tr height="100">
									<td colspan="8" align="center">���� �� �Ⱓ�� �ƴմϴ�^^</td>
								</tr>
							</table>
							</td>
						</tr>
						<tr>
							<td id=listTitle colspan="2" align="center">�ذ��ǻ����� �Է����ּ���</td>
						</tr>
						<tr>
							<td align="center" colspan="2">
							<textarea rows='3', cols='100'>���ǻ����� �����ְ� ���ּ���. ������ �ݵ�� ��Ƴ��ϴ�.</textarea></td>
						</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>