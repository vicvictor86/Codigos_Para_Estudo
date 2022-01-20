const Atendimento = require('../models/atendimentos');

module.exports = app => {
    app.get("/atendimentos", async (req, res) => await Atendimento.lista(res));
    app.get("/atendimentos/:id", async (req, res) => {
        const id = Number(req.params.id);
        await Atendimento.buscaPorId(id, res);
    })

    app.post("/atendimentos", async (req, res) => {
        const atendimento = req.body;
        console.log(atendimento);
        
        const deuCerto = await Atendimento.adiciona(atendimento, res);

        if(deuCerto) {
            res.send("Outro teste")
        }
    })

    app.patch("/atendimentos/:id", async (req, res) => {
        const id = Number(req.params.id);
        const valores = req.body;

        Atendimento.altera(id, valores, res);
    })

    app.delete("/atendimentos/:id", async (req, res) => {
        const id = Number(req.params.id);
        Atendimento.deleta(id, res);
    })
}