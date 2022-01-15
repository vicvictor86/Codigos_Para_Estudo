const Profile = require('../model/Profile');

module.exports = {
    index(req, res) {
        return res.render('profile', { profile: Profile.get() });
    },
    
    update(req, res){
        const data = req.body

        //Quantas semanas tem em um ano
        const weekPerYear = 52;

        //Quantas semanas por mês tenho de trabalho, tirando minhas semanas de férias
        const weeksPerMonth = (weekPerYear - data["vacation-per-year"]) / 12;

        //Total de horas trabalhadas em uma semana
        const weekTotalHours = data["hours-per-day"] * data["days-per-week"];

        //Total de horas trabalhadas no mês
        const monthlyTotalHours = weekTotalHours * weeksPerMonth;

        //Quanto devo cobrar para no ano receber o meu objetivo nas horas totais que tenho no mês
        const valueHour = data["monthly-budget"] / monthlyTotalHours;

        Profile.update({
            ...Profile.get(),
            ...req.body,
            "value-hour": valueHour
        })

        return res.redirect('/profile');
    }
}