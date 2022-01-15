const express = require('express');
const server = express();
const routes = require('./routes');
const path = require('path');

const port = 3000;
server.set('view engine', 'ejs');

//Mudar a localização da pasta views
server.set('views', path.join(__dirname, 'views'))

//Set de configurações do servidor
server.use(express.static("public"));
server.use(express.urlencoded({extended: true}));
server.use(routes);

server.listen(port, () => console.log('Server rodando'));