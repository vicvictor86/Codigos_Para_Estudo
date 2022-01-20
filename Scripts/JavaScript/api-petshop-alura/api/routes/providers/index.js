const router = require('express').Router();

router.use("/", (req, res) => {
    res.send("ok amigos");
})

module.exports = router;