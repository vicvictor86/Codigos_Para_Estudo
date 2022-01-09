function getFlag(flag){
    const listArg = process.argv;
    if(listArg.includes(flag)){
        return listArg[listArg.indexOf(flag) + 1];
    }
}

module.exports = getFlag
