var express = require("express");
var app = express();
var superagent = require("superagent");

var API = "http://192.168.56.1:8181/onos/v1/flows";

//!!! Fields in the comment line are not yet used !!!

// app.get("/flows/table/:tableId", async (req, res) => {
//   try {
//     await superagent
//       .get(`${API}/table/${req.params.tableId}`)
//       .auth((usr = "onos"), (pass = "rocks"))
//       .end((err, response) => {
//         if (err) throw err;
//         res.status(200).send(response.body);
//       });
//   } catch (error) {
//     res.status(error.status).send();
//   }
// });
app
  .route("/flows")
  .get(async (req, res) => {
    try {
      await superagent
        .get(API)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) throw err;
          res.status(200).send(response.body.flows);
        });
    } catch (error) {
      res.status(error.status).send();
    }
  })
  .post(async (req, res) => {
    console.log(req.body);
    try {
      await superagent
        .post(API + "?appId=" + req.query.appId)
        .send(req.body)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) throw err;
          res.status(200).send(response.body.flows);
        });
    } catch (error) {
      res.status(error.status).send();
    }
  })
  .delete(async (req, res) => {
    try {
      await superagent
        .delete(API)
        .send(req.body)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) throw err;
          res.status(200).send("Deleted");
        });
    } catch (error) {
      res.status(error.status).send();
    }
  });

// app
//   .route("/flows/application/:appId")
//   .get(async (req, res) => {
//     try {
//       await superagent
//         .get(API + "/application/" + req.params.appId)
//         .auth((usr = "onos"), (pass = "rocks"))
//         .end((err, response) => {
//           if (err) throw err;
//           res.status(200).send(JSON.parse(response.text));
//         });
//     } catch (error) {
//       res.status(error.status).send();
//     }
//   })
//   .delete(async (req, res) => {
//     try {
//       await superagent
//         .get(API + "/application/" + req.params.appId)
//         .auth((usr = "onos"), (pass = "rocks"))
//         .end((err, response) => {
//           if (err) throw err;
//           res.status(200).send(JSON.parse(response.text));
//         });
//     } catch (error) {
//       res.status(error.status).send();
//     }
//   });

// app.get("/flows/pending", async (req, res) => {
//   try {
//     await superagent
//       .get(API + "/pending")
//       .auth((usr = "onos"), (pass = "rocks"))
//       .end((err, response) => {
//         if (err) throw err;
//         res.status(200).send(JSON.parse(response.text));
//       });
//   } catch (error) {
//     res.status(error.status).send();
//   }
// });
app
  .route("/flows/:deviceId/:flowId")
  .get(async (req, res) => {
    try {
      await superagent
        .get(`${API}/${req.params.deviceId}/${req.params.flowId}`)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) throw err;
          res.status(200).send(response.body.flows[0]);
        });
    } catch (error) {
      res.status(error.status).send();
    }
  })
  .delete(async (req, res) => {
    try {
      await superagent
        .delete(`${API}/${req.params.deviceId}/${req.params.flowId}`)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) throw err;
          res.status(200).send(response.text);
        });
    } catch (error) {
      res.status(error.status).send();
    }
  });
app
  .route("/flows/:deviceId")
  .get(async (req, res) => {
    try {
      await superagent
        .get(API + "/" + req.params.deviceId)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err && err.status != 404) throw err;
          if (response.status != 200) res.send("[]");
          else res.status(200).send(response.body.flows);
        });
    } catch (error) {
      res.status(error.status).send();
    }
  })
  .post(async (req, res) => {
    try {
      await superagent
        .post(`${API}/${req.params.deviceId}?appId=${req.query.appId}`)
        .send(req.body)
        .auth((usr = "onos"), (pass = "rocks"))
        .end((err, response) => {
          if (err) throw err;
          res.status(200).send(response.text);
        });
    } catch (error) {
      res.status(error.status).send();
    }
  });
module.exports = app;
