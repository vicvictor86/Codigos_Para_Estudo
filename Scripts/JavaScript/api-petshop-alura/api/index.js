const express = require('express');
const app = express();
const config = require('config');
const router = require("./routes/providers");

app.use(express.json());
app.use(express.urlencoded({ extended: true}))

app.use("/api/providers", router);

app.listen(config.get('api.port'), () => console.log("Rodando servidor"));