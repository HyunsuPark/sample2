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
	backgroundColor : "white",
	color : "black",
	visible :  true,
	disabled :  false,
	zIndex :  0,
	movable : false,
	cursor : "default",
	tooltip : null,
	isTooltipDisplay : true,
	dir : "ltr",
	tabIndex : 0, 
	borderColor : "#E7E7E7",
	borderStyle : "solid", 
	borderWidth :  1,
  focusBorderColor : "#CC0000",  
  focusBorderStyle : "dashed",
  focusBorderWidth : 1  
  //className: null,
  //outerClassName: null  
	//accessKey : null,
	//left: 0,
	//top: 0,
	//height: 100,
	//width: 100,
};

eXria.controls.xhtml.Default.UIControl.tooltip = {
	backgroundImage : "eXria/controls/xhtml/images/gray/arrow.png",   // arrowImage
  borderColor : "#666666",
	borderStyle : "dashed", 
	borderWidth : 1,
	color : "#000000",
	backgroundColor : "#FFFFFF",
	fontFamily : "Arial, Helvetica, sans-serif",
	fontSize : 9,
	fontStyle : "normal",
	fontWeight : "normal",
	filter : "alpha(opacity:70)",
	opacity : "0.70"
};

eXria.controls.xhtml.Default.InputBox = {
  value : null,
  maxLength : null,
  readOnly : false,
  backgroundColor : "FAFAF8",
  color : "#777777",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 9,
  fontWeight : "normal",
  fontStyle : "normal",
  textAlign : "left",
  verticalAlign : "middle",
  textDecoration : "none",
  textTransform : "none"
};

eXria.controls.xhtml.Default.Button = {
  value : "Button",
  backgroundImage : "eXria/controls/xhtml/images/gray/theme_01.gif",
  imageFocused : null,
  imagePushed : null,
  imageMouseover : null,
  fontFamily : "Arial",
  fontSize : 9,
  fontWeight : "normal",
  fontStyle : "normal",
  borderWidth : 1,  
  borderStyle : "solid",
  borderColor : "#999999",
  color : "#777777",
  backgroundColor : "#C0C0C0",
  cursor : "auto",
  backgroundRepeat : "no-repeat",
  backgroundPosition : "top center"
};

eXria.controls.xhtml.Default.SecretBox = {
  value : null,
  maxLength : null,
  backgroundColor : "#FAFAF8",
  color : "#777777",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 9,
  fontWeight : "normal",
  fontStyle : "normal",
  textAlign : "left",
  verticalAlign : "middle",
  textDecoration : "none"
};

eXria.controls.xhtml.Default.Label = {
  backgroundColor : "#E7E7E7",
  borderWidth: 1,
  overflow : "hidden",
  value : "Label",
  wordWrap : true,
  textDecoration : "none",
  color : "#777777",
  fontFamily : "Aria, Helvetica, san-serif",
  fontSize : 9,
  fontWeight : "normal",
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
  calendarImageUrl : "eXria/controls/xhtml/images/gray/calendar.png",
  readOnly : false,
  backgroundColor : "#FAFAF8",
  color : "#777777",
  fontSize : 9,
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
  backgroundColor : "#FFFFFF",
  color : "#777777",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 9,
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
  backgroundColor : "#FAFAF8",
  color : "#777777",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 9,
  fontWeight : "normal",
  fontStyle : "normal",
  textAlign : "left",
  textDecoration : "none"
};

eXria.controls.xhtml.Default.Image = {
  src : null,
  imageOpacity : 100,
  borderStyle : "ridge",
  backgroundColor : "#000000",
  color : "#FFFFFF"
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
  fontSize : 9,
  fontWeight : "normal",
  fontStyle : "normal",
  itemgroup : { 
      labelPos : "right", 
      height : 30,
      width : 100, 
      textAlign : "left", 
      verticalAlign : "middle", 
      fontFamily : "Arial",
      fontSize : 9,
      fontWeight : "normal",
      fontStyle : "normal",
      color : "#333333",
      backgroundColor : "#E7E7E7", 
      borderWidth : 0,
      borderStyle : "solid", 
      borderColor : "#C0C0C0"
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
  backgroundColor : "#FAFAF8",
  color : "#777777",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 9,
  fontWeight : "normal",
  fontStyle : "normal",
  btnWidth : 19,
  btnBackgroundColor : "#FFFFFF",
  btnColor : "#333333",
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
	  color : "#777777",
	  focusColor : "#414141",
	  overflow : "hidden",
	  overflowX : "hidden",
	  overflowY : "auto",
	  backgroundColor : "#FFFFFF",
	  focusBackgroundColor : "#F1F1EB",
	  borderWidth : 1,
	  borderStyle : "solid",
	  borderColor : "#D9D9D9",
	  cellSpacing : 4,
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
  backgroundColor : "#FAFAF8",
  color : "#777777",
  textAlign : "left",  
  fontFamily : "Arial",
  fontSize : 9,
  fontWeight : "normal",
  fontStyle : "normal",
  appearance : null,
  multiSelect : true,
  size : 5,
  heightBySize : true,
  focusColor : "#414141",
  focusBackgroundColor : "#F1F1EB",
  cellSpacing : 4,
  itemgroup : {
    className : null,
    selectorWidth : 20,
    overflow : "hidden",
    borderWidth : 1,
    borderStyle : "solid",
    borderColor : "D9D9D9",
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
  calendarImageUrl : "eXria/controls/xhtml/images/gray/calendar.png",
  calendarEnable : "true",
  textDecoration : "none",
  textTransform : "none",
  backgroundColor : "#FAFAF8",
  color : "#777777",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 9,
  fontWeight : "normal",
  fontStyle : "normal"
};

eXria.controls.xhtml.Default.Group = {
  overflow : "hidden",
  borderColor : "silver",
  borderStyle : "none",
  borderWidth : 0,
  backgroundColor : "#777777",
  color : "#FFFFFF"
};

eXria.controls.xhtml.Default.TabHeader = {
	backgroundColor : "white",
	fontFamily : "Arial, Helvetica, sans-serif",
	fontSize : 9,
	fontStyle : "normal",
	fontWeight : "normal",
	textDecoration : "none",
	borderWidth : 3,
	borderStyle : "double",
	borderColor : "#D5D5D5",
	tabbuttons : {
	  cellSpacing : 1,
	  borderWidth : 3,
	  borderStyle : "solid",
	  borderColor : "#D5D5D5",
	  width : 100,
	  //backgroundImage : "url(http://img.yahoo.co.kr/spirit/pyramid/2008/08/08/nw1a1_img1_1218157383.jpg)",
	  backgroundColor : "#DEDEDE",
	  focusBackgroundColor : "#FFFFFF",
	  focusColor : "#000000",
	  fontSize : 12
  }
}

eXria.controls.xhtml.Default.Tab = {
  headerHeight : 50,
	tabPageZindex : 0,
  headerPos : "top",
  borderWidth : 1,
  borderStyle : "solid",
  borderColor : "gray",
  backgroundColor : "#FFFFFF",
  tabpages : {
	  className : null,
	  outerClassName : null,
	  backgroundColor : "#FFFFFF",
	  borderWidth : 3,
	  borderStyle : "solid",
	  borderColor : "#D5D5D5"
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
  progressColor : "#666666",
  borderColor : "#736A5E",
  backgroundColor : "#EBEBEB",
  color : "#777777"
};

eXria.controls.xhtml.Default.TreeView = {
  expandAll : false,
  selectionMode : "single",  
  iconDir : "eXria/controls/xhtml/images/gray",
  iconWidth : 19,
  iconHeight : 16,
  overflow : "auto",
  backgroundColor : "#FAFAF8",
  borderColor : "#98BBD1",
  borderStyle : "solid",
  fontFamily : "Arial",
  fontSize : 12,
  fontStyle : "normal",
  fontWeight : "normal",
  itemgroup : {
	  className : null,
	  backgroundColor : "#FFFFFF",
	  color : "#777777",
	  selectedBackgroundColor : "#8C8C8C",
	  selectedColor : "#FFFFFF",
	  cursor : "pointer",
	  fontFamily : "Arial, Helvetica, sans-serif",
	  fontSize : 9,
	  fontStyle : "normal",
	  fontWeight : "normal",
	  textDecoration : "none",
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
  selectedColor : "#FF6600",
  headerBackgroundColor : "#E7E7E7",
  bodyBackgroundColor : "#FFFFFF",
  backgroundColor : "#FFFFFF",
  color : "#777777",
  borderWidth : 0,
  borderStyle : "none",
  borderColor : "silver",
  fontFamily : "Arial, Helvetica, sans-ser",
  fontSize : 9,
  fontWeight : "bold",
  fontStyle : "normal"
};

eXria.controls.xhtml.Default.FreeForm = {
  backgroundColor : "#777777"
};

eXria.controls.xhtml.Default.Grid = {
/* TODO 추후예정 */
};

eXria.controls.xhtml.Default.GridHeader = {
  backgroundColor : "#FAFAF8",
  color : "#777777",
  textAlign : null,
  textDecoration : null,
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 9,
  fontStyle : "normal",
  fontWeight : "normal",
  borderColor : "#C0C0C0",
  borderStyle : "solid",
  borderWidth : 1
};

eXria.controls.xhtml.Default.GridBody = {
/* TODO 추후예정 */
  backgroundColor : "#FFFFFF",
  oddBackgroundColor : "#FAFAF8",
  selectedBackgroundColor : "#E8E8E6",
  color : "#777777",
  selectedColor : "#777777",
  borderColor : "#C0C0C0",
  borderStyle : "solid",
  borderWidth : 1,
  selectedBorderColor : "#C0C0C0",
  selectedBorderStyle : "solid",
  selectedBorderWidth : 1,
  focusCellBorderColor : "#333333",
  focusCellBorderStyle : "dotted",
  focusCellBorderWidth : 1,
  textAlign : null,
  textDecoration : null,
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 9,
  fontStyle : "normal",
  fontWeight : "normal",
  selectedFontFamily : "Arial, Helvetica, sans-serif",
  selectedFontSize : 10,
  selectedFontStyle : "normal",
  selectedFontWeight : "bold"  
};

eXria.controls.xhtml.Default.HeadColumn = {
/* TODO 추후예정 */
  backgroundColor : null,
  color : null,
  textAlign : null,
  fontFamily : null,
  fontSize : null,
  fontStyle : null,
  fontWeight : null
};

eXria.controls.xhtml.Default.BodyColumn = {
/* TODO 추후예정 */
  backgroundColor : null,
  color : null,
  textAlign : null,
  fontFamily : null,
  fontSize : null,
  fontStyle : null,
  fontWeight : null
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
    backgroundColor : "#EBEBEB",
    focusBackgroundColor : "#FFFFFF",
    color : "#000000",
    focusColor : "#000000",
    fontFamily : "Arial, Helvetica, sans-serif",
    fontSize : 9,
    fontStyle : "normal",
    fontWeight : "normal",
    fontSize : 12,
    textDecoration : "none"
  },
  slidePages : {
    className : null,
    outerClassName : null,
    borderStyle : "none",
    borderWidth : 0,
    borderColor : "white",
    backgroundColor : "#FFFFFF"
  }
};