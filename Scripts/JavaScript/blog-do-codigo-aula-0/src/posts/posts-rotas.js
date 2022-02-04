const postsControlador = require('./posts-controlador');
const { middleWaresAutenticacao } = require('../usuarios');

module.exports = app => {
  app
    .route('/post')
    .get(postsControlador.lista)
    .post(middleWaresAutenticacao.bearer, postsControlador.adiciona);
};
