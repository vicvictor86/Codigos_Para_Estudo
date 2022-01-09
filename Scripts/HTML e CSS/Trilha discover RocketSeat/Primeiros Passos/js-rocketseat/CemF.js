function unitRecognizer(unitLetter, string){
    string = string.replace(unitLetter, "");
    return Number(string);
}

function changeUnit(string){
    string = string.toLowerCase();
    if(string.includes("c")){
        let temper = unitRecognizer("c", string);
        let newTemper = temper * 9/5 + 32;
        return newTemper;
    }else if(string.includes("f")){
        let temper = unitRecognizer("f", string);
        let newTemper = (temper - 32) * 5/9;
        return newTemper;
    }else{
        console.log("Unidade inválida");
    }
}

console.log(changeUnit("32c"));