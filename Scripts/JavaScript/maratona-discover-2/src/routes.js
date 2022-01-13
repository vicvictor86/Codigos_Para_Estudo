const express = require('express')
const routes = express.Router()

const basePath = __dirname + "/views/"

const Profile = {
    data: {
        name: "Victor",
        avatar: "https://avatars.githubusercontent.com/u/45568289?v=4",
        "monthly-budget": 3000,
        "days-per-week": 5,
        "hours-per-day": 5,
        "vacation-per-year": 4,
        "value-hour": 75
    },

    controllers: {
        index(req, res) {
            return res.render(basePath + 'profile', { profile: Profile.data });
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
            data["value-hour"] = data["monthly-budget"] / monthlyTotalHours;

            Profile.data = data;

            return res.redirect('/profile');
        }
    }
}


const Job = {
    data: [
        {
            id: 1,
            name: "Pizzaria Guloso",
            "daily-hours": 2,
            "total-hours": 1,
            created_at: Date.now(),
        },
        {
            id: 2,
            name: "OneTwo Project",
            "daily-hours": 3,
            "total-hours": 47,
            created_at: Date.now(),
        }
    ],
    
    controllers: {
        index(req, res){
            const updatedJobs = Job.data.map(job =>{
                const remaining = Job.services.remainingDays(job);
                const status = remaining <= 0 ? 'done' : 'progress';
        
                return {
                    ...job,
                    remaining,
                    status,
                    budget: Job.services.calculateBudget(job, Profile.data["value-hour"])
                }
            })
         
            return res.render(basePath + 'index', {jobs : updatedJobs})
        },

        create(req, res){
            return res.render(basePath + 'job');
        },

        save(req, res){
            const lastId = Job.data[Job.data.length - 1]?.id || 0;

            Job.data.push({
                id: lastId + 1,
                name: req.body.name,
                "daily-hours": req.body["daily-hours"],
                "total-hours": req.body["total-hours"],
                created_at: Date.now()
            });
            return res.redirect('/');
        },

        show(req, res){

            const jobId = req.params.id;

            const job = Job.data.find(job => Number(job.id) === Number(jobId));

            if (!job){
                return res.send("Job not Found!");
            }

            job.budget = Job.services.calculateBudget(job, Profile.data["value-hour"]);

            return res.render(basePath + 'job-edit', { job });
        },

        update(req, res){
            const jobId = req.params.id;

            const job = Job.data.find(job => Number(job.id) === Number(jobId));

            if (!job){
                return res.send("Job not Found!");
            }

            const updatedJob = {
                ...job,
                name: req.body.name,
                "total-hours": req.body["total-hours"],
                "daily-hours": req.body["daily-hours"],
            }

            Job.data = Job.data.map(job => {
                if(Number(job.id) === Number(jobId)){
                    job = updatedJob;
                }

                return job;
            });

            res.redirect('/job/' + jobId);
        },
        
        delete(req, res){
            const jobId = req.params.id;

            Job.data =  Job.data.filter(job => Number(job.id) !== Number(jobId));

            return res.redirect('/');
        }
    },

    services: {
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
}

routes.get('/', Job.controllers.index);
routes.get('/job', Job.controllers.create);
routes.post('/job', Job.controllers.save);
routes.get('/job/:id', Job.controllers.show);
routes.post('/job/:id', Job.controllers.update);
routes.post('/job/delete/:id', Job.controllers.delete);
routes.get('/profile', Profile.controllers.index);
routes.post('/profile', Profile.controllers.update);

module.exports = routes