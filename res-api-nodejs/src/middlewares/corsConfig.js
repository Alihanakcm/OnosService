const corsConfig = function (req, res, next) {
    console.log(req.method + " " + req.url);
    req.header("Access-Control-Allow-Origin", "*");
    req.header(
        "Access-Control-Allow-Headers",
        "Origin,X-Requested-With,Content-Type,Accept"
    );
    res.header("Access-Control-Allow-Origin", "*");
    res.header(
        "Access-Control-Allow-Headers",
        "Origin,X-Requested-With,Content-Type,Accept"
    );
    next();
}
module.exports = corsConfig