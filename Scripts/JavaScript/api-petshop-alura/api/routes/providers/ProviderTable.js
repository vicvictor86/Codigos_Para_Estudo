const Model = require('./ProviderModel');

module.exports ={
    async list(){
        return await Model.findAll();
    },

    async insert(provider){
        return await Model.create(provider);
    },

    async getForId(id){
        const result = await Model.findOne({
            where: {
                id : id
            }
        })

        if(!result){
            throw new Error("Fornecedor não encontrado");
        }

        return result;
    },

    async update(id, dataUpdate){
        return await Model.update(
            dataUpdate,
            {
                where: { id: id }
            }
        )
    },

    async remove(id){
        return await Model.destroy({
            where: { id: id }
        })
    }
}