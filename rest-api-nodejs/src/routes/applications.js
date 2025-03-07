var express = require("express");
var app = express();
var superagent = require("superagent");

var API = "http://192.168.56.1:8181/onos/v1/applications";

app
  .route("/applications")
  .get(async (req, res) => {
    try {
      await superagent
        .get(API)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) throw err;
          res.send(response.body.applications);
        });
    } catch (error) {}
  })
  .post(async (req, res) => {
    try {
      await superagent
        .post(API + "?activate=" + req.query.activate)
        .set("Content-Type", "application/octet-stream")
        .send(req.body)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) console.log(err.message);
          res.send(response.body);
        });
    } catch (error) {}
  });

app
  .route("/applications/:name")
  .get(async (req, res) => {
    try {
      await superagent
        .get(API + "/" + req.params.name)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) throw err;
          res.send(JSON.parse(response.text));
        });
    } catch (error) {
      console.log(error);
    }
  })
  .delete(async (req, res) => {
    try {
      await superagent
        .get(API + "/" + req.params.name)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) throw err;
          res.send(JSON.parse(response.text));
        });
    } catch (error) {
      console.log(error);
    }
  });
module.exports = app;
