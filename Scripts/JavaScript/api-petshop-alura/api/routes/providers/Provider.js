const ProviderTable = require('./ProviderTable');
const InvalidField = require('../../error/InvalidField');
const InsuficientData = require('../../error/InsuficientData');


class Provider {
    constructor({ id, company, email, category, create_at, update_at, version }){
        this.id = id;
        this.company = company;
        this.email = email;
        this.category = category;
        this.create_at = create_at;
        this.update_at = update_at;
        this.version = version;
    }

    async create(){
        this.validate();
        const result = await ProviderTable.insert({
            company: this.company,
            email: this.email,
            category: this.category
        })

        this.id = result.id,
        this.create_at = result.create_at,
        this.update_at = result.update_at,
        this.version = result.version
    }

    async load(){
        const provider = await ProviderTable.getForId(this.id);

        this.company = provider.company;
        this.email = provider.email;
        this.category = provider.category;
        this.create_at = provider.create_at;
        this.update_at = provider.update_at;
        this.version = provider.version;
    }

    async update(){
        await ProviderTable.getForId(this.id);

        const fields = ["company", "email", "category"];
        const updateData = {};

        fields.forEach((field) => {
            const value = this[field];
            if(typeof value === "string" && value.length > 0){
                updateData[field] = value;
            }
        })

        if(Object.keys(updateData).length === 0){
            throw new InsuficientData();
        }

        await ProviderTable.update(this.id, updateData);
    }

    async remove(){
        return ProviderTable.remove(this.id);
    }

    validate(){
        const fields = ["company", "email", "category"];

        fields.forEach(field => {
            const value = this[field];

            if(typeof value !== "string" || value.length === 0){
                throw new InvalidField(field)
            }
        })
    }
}

module.exports = Provider;