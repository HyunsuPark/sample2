var casper = require("casper").create({
  viewportSize: {
    width: 1024,
    height: 768
  }
});
var url = 'http://search.daum.net/search?w=tot&DA=YZRR&t__nil_searchbox=btn&sug=&q=%EB%82%A0%EC%94%A8+%EC%84%9C%EC%9A%B8';
var filename = '../../weather.jpg';
casper.start(url, function() {
  //
  // #weatherColl 셀렉터가 위의 이미지에서 빨간부분이다.
  //
  this.captureSelector(filename, "#weatherColl");
  this.echo("Saved screenshot of " + (this.getCurrentUrl()) + " to " + filename);
});
casper.run();