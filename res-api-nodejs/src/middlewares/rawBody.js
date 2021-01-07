var getRawBody = require("raw-body");
const rawBody = function (req, res, next) {
    if (req.headers["content-type"] === "application/octet-stream") {
        getRawBody(
            req,
            {
                length: req.headers["content-length"],
                encoding: req.charset,
            },
            function (err, string) {
                if (err) return next(err);

                req.body = string;
                next();
            }
        );
    } else {
        next();
    }
}
module.exports = rawBody