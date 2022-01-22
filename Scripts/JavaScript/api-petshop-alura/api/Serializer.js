const c = require('config');
const UnsupportedValue = require('./error/UnsupportedValue')

class Serializer {
    json(data){
        return JSON.stringify(data);
    }

    serialize(data){
        if (this.contentType === 'application/json'){
            return this.json(
                this.filterData(data)
            );
        }

        throw new UnsupportedValue(this.contentType);
    }

    filterObject(data){
        const newObject = {};

        this.publicField.forEach(field => {
            if (data.hasOwnProperty(field)){
                newObject[field] = data[field];
            }
        })

        return newObject;
    }

    filterData(data){
        if(Array.isArray(data)){
            data = data.map(item => {
                return this.filterObject(item);
            });
        }else{
            data = this.filterObject(data);
        }

        return data;
    }
};

class ProviderSerializer extends Serializer {
    constructor(contentType){
        super();
        this.contentType = contentType;
        this.publicField = ["id", "company", "category"];
    }
}

module.exports = {
    Serializer: Serializer,
    ProviderSerializer: ProviderSerializer,
    acceptFormats: ["application/json"]
};