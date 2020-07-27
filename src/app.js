var express = require("express");
var app = express();
var routes = require("./routes/index");
const route = require("./routes/devices");
var bodyParser = require("body-parser");

var PORT = 5000;

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

//require("dotenv").config();

app.use(routes.devices);

app.listen(PORT, () => console.log("live on : " + PORT));
