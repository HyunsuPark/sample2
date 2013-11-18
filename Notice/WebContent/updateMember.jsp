<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="member.model.dto.Member" %>
<%
	session = request.getSession(false);
	Member m = (Member)session.getAttribute("member");
%>

<%!
	public static String isSel(String strMem,String strValue,String strForm){
		String rt = "";	
		
		if(strForm.equals("select")){ //selectBox 인경우
			if(strValue.equals(strMem)){
				rt = "selected";
			}
		}else{ //그외
			String[] arrTemp = strMem.split(",");
		
			for(String s : arrTemp){
				if(strValue.equals(s)){
					rt = "checked";
					break;
				}
			}
		}
		
		return rt;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원정보 수정페이지</title>
</head>
<body>

	<h1>회원 정보 수정 페이지입니다.</h1>
	<hr/>
	<form name="memberin" action="mupdate" method="post" >
    <table style="width:500px;align:center;">
        <tr>
            <th colspan="2"></th>
        </tr>
        <tr>
            <th colspan="2">회원 정보 수정 </th>
        </tr>
        <tr>
            <td width="130" align="right">
                <b>ID :</b>&nbsp;
            </td>
            <td>
                 <input type="text" name="memberId" size="15" maxlength="12" readonly value="<%= m.getMemberId() %>"> 
            </td>
        </tr>
        <tr> 
            <td width="130" align="right"> 
                <b>이름 :</b>&nbsp;
            </td>
            <td> 
                <input type="text" name="name" id="tname" size="15" maxlength="20" autofocus value="<%= m.getName() %>">
            </td>
        </tr>
        <tr> 
            <td width="130" align="right">
                <b>암호 :</b>&nbsp;
            </td>
            <td>
                <input type="password" name="password" id="tpwd" size="15" maxlength="8" value="<%= m.getPassword() %>">  
            </td>
        </tr>
        <tr> 
            <td width="130" align="right">
                <b>암호확인 :</b>&nbsp;
            </td>
            <td>
                <input type="password" name="pwdcheck" id="tpwd2" size="15" maxlength="8" value="<%= m.getPassword() %>">  
            </td>
        </tr>
        <tr> 
            <td width="130" align="right">
                <b>주 소 :</b>&nbsp;
            </td>
            <td>
                <input type="text" name="address" size="50" maxlength="48" value="<%= m.getAddress() %>">
            </td>
        </tr>
        <tr> 
            <td width="130" align="right">
                <b>전화번호 :</b>&nbsp;
            </td>
            <td> 
                <input type="text" name="phone" size="15" maxlength="14" value="<%= m.getPhone() %>">
            </td>
        </tr>
        <tr> 
            <td width="130" align="right">
                <b>본인확인 힌트 :</b>&nbsp;
            </td>
            <td>
                <select name="passwordQuestion">
                    <option value="태어난 고향은?" <%= isSel(m.getPasswordQuestion(), "태어난 고향은?", "select") %> >태어난 고향은?</option>
                    <option value="출신 초등학교 이름은?" <%= isSel(m.getPasswordQuestion(), "출신 초등학교 이름은?", "select") %> >출신 초등학교 이름은?</option>
                    <option value="배우자의 이름은?" <%= isSel(m.getPasswordQuestion(), "배우자의 이름은?", "select") %> >배우자의 이름은?</option>
                    <option value="가장 친한 친구 이름은?" <%= isSel(m.getPasswordQuestion(), "가장 친한 친구 이름은?", "select") %> >가장 친한 친구 이름은?</option>
                    <option value="가장 좋아하는 연예인은?" <%= isSel(m.getPasswordQuestion(), "가장 좋아하는 연예인은?", "select") %> >가장 좋아하는 연예인은?</option>
                    <option value="가장 좋아하는 색상은?" <%= isSel(m.getPasswordQuestion(), "가장 좋아하는 색상은?", "select") %> >가장 좋아하는 색상은?</option>
                </select>
            </td>
        </tr>
        <tr> 
            <td width="130" align="right">
                <b>본인확인 답변:</b>&nbsp;
            </td>
            <td>
                <input type="text" name="passwordAnswer" size="30" maxlength="28" value="<%= m.getPasswordAnswer() %>">
            </td>
        </tr>
        <tr> 
            <td width="130" align="right">
                <b>결혼 여부:</b>&nbsp;
            </td>
            <td>
                <input type="radio" name="marriage" value="Y" <%= isSel(m.getMarriage(), "Y", "") %>>기혼
                <input type="radio" name="marriage" value="N" <%= isSel(m.getMarriage(), "N" , "") %>>미혼
            </td>
        </tr>
        <tr> 
            <td width="130" align="right">
                <b>취미:</b>&nbsp;
            </td>
            <td>
                <input type="checkbox" name="hobby" value="컴퓨터" <%= isSel(m.getHobby(), "컴퓨터", "") %>>컴퓨터
                <input type="checkbox" name="hobby" value="문화" <%= isSel(m.getHobby(), "문화", "") %>>문화
                <input type="checkbox" name="hobby" value="스포츠" <%= isSel(m.getHobby(), "스포츠", "") %>>스포츠
                <input type="checkbox" name="hobby" value="기타" <%= isSel(m.getHobby(), "기타", "") %>>기타
            </td>
        </tr>
        <tr> 
            <td width="130" align="right">
                <b>비고:</b>&nbsp;
            </td>
            <td>
                <textarea name="etc" rows=3 cols=40><%= m.getEtc() %></textarea>
            </td>
        </tr>
        <tr>
            <td colspan=2 align="center">
                <input type="submit" value="수정완료">
                <input type="button" value="취소" onclick="location.replace('index.html');">
            </td>
        </tr>
    </table>
    </form>
    
    <a href="index.html" target="_top">첫페이지로 이동</a>
</body>
</html>