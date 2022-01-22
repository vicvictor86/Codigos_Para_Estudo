const tabelModel = require('../model/ProviderModel');

tabelModel
    .sync()
    .then(() => console.log("Tabela criada com sucesso"))
    .catch(console.log);