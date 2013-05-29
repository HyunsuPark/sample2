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
  backgroundColor : "#F5FAFA",
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
  borderColor : "#C1DAD7",
  borderStyle : "solid",
  borderWidth :  1,
  focusBorderColor : "#A8CCC8",
  focusBorderStyle : "dashed",
  focusBorderWidth : 3
  //className: null,
  //outerClassName: null
  //accessKey : null,
  //left: 0,
  //top: 0,
  //height: 100,
  //width: 100,
};

eXria.controls.xhtml.Default.UIControl.tooltip = {
  backgroundImage : "eXria/controls/xhtml/images/blue/arrow.png",   // arrowImage
  borderColor : "#87C8DA",
  borderStyle : "dashed",
  borderWidth : 1,
  color : "#384D52",
  backgroundColor : "#F5FAFA",
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
  backgroundColor : "#F5FAFA",
  color : "#4F6B72",
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
  backgroundImage : "eXria/controls/xhtml/images/blue/theme_02.gif",
  imageFocused : null,
  imagePushed : null,
  imageMouseover : null,
  fontFamily : "Aria, Helvetica, san-serif",
  fontSize : 9,
  fontWeight : "normal",
  fontStyle : "normal",
  borderWidth : 1,
  borderStyle : "solid",
  borderColor : "#999999",
  color : "#ffffff",
  backgroundColor : "#5BB0C8",
  cursor : "auto",
  backgroundRepeat : "no-repeat",
  backgroundPosition : "top center"
};

eXria.controls.xhtml.Default.SecretBox = {
  value : null,
  maxLength : null,
  backgroundColor : "#F5FAFA",
  color : "#4F6B72",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 9,
  fontWeight : "normal",
  fontStyle : "normal",
  textAlign : "left",
  verticalAlign : "middle",
  textDecoration : "none"
};

eXria.controls.xhtml.Default.Label = {
  backgroundColor : "#C8E6E8",
  borderWidth: 1,
  overflow : "hidden",
  value : "Label",
  wordWrap : true,
  textDecoration : "none",
  color : "#384D52",
  fontFamily : "Aria, Helvetica, san-serif",
  fontSize : 9,
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
  calendarImageUrl : "eXria/controls/xhtml/images/blue/calendar.png",
  readOnly : false,
  backgroundColor : "#F5FAFA",
  color : "#4F6B72",
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
  color : "#4F6B72",
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
  backgroundColor : "#F5FAFA",
  color : "#4F6B72",
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
  fontFamily : "Aria, Helvetica, san-serif",
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
      color : "#4F6B72",
      backgroundColor : "#F5FAFA",
      borderWidth : 0,
      borderStyle : "dashed",
      borderColor : "#C1DAD7"
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
  backgroundColor : "#F5FAFA",
  color : "#4F6B72",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 9,
  fontWeight : "normal",
  fontStyle : "normal",
  btnWidth : 19,
  btnBackgroundColor : "#FFFFFF",
  btnColor : "#005588",
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
    focusColor : "#4F6B72",
    overflow : "hidden",
    overflowX : "hidden",
    overflowY : "auto",
    backgroundColor : "#FFFFFF",
    focusBackgroundColor : "#F5FAFA",
    borderWidth : 3,
    borderStyle : "solid",
    borderColor : "#C1DAD7",
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
  backgroundColor : "#FFFFFF",
  color : "#4F6B72",
  textAlign : "left",
  fontFamily : "Aria, Helvetica, san-serif",
  fontSize : 9,
  fontWeight : "normal",
  fontStyle : "normal",
  appearance : null,
  multiSelect : true,
  size : 5,
  heightBySize : true,
  focusColor : "#4F6B72",
  focusBackgroundColor : "#E1F0F0",
  cellSpacing : 4,
  itemgroup : {
    className : null,
    selectorWidth : 20,
    overflow : "hidden",
    borderWidth : 1,
    borderStyle : "solid",
    borderColor : "#C1DAD7",
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
  calendarImageUrl : "eXria/controls/xhtml/images/blue/calendar.png",
  calendarEnable : "true",
  textDecoration : "none",
  textTransform : "none",
  backgroundColor : "#F5FAFA",
  color : "#4F6B72",
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
  backgroundColor : "#73A4A4",
  color : "#FFFFFF"
};

eXria.controls.xhtml.Default.TabHeader = {
  backgroundColor : "#F5FAFA",
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 9,
  fontStyle : "normal",
  fontWeight : "normal",
  textDecoration : "none",
  borderWidth : 3,
  borderStyle : "solid",
  borderColor : "#C9E7E9",
  tabbuttons : {
    cellSpacing : 1,
    borderWidth : 3,
    borderStyle : "solid",
    borderColor : "#C9E7E9",
    width : 100,
    //backgroundImage : "url(http://img.yahoo.co.kr/spirit/pyramid/2008/08/08/nw1a1_img1_1218157383.jpg)",
    backgroundColor : "#F5FAFA",
    focusBackgroundColor : "#BEDEDE",
    focusColor : "#000000",
    fontSize : 9
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
    borderColor : "#C9E7E9"
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
  progressColor : "#8CB8B9",
  borderColor : "#736A5E",
  backgroundColor : "#F5FAFA",
  color : "#4F6B72"
};

eXria.controls.xhtml.Default.TreeView = {
  expandAll : false,
  selectionMode : "single",
  iconDir : "eXria/controls/xhtml/images/blue",
  iconWidth : 19,
  iconHeight : 16,
  overflow : "auto",
  backgroundColor : "#F5FAFA",
  borderColor : "#98BBD1",
  borderStyle : "solid",
  fontFamily : "Arial",
  fontSize : 12,
  fontStyle : "normal",
  fontWeight : "normal",
  itemgroup : {
    className : null,
    backgroundColor : "#FFFFFF",
    color : "#4F6B72",
    selectedBackgroundColor : "#8CB8B9",
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
  selectedColor : "#CC3300",
  headerBackgroundColor : "#C7E6EB",
  bodyBackgroundColor : "#FFFFFF",
  backgroundColor : "#F5FAFA",
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
  backgroundColor : "#F5FAFA"
};

eXria.controls.xhtml.Default.Grid = {
/* TODO 추후예정 */
};

eXria.controls.xhtml.Default.GridHeader = {
  backgroundColor : "#73AEB3",
  color : "#233134",
  textAlign : null,
  textDecoration : null,
  fontFamily : "Arial, Helvetica, sans-serif",
  fontSize : 9,
  fontStyle : "normal",
  fontWeight : "normal",
  borderColor : "#C1DAD7",
  borderStyle : "solid",
  borderWidth : 1
};

eXria.controls.xhtml.Default.GridBody = {
/* TODO 추후예정 */
  backgroundColor : "#FFFFFF",
  oddBackgroundColor : "#F5FAFA",
  selectedBackgroundColor : "#CCCCCC",
  color : "#233134",
  selectedColor : "#233134",
  borderColor : "#C1DAD7",
  borderStyle : "solid",
  borderWidth : 1,
  selectedBorderColor : "#C0C0C0",
  selectedBorderStyle : "solid",
  selectedBorderWidth : 1,
  focusCellBorderColor : "#CCCCCC",
  focusCellBorderStyle : "dashed",
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
    backgroundColor : "#C8E6E8",
    focusBackgroundColor : "#FFFFFF",
    color : "#4E6B8A",
    focusColor : "#000000",
    fontFamily : "Arial, Helvetica, sans-serif",
    fontSize : 9,
    fontStyle : "normal",
    fontWeight : "normal",
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