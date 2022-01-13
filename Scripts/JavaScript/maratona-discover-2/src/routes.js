const express = require('express')
const routes = express.Router()

const basePath = __dirname + "/views/"

const profile = {
    name: "Victor",
    avatar: "https://avatars.githubusercontent.com/u/45568289?v=4",
    "monthly-budget": 3000,
    "days-per-week": 5,
    "hours-per-day": 5,
    "vacation-per-year": 4
}

routes.get('/', (req, res) => res.render(basePath + '/index'))
routes.get('/job', (req, res) => res.render(basePath + '/job'))
routes.get('/job-edit', (req, res) => res.render(basePath + '/job-edit'))
routes.get('/profile', (req, res) => res.render(basePath + '/profile', { profile }))

module.exports = routes