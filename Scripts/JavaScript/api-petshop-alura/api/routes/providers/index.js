const router = require('express').Router();
const ProviderTable = require('./ProviderTable');
const Provider = require("./Provider");

router.get("/", async (req, res) => {
    const results = await ProviderTable.list();
    res.status(200);
    res.send(
        JSON.stringify(results)
    );
})

router.post("/", async (req, res) => {
    const data = req.body;

    try{
        const provider = new Provider(data);
        await provider.create();
        res.status(201);
        res.send(
            JSON.stringify(provider)
        )
    }catch(e){
        res.status(400);
        res.send(
            JSON.stringify({message : e.message})
        )
    }

})

router.get("/:id", async (req, res) => {
    const id = req.params.id;
    const provider = new Provider({ id: id });

    try{
        await provider.load();
        res.status(200);
        res.send(
            JSON.stringify(provider)
        )
    }catch(e){
        res.status(404);
        res.send(
            JSON.stringify({
                mensagem: e.message
            })
        )
    }
})

router.put("/:id", async (req, res) => {
    try{
        const id = req.params.id;
        const dataReceive = req.body;
        const data = Object.assign({}, dataReceive, { id: id });
    
        const provider = new Provider(data);
        await provider.update()
        res.status(204);
        res.end();
    }catch(e){
        res.status(400);
        res.send(
            JSON.stringify({messagem: e.message})
        );
    }
})

router.delete("/:id", async (req, res) => {
    try{
        const id = req.params.id;
        const provider = new Provider( {id: id} );

        await provider.load();
        await provider.remove();
        res.status(204);
        res.end();
    }catch(e){
        res.status(404);
        res.send(
            JSON.stringify({message : e.message})
        )
    }
})

module.exports = router;