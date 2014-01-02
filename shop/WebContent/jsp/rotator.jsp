<jsp:useBean id="rotator" class="pjsp.shopmall.beans.RotatorBean" scope="application">
<%
String realPath = application.getRealPath("/jsp/images/img.properties");
rotator.setInit(realPath);
%>
</jsp:useBean>
<BR>
<A HREF="<jsp:getProperty name="rotator" property="imageURL" />">
<img BORDER="0" src="<jsp:getProperty name="rotator" property="imageName"/>">
</A>
<BR>
