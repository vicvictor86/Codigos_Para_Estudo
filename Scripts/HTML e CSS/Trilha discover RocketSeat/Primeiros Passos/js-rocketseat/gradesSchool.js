function getScore(grade){
    let scoreA = grade >= 90 && grade <= 100
    let scoreB = grade >= 80 && grade < 90
    let scoreC = grade >= 70 && grade < 80
    let scoreD = grade >= 60 && grade < 70
    let scoreF = grade < 60 && grade >= 0
    if(scoreA){
        grade = "A"
    }else if(scoreB){
        grade = "B"
    }else if(scoreC){
        grade = "C"
    }else if(scoreD){
        grade = "D"
    }else if(scoreF){
        grade = "F"
    }else{
        grade = "Nota inválida"
    }
    console.log(grade)
}

getScore(80)