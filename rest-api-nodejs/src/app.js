var express = require("express");
var app = express();
var routes = require("./routes/index");
var bodyParser = require("body-parser");
var middleware = require('./middlewares/index')
var cors = require("cors");
var PORT = 5000;

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

//require("dotenv").config();

app.use(middleware.rawBody);

app.use(middleware.corsConfig);
app.use(cors());
app.use(routes.devices);
app.use(routes.applications);
app.use(routes.statistics);
app.use(routes.flows);

app.listen(PORT, () => console.log("live on : " + PORT));
