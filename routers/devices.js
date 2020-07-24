var express = require("express");
var app = express();
const superagent = require("superagent");

require("dotenv").config();
app.get("/devices", (req, res) => {
  try {
    res.send("grld");
    superagent
      .get("http://192.168.56.1:8181/onos/v1/devices")
      .auth((usr = "onos"), (pass = "rocks"))
      .end((err, res) => {
        if (err) throw err;
        console.log("hadi adadsd");
        console.log(JSON.parse(res.text));
      });
    console.log("geldisds");
  } catch (error) {
    res.send(error);
  }
});
var server = app.listen(5000);
