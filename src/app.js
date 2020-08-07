var express = require("express");
var app = express();
var routes = require("./routes/index");
var bodyParser = require("body-parser");
var cors = require("cors");
var PORT = 5000;

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

//require("dotenv").config();

app.use(function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header(
    "Access-Control-Allow-Headers",
    "Origin,X-Requested-With,Content-Type,Accept"
  );
  next();
});

app.use(routes.devices);
app.use(routes.applications);
app.use(routes.statistics);
app.use(routes.flows);

app.listen(PORT, () => console.log("live on : " + PORT));
