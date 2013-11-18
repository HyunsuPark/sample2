var casper = require("casper").create({
  viewportSize: {
    width: 1024,
    height: 768
  }
,
verbose: true,
logLevel: 'debug'
});
var url = casper.cli.raw.get('url');
var filename = '../../capture.jpg';
casper.start(url);

casper.thenEvaluate(function(id,pw) {
//	casper.log(id, 'debug');
	console.log('Opened', id);
    document.querySelector('#tid').setAttribute('value', id);
    document.querySelector('#tpwd').setAttribute('value', pw);
    document.querySelector('form[name="loginForm"]').submit();
//    this.click('input.btn_login');
}, casper.cli.raw.get('id'), casper.cli.raw.get('pw'));

//casper.start(url,function() {
//	casper.evaluate(function() {
////		document.querySelector('input[name="id"]').value = casper.cli.raw.get('id');
////		document.querySelector('input[name="pw"]').value = casper.cli.raw.get('pw');
//		this.click('#svc.mail');
//	});
//	casper.options.waitTimeout = 3000; 
//  this.captureSelector(filename, "#container");
//   
//  this.echo("Saved screenshot of " + (this.getCurrentUrl()) + " to " + filename);
//});
//casper.run();

casper.then(function() {
    // Click on 1st result link
	setTimeout( function() {this.captureSelector(filename, "body");}, 3000);
});

casper.then(function() {
    console.log('clicked ok, new location is ' + this.getCurrentUrl());
});

casper.run();

