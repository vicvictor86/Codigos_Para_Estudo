const Sequelize = require('sequelize');
const instance = require('../../db/config');

const columns = {
    company : {
        type: Sequelize.STRING,
        allowNull: false
    },
    email: {
        type: Sequelize.STRING,
        allowNull: false
    },
    category: {
        type: Sequelize.ENUM("food", "toys"),
        allowNull: false
    },
}

const options = {
    freezeTableName: true,
    tableName: "providers",
    timestamps: true,
    version: "version"
}

module.exports = instance.define("provider", columns, options);