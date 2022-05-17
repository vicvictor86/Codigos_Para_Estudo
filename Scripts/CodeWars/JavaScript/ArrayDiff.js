function arrayDiff(arrayOriginal, itemToRemove){
    const arrayFiltred = arrayOriginal.filter(element => {
        itemToRemove.forEach(item => {
            if(item === element){
                return false;
            }
        });
    });
    return arrayFiltred;
}