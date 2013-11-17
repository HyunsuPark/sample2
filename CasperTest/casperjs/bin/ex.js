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
  // #weatherColl �����Ͱ� ���� �̹������� �����κ��̴�.
  //
  this.captureSelector(filename, "#weatherColl");
  this.echo("Saved screenshot of " + (this.getCurrentUrl()) + " to " + filename);
});
casper.run();