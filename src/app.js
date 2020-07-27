var express = require("express");
var app = express();
var routes = require("./routes/index");
const route = require("./routes/devices");

require("dotenv").config();

app.use(routes.devices);

app.listen(5000, () => console.log("live on : 5000"));
