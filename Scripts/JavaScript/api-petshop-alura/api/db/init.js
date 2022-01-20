const tabelModel = require('../routes/providers/ProviderModel');

tabelModel
    .sync()
    .then(() => console.log("Tabela criada com sucesso"))
    .catch(console.log);