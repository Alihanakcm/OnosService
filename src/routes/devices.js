var express = require("express");
var app = express();
var superagent = require("superagent");
// require("dotenv").config();

var API = "http://192.168.56.1:8181/onos/v1/devices";

app
  .route("/devices")
  .get(async (req, res) => {
    try {
      await superagent
        .get(API)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) throw err;
          res.status(200).send(JSON.parse(response.text));
        });
    } catch (error) {
      res.status(error.status).send();
    }
  })
  .post(async (req, res) => {
    try {
      await superagent
        .post(`${API}/${req.query.id}/portstate/${req.query.portId}`)
        .send(req.body)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) throw err;
          res.status(200).send("port durumu değişti");
        });
    } catch (error) {
      res.status(error.status).send();
    }
  });

app.get("/devices/:id/ports", async (req, res) => {
  try {
    await superagent
      .get(`${API}/${req.params.id}/ports`)
      .auth((usr = "onos"), (pass = "rocks"))
      .end((err, response) => {
        if (err) throw err;
        res.status(200).send(JSON.parse(response.text));
      });
  } catch (error) {
    res.status(error.status).send();
  }
});

app
  .route("/devices/:val")
  .get(async (req, res) => {
    try {
      await superagent
        .get(API + "/" + req.params.val)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) throw err;
          res.status(200).send(JSON.parse(response.text));
        });
    } catch (error) {
      res.status(error.status).send();
    }
  })
  .delete(async (req, res) => {
    try {
      await superagent
        .delete(API + "/" + req.params.val)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) throw err;
          res.status(200).send(JSON.parse(response.text));
        });
    } catch (error) {
      res.status(error.status).send();
    }
  });

module.exports = app;
