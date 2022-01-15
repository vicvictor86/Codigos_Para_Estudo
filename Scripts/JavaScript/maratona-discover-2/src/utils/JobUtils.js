module.exports = {
    remainingDays(job){

        //Quantos dias tenho para fazer o projeto
        const remainingDays = (job["total-hours"] / job["daily-hours"]).toFixed();
    
        //Quando eu aceitei o projeto
        const createdDate = new Date(job.created_at);
        //Qual é o dia máximo para entrega
        const dueDay = createdDate.getDate() + Number(remainingDays);
        const dueDateInMs = createdDate.setDate(dueDay);
    
        //Quanto tempo em milissegundos temos desde o dia de entrega até hoje
        const timeDiffInMs = dueDateInMs - Date.now();
        const dayInMs = 1000 * 60 * 60 * 24;
    
        //Quantos dias tem-se nesse intervalo de tempo de ms
        const dayDiff = Math.floor(timeDiffInMs / dayInMs);
        
        //Resta x dias para o prazo
        return dayDiff;
    },

    calculateBudget: (job, valueHour) => valueHour * job["total-hours"],
}