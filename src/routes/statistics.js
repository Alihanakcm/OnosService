var express = require("express");
var app = express();
var superagent = require("superagent");

var API = "http://192.168.56.1:8181/onos/v1/statistics";

//!!! Fields in the comment line are not yet used !!!

app.route("/statistics/ports/:deviceId").get(async (req, res) => {
  try {
    await superagent
      .get(API + "/ports/" + req.params.deviceId)
      .auth((usr = "onos"), (pass = "rocks"))
      .end((err, response) => {
        if (err) throw err;
        res.status(200).send(response.body.statistics[0].ports);
      });
  } catch (error) {
    console.log(error);
  }
});

// app.route("/statistics/flows/activeentries").get(async (req, res) => {
//   try {
//     await superagent
//       .get(API + "/flows/activeentries")
//       .auth((usr = "onos"), (pass = "rocks"))
//       .end((err, response) => {
//         if (err) throw err;
//         res.status(200).send(JSON.parse(response.text));
//       });
//   } catch (error) {
//     res.status(error.status).send();
//   }
// });

app.route("/statistics/ports").get(async (req, res) => {
  try {
    await superagent
      .get(API + "/ports")
      .auth((usr = "onos"), (pass = "rocks"))
      .end((err, response) => {
        if (err) throw err;
        res.status(200).send(response.body.statistics);
      });
  } catch (error) {
    res.status(error.status).send();
  }
});
// app.route("/statistics/delta/ports").get(async (req, res) => {
//   try {
//     await superagent
//       .get(`${API}/delta/ports`)
//       .auth((usr = "onos"), (pass = "rocks"))
//       .end((err, response) => {
//         if (err) throw err;
//         res.status(200).send(JSON.parse(response.text));
//       });
//   } catch (error) {
//     res.status(error.status).send();
//   }
// });

// app.route("/statistics/delta/ports/:deviceId/:port").get(async (req, res) => {
//   try {
//     await superagent
//       .get(`${API}/delta/ports/${req.params.deviceId}/${req.params.port}`)
//       .auth((usr = "onos"), (pass = "rocks"))
//       .end((err, response) => {
//         if (err) throw err;
//         res.status(200).send(JSON.parse(response.text));
//       });
//   } catch (error) {
//     res.status(error.status).send();
//   }
// });

app.route("/statistics/delta/ports/:deviceId").get(async (req, res) => {
  try {
    await superagent
      .get(`${API}/delta/ports/${req.params.deviceId}`)
      .auth((usr = "onos"), (pass = "rocks"))
      .end((err, response) => {
        if (err) throw err;
        res.status(200).send(response.body.statistics[0].ports);
      });
  } catch (error) {
    res.status(error.status).send();
  }
});

// app.route("/statistics/ports/:deviceId/:port").get(async (req, res) => {
//   try {
//     await superagent
//       .get(`${API}/delta/ports/${req.params.deviceId}/${req.params.port}`)
//       .auth((usr = "onos"), (pass = "rocks"))
//       .end((err, response) => {
//         if (err) throw err;
//         res.status(200).send(JSON.parse(response.text));
//       });
//   } catch (error) {
//     res.status(error.status).send();
//   }
// });

app.route("/statistics/flows/tables/:deviceId?").get(async (req, res) => {
  try {
    switch (req.params.deviceId) {
      case undefined:
        await superagent
          .get(`${API}/flows/tables`)
          .auth((usr = "onos"), (pass = "rocks"))
          .end((err, response) => {
            if (err) throw err;
            res.status(200).send(response.body.statistics[0].table);
          });
        break;

      default:
        await superagent
          .get(`${API}/flows/tables/${req.params.deviceId}`)
          .auth((usr = "onos"), (pass = "rocks"))
          .end((err, response) => {
            if (err) throw err;
            res.status(200).send(response.body.statistics[0].table);
          });
        break;
    }
  } catch (error) {
    res.status(error.status).send();
  }
});

// app.route("/statistics/flows/link").get(async (req, res) => {
//   try {
//     if (req.query.device != undefined && req.query.port != undefined) {
//       await superagent
//         .get(
//           `${API}/flows/link?device=${req.query.device}&port=${req.query.port}`
//         )
//         .auth((usr = "onos"), (pass = "rocks"))
//         .end((err, response) => {
//           if (err) throw err;
//           res.status(200).send(JSON.parse(response.text));
//         });
//     } else if (req.query.device != undefined && req.query.port == undefined) {
//       await superagent
//         .get(`${API}/flows/link?device=${req.params.device}`)
//         .auth((usr = "onos"), (pass = "rocks"))
//         .end((err, response) => {
//           if (err) throw err;
//           res.status(200).send(JSON.parse(response.text));
//         });
//     } else if (req.query.device == undefined && req.query.port != undefined) {
//       await superagent
//         .get(`${API}/flows/link?port=${req.params.port}`)
//         .auth((usr = "onos"), (pass = "rocks"))
//         .end((err, response) => {
//           if (err) throw err;
//           res.status(200).send(JSON.parse(response.text));
//         });
//     } else {
//       await superagent
//         .get(`${API}/flows/link`)
//         .auth((usr = "onos"), (pass = "rocks"))
//         .end((err, response) => {
//           if (err) throw err;
//           res.status(200).send(response.body.loads);
//         });
//     }
//   } catch (error) {
//     res.status(error.status).send();
//   }
// });
module.exports = app;
