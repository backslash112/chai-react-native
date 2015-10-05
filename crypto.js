var crypto = require('crypto');
var request = require("request");

var fileName = "./secret-config.json"
var config

try {
  config = require(fileName)
}
catch (err) {
  config = {}
  console.log("unable to read file '" + fileName + "': ", err)
  console.log("see secret-config-sample.json for an example")
}

function signString(string_to_sign, shared_secret) {
	var hmac = crypto.createHmac('sha512', shared_secret);
	hmac.write(string_to_sign);
	hmac.end()
		return hmac.read();
}

var payload = {
	'username': 'joe_smith',
	'password': 'people',
	'email': 'transport@gmail.com',
	'timestamp': Math.round(new Date().getTime()/1000)
};

var json_payload = JSON.stringify(payload);
var signature = signString(json_payload, config.SHARED_SECRET);

var encoded_json = new Buffer(json_payload).toString('base64');
var encoded_signature = new Buffer(signature).toString('base64');
// console.log("/?data="+encoded_json+"&signature="+encoded_signature);

request({
uri: "http://localhost:8000/api/user_create/",
method: "POST",
form: {
data: encoded_json,
signature : encoded_signature
  }
}, function(error, response, body) {
  console.log(body);
});

