const express = require('express');
const app = express();
const config = require('config');
const router = require("./routes");
const NotFound = require("./error/NotFound");
const InvalidField = require("./error/InvalidField");
const InsuficientData = require("./error/InsuficientData");
const UnsupportedValue = require("./error/UnsupportedValue");
const acceptFormats = require("./Serializer").acceptFormats;
const ErrorSerializer = require("./Serializer").ErrorSerializer;

app.use(express.json());
app.use(express.urlencoded({ extended: true}))

//Configuração para que possa aceitar o formato da requisição previamente
app.use((req, res, next) => {
    let reqFormat = req.header("Accept");
    
    if(reqFormat === "*/*"){
        reqFormat = "application/json";
    }

    if(acceptFormats.indexOf(reqFormat) === -1){
        res.status(406);
        res.end();
        return;
    }

    res.setHeader("Content-Type", reqFormat);
    next();
})

app.use("/api/providers", router);
//Middleware
app.use((error, req, res, next) => {
    let status = 500;
    
    if(error instanceof NotFound){
        status = 404;
    }

    if(error instanceof InvalidField || error instanceof InsuficientData){
        status = 400;
    }

    if(error instanceof UnsupportedValue){
        status = 406;
    }

    const serializer = new ErrorSerializer(res.getHeader('Content-Type'));
    
    res.status(status);
    res.send(
        serializer.serialize({message: error.message, id :error.idErro})
    );
})

app.listen(config.get('api.port'), () => console.log("Rodando servidor"));