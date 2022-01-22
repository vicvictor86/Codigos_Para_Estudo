const router = require('express').Router();
const ProviderTable = require('./ProviderTable');
const Provider = require("./Provider");
const ProviderSerializer = require("../../Serializer").ProviderSerializer;

router.get("/", async (req, res) => {
    const results = await ProviderTable.list();
    res.status(200);
    const serializer = new ProviderSerializer(res.getHeader('Content-Type'));
    res.send(
        serializer.serialize(results)
    );
})

router.post("/", async (req, res, next) => {
    const data = req.body;

    try{
        const provider = new Provider(data);
        await provider.create();
        res.status(201);
        const serializer = new ProviderSerializer(res.getHeader('Content-Type'));
        res.send(
            serializer.serialize(provider)
        )
    }catch(error){
        next(error);
    }
})

router.get("/:id", async (req, res, next) => {
    const id = req.params.id;
    const provider = new Provider({ id: id });

    try{
        await provider.load();
        res.status(200);
        const serializer = new ProviderSerializer(res.getHeader('Content-Type'));
        res.send(
            serializer.serialize(provider)
        )
    }catch(error){
        next(error);
    }
})

router.put("/:id", async (req, res, next) => {
    try{
        const id = req.params.id;
        const dataReceive = req.body;
        const data = Object.assign({}, dataReceive, { id: id });
    
        const provider = new Provider(data);
        await provider.update()
        res.status(204);
        res.end();
    }catch(error){
        next(error);
    }
})

router.delete("/:id", async (req, res, next) => {
    try{
        const id = req.params.id;
        const provider = new Provider( {id: id} );

        await provider.load();
        await provider.remove();
        res.status(204);
        res.end();
    }catch(error){
        next(error)
    }
})

module.exports = router;