/**
 * @fileoverview
 * Construct Default
 * @author 김경태
 * @version 1.0
 */
 
/**
 * Const 
 * 컨트롤에서 사용하는 기본값에 대한 정의 클래스
 */
eXria.controls.xhtml.Default = {
  version : "1.0"
};

eXria.controls.xhtml.Default.UIControl = {
	position : "absolute",
	backgroundColor : "#747B82",
	color : "#ffffff",
	visible :  true,
	disabled :  false,
	zIndex :  0,
	movable : false,
	cursor : "default",
	tooltip : null,
	isTooltipDisplay : true,
	dir : "ltr",
	tabIndex : 0, 
	borderColor : "#A5BACC",
	borderStyle : "solid", 
	borderWidth :  1,
  focusBorderColor : "#BFC2C6",  
  focusBorderStyle : "solid",
  focusBorderWidth : 4  
  //className: null,
  //outerClassName: null  
	//accessKey : null,
	//left: 0,
	//top: 0,
	//height: 100,
	//width: 100,
};

eXria.controls.xhtml.Default.UIControl.tooltip = {
	backgroundImage : "eXria/controls/xhtml/images/deepblue/arrow.png",   // arrowImage
  borderColor : "#BFC2C6",
	borderStyle : "solid", 
	borderWidth : 4,
	color : "#FFFFFF",
	backgroundColor : "#747B82",
	fontSize : 11,
	filter : "alpha(opacity:80)",
	opacity : "0.80"
};

eXria.controls.xhtml.Default.InputBox = {
  value : null,
  maxLength : null,
  readOnly : false,
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 11,
  fontWeight : "normal",
  fontStyle : "normal",
  textAlign : "left",
  verticalAlign : "middle",
  textDecoration : "none",
  textTransform : "none"
};

eXria.controls.xhtml.Default.Button = {
  value : "Button",
  backgroundImage : "eXria/controls/xhtml/images/deepblue/theme_02.gif",
  imageFocused : null,
  imagePushed : null,
  imageMouseover : null,
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 11,
  fontWeight : "normal",
  fontStyle : "normal",
  borderWidth : 0,
  borderStyle : "solid",
  borderColor : "#1475C5",
  color : "#FFFFFF",
  backgroundColor : "#747B82",
  cursor : "auto",
  backgroundRepeat : "no-repeat",
  backgroundPosition : "top center"
};

eXria.controls.xhtml.Default.SecretBox = {
  value : null,
  maxLength : null,
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 11,
  fontWeight : "normal",
  fontStyle : "normal",
  textAlign : "left",
  verticalAlign : "middle",
  textDecoration : "none"
};

eXria.controls.xhtml.Default.Label = {
  backgroundColor : "#39424D",
  borderWidth: 1,
  overflow : "hidden",
  value : "Label",
  wordWrap : true,
  textDecoration : "none",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 11,
  fontWeight : "bold",
  fontStyle : "normal",
  textAlign : "center",
  verticalAlign : "middle"
};

eXria.controls.xhtml.Default.DateInput = {
  value : null,
  calendarEnable : true,
  dateFormat : "YYYY-MM-DD",
  maskPrompt : "_",
  minDate : "19000101",
  maxDate : "38001231",
  calendarImageUrl : "eXria/controls/xhtml/images/deepblue/calendar.png",
  readOnly : false,
  fontSize : 11,
  fontWeight : "normal",
  fontStyle : "normal",
  fontFamily : "Arial, Helvetica, sans-serif",
  textDecoration : "none",
  textAlign : "left",
  verticalAlign : "middle"
};

eXria.controls.xhtml.Default.Output = {
  value : "",
  format : null,
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 11,
  fontWeight : "normal",
  fontStyle : "normal",
  textAlign : "left",
  verticalAlign : "middle",
  textDecoration : "none",
  letterSpacing : "normal",
  lineHeight : "normal"
};
  
eXria.controls.xhtml.Default.TextArea = {
  rows : 20,
  cols : 20,
  readOnly : false,
  value : null,
  maxLength : -1,
  overflow : "auto",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 11,
  fontWeight : "normal",
  fontStyle : "normal",
  textAlign : "left",
  textDecoration : "none"
};

eXria.controls.xhtml.Default.Image = {
  src : null,
  imageOpacity : 100,
  borderStyle : "ridge"
};

eXria.controls.xhtml.Default.Object = {
  archive : null,
  classid : null,
  codebase : null,
  dataUrl : null,
  declare : null,
  standby : null,
  type : null,
  codetype : null,
  color : "white",
  backgroundColor : "black",
  borderWidth : 3,
  borderStyle : "ridge",
  borderColor : "green"
};

eXria.controls.xhtml.Default.Select = {
	displayMode : "horizontal",
	displayNum : 2,
	value : null,
	horizontalGap : 0,
	verticalGap : 0,
	offsetLeft : 0,
	offsetTop : 0,
	fontFamily : "Arial",
	fontSize : 10,
	fontWeight : "normal",
	fontStyle : "normal",
	itemgroup : { 
  		labelPos : "right", 
  		height : 30,
  		width : 100, 
  		textAlign : "left", 
  		verticalAlign : "middle", 
  		fontFamily : "Arial, Helvetica, sans-serif",
  		fontSize : 11,
  		fontWeight : "bold",
  		fontStyle : "normal",
  		color : "#FFFFFF",
  		backgroundColor : "#39424D", 
  		borderWidth : 0,
  		borderStyle : "groove", 
  		borderColor : "#BFC2C6"
	},
	labelTagName : "labelNode",
	valueTagName : "valueNode" 	
};

eXria.controls.xhtml.Default.ComboBox = {
  value : null,
  readOnly : false,
  selectedIndex : -1,
  heightBySize : false,
  verticalAlign : null,
  textAlign : "left",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 11,
  fontWeight : "normal",
  fontStyle : "normal",
  btnWidth : 19,
  btnBackgroundColor : "#7E8A94",
  btnColor : "#FFFFFF",
  btnImage : null,
  itemgroup : {
	  className : null,
	  optionWidth : 20,
	  selectorWidth : null,
	  overflow : "hidden",
	  borderWidth : 0,
	  borderStyle : "dotted",
	  borderColor : "black",
	  height : 20,
	  verticalAlign : "middle"
  },
  listarea : {
	  className : null,
	  appearance : "normal",
	  multiSelect : false,
	  size : 5,
	  heightBySize : false,
	  color : "#000000",
	  focusColor : "#FFFFFF",
	  overflow : "hidden",
	  overflowX : "hidden",
	  overflowY : "auto",
	  backgroundColor : "#E2E4E7",
	  focusBackgroundColor : "#39424D",
	  borderWidth : 4,
	  borderStyle : "solid",
	  borderColor : "#586168",
	  cellSpacing : 6,
	  height : 200
  },
  labelTagName : "labelNode",
  valueTagName : "valueNode"   
};

eXria.controls.xhtml.Default.ListBox = {
  value : null,
  selectedIndex : -1,
  overflow : "auto",
  overflowX : "hidden",
  overflowY : "auto",
  textAlign : "left",  
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 11,
  fontWeight : "bold",
  fontStyle : "normal",
  appearance : null,
  multiSelect : true,
  size : 5,
  heightBySize : true,
  focusColor : "#FFFFFF",
  focusBackgroundColor : "#C9CDD3",
  cellSpacing : 6,
  color : "#000000",
  backgroundColor : "#FFFFFF",  
  itemgroup : {
	  className : null,
	  selectorWidth : 20,
	  overflow : "hidden",
	  borderWidth : 1,
	  borderStyle : "solid",
	  borderColor : "#BFC2C6",
	  height : 20,
	  verticalAlign : "middle"
  }
};

eXria.controls.xhtml.Default.EditMask = {
  maskType : "string",
  mask : "xxxxx",
  maskPrompt : "_",
  value : "",
  verticalAlign : "middle",
  spinWidth : 20,
  spinNum : 1,
  useSpin : false,
  readOnly : false,
  maxLength : null,
  calendarImageUrl : "eXria/controls/xhtml/images/deepblue/calendar.png",
  calendarEnable : "true",
  textDecoration : "none",
  textTransform : "none",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 11,
  fontWeight : "normal",
  fontStyle : "normal"
};

eXria.controls.xhtml.Default.Group = {
  overflow : "hidden",
  borderColor : "silver",
  borderStyle : "none",
  borderWidth : 0,
  backgroundColor : "#E2E4E7"
};

eXria.controls.xhtml.Default.TabHeader = {
	backgroundColor : "#747B82",
	fontFamily : "Arial, Helvetica, sans-serif",
	fontSize : 12,
	fontStyle : "normal",
	fontWeight : "normal",
	borderWidth : 0,
	borderStyle : "none",
	borderColor : "black",
	tabbuttons : {
	  cellSpacing : 1,
	  borderWidth : 1,
	  borderStyle : "solid",
	  borderColor : "#BFC2C6",
	  width : 100,
	  backgroundImage : "eXria/controls/xhtml/images/deepblue/tab01.jpg",
	  backgroundColor : "#39424D",
	  focusBackgroundColor : "#76A7C1",
	  focusColor : "#FFFFFF",
	  fontSize : 12
  }
}

eXria.controls.xhtml.Default.Tab = {
  headerHeight : 80,
	tabPageZindex : 0,
  headerPos : "top",
  borderWidth : 4,
  borderStyle : "solid",
  borderColor : "gray",
  backgroundColor : "#FFFFFF",
  tabpages : {
	  className : null,
	  outerClassName : null,
	  backgroundColor : "#39424D",
	  borderWidth : 1,
	  borderStyle : "solid",
	  borderColor : "#BFC2C6"
  }
};

eXria.controls.xhtml.Default.Timer = {
  interval : 1000,
  stopCount : 0
};

eXria.controls.xhtml.Default.Progress = {
  step : 1,
  startPos : 0,
  interval : 100,
  min : 0,
  max : 1000,
  progressColor : "#FF9900",
  borderColor : "#736A5E",
  backgroundColor : "#39424D"
};

eXria.controls.xhtml.Default.TreeView = {
  expandAll : false,
  selectionMode : "single",  
  iconDir : "eXria/controls/xhtml/images/deepblue",
  iconWidth : 19,
  iconHeight : 16,
  overflow : "auto",
  backgroundColor : "#C9CDD3",
  borderColor : "#98BBD1",
  borderStyle : "solid",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 11,
  fontStyle : "normal",
  fontWeight : "normal",
  itemgroup : {
	  className : null,
	  backgroundColor : "#E2E4E7",
	  color : "#FFFFFF",
	  selectedBackgroundColor : "#39424D",
	  selectedColor : "#FFFFFF",
	  cursor : "pointer",
	  fontFamily : "Arial, Helvetica, sans-serif",
	  fontSize : 11,
	  fontStyle : "normal",
	  fontWeight : "normal",
	  textAlign : "left",
	  verticalAlign : "middle"
  },
  iconFiles : {
		blank : "blank.png", //0
		verticalLine : "vertical_line.png", //1                     
		closedLastnode : "closed_lastnode.png", //2  
		closedNode : "closed_node.png", //3 
		openedLastnode : "opened_lastnode.png", //4 
		openedNode : "opened_node.png", //5 
		lastnode : "lastnode.png", //6 
		node : "node.png", //7 
		closedFolder : "closed_default_folder.png", //8     
		openedFolder : "opened_default_folder.png", //9
		leafItem : "leaf_item.png", //10
		selectedLeafItem : "selectedleaf_item.png" //11
	}
};

eXria.controls.xhtml.Default.Calendar = {
  selectedColor : "#39424D",
  headerBackgroundColor : "#747B82",
  bodyBackgroundColor : "#C9CDD3",
  backgroundColor : "#C9CDD3",
  borderWidth : 0,
  borderStyle : "none",
  borderColor : "silver",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 12,
  fontWeight : "bold",
  fontStyle : "normal"
};

eXria.controls.xhtml.Default.FreeForm = {
/* TODO 추후예정 */

};

eXria.controls.xhtml.Default.Grid = {
/* TODO 추후예정 */
};

eXria.controls.xhtml.Default.GridHeader = {
/* TODO 추후예정 */
  backgroundColor : "#76A7C1",
  color : "#39424D",
  textAlign : null,
  textDecoration : null,
  fontSize : 10,
  fontStyle : "normal",
  fontWeight : "bold"
};

eXria.controls.xhtml.Default.GridBody = {
/* TODO 추후예정 */
  backgroundColor : "#FFFFFF",
  oddBackgroundColor : "#E2E4E7",
  selectedBackgroundColor : "#C9CDD3",
  color : "#000000",
  selectedColor : "#000000",
  borderColor : "#747B82",
  borderStyle : "solid",
  borderWidth : 2,
  selectedBorderColor : "#21262C",
  selectedBorderStyle : "solid",
  selectedBorderWidth : 2,
  focusCellBorderColor : "#FF9900",
  focusCellBorderStyle : "dashed",
  focusCellBorderWidth : 2,
  textAlign : null,
  textDecoration : null,
  fontSize : 10,
  fontStyle : "normal",
  fontWeight : "normal"
};

eXria.controls.xhtml.Default.HeadColumn = {
/* TODO 추후예정 */
  backgroundColor : "#C9CDD3",
  color : "#000000",
  textAlign : null,
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 12,
  fontStyle : "normal",
  fontWeight : "bold"
};

eXria.controls.xhtml.Default.BodyColumn = {
/* TODO 추후예정 */
  backgroundColor : "#E2E4E7",
  color : null,
  textAlign : null,
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 10,
  fontStyle : "normal",
  fontWeight : "normal"
};

eXria.controls.xhtml.Default.Shape = {
  position : "absolute",
  visible : true,
  movable : false,
  zIndex : 0,
  cursor : "auto",
  tooltip : null,
  isTooltipDisplay : true,
  penCap : "round",
  penStyle : "solid",
  penWeight :1,
  penColor : "#938B81",
  penOpacity : 100,
  joinType : "round",
  angle : 0
};

eXria.controls.xhtml.Default.Line = {
  startPosition : "top",
  penColor : "#736A5E"
};

eXria.controls.xhtml.Default.Rectangle = {
  fillStartColor : "#E4EEF3",
  fillEndColor : "white",
  fillType : "solid",
  fillAngle : 0,
  fillOpacity : 100
};

eXria.controls.xhtml.Default.Roundrect = {
  round : 20,
  fillStartColor : "#FAEBD7",
  fillEndColor : "white",
  fillType : "solid",
  fillAngle : 0,
  fillOpacity : 100
};

eXria.controls.xhtml.Default.Ellipse = {
  fillStartColor : "#D6E3B1",
  fillEndColor : "white",
  fillType : "solid",
  fillAngle : 0,
  fillOpacity : 100
};

eXria.controls.xhtml.Default.SlideTab = {
  expandDirection : "top",
  selectedIndex : 0,
  slideButtons : {
    className : null,
    outerClassName : null,
    height : 50,
    borderStyle : "outset",
    borderWidth : 1,
    borderColor : "#1475C5",
    //backgroundImage : "url(http://img.yahoo.co.kr/spirit/pyramid/2008/08/08/nw1a1_img1_1218157383.jpg)",    
    backgroundColor : "#39424D",
    focusBackgroundColor : "#76A7C1",
    color : "#FFFFFF",
    focusColor : "white",
    fontSize : 11
  },
  slidePages : {
    className : null,
    outerClassName : null,
    borderStyle : "none",
    borderWidth : 0,
    borderColor : "white",
    backgroundColor : "#E2E4E7"
  }
};

eXria.controls.xhtml.Default.FileSelector = {
  fontFamily : "Arial",
  fontSize : 10,
  fontWeight : "normal",
  fontStyle : "normal"
};