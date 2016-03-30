
  var express = require('express');
  var app = express();
  var fs = require("fs");
  console.log( __dirname );
  app.get('/listUsers', function (req, res) {
     fs.readFile( __dirname + "/" + "users.json", 'utf8', function (err, data) {
         console.log( data );
         res.end( data );
     });
  });

  var server = app.listen(8081, function () {

    var host = server.address().address
    var port = server.address().port

    console.log("Example app listening at http://%s:%s", host, port)

  });

/*var http = require("http")
http.createServer(function (request, response) {
   response.writeHead(200, {'Content-Type': 'text/plain'});
   response.end('Hello World\n');
}).listen(8081);
console.log('Server running at http://127.0.0.1:8081/');*/
