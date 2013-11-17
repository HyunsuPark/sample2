var email   = require("../../emailjs-master/email").create();
var server  = email.server.connect({
   user:    "ekrnfkdi@gmail.com", 
   password:"qlalfqjsgh1", 
   host:    "smtp.gmail.com", 
   ssl:     true

});

// send the message and get a callback with an error or details of the message that was sent
server.send({
   text:    "i hope this works", 
   from:    "you <ekrnfkdi@gmail.com>", 
   to:      "ekrnfkdi@gmail.com",
   subject: "testing emailjs"
}, function(err, message) { console.log(err || message); });