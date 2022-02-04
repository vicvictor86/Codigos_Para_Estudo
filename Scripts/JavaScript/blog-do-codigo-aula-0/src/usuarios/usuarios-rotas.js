const usuariosControlador = require('./usuarios-controlador');
const middleWaresAutenticacao = require('./middlewares-autenticacao');

module.exports = app => {
  app
    .route('/usuario/login')
    .post(middleWaresAutenticacao.local, usuariosControlador.login);
  
  app.route('/usuario/logout')
  .get(middleWaresAutenticacao.bearer, usuariosControlador.logout);

  app
    .route('/usuario')
    .post(usuariosControlador.adiciona)
    .get(usuariosControlador.lista);

  app.route('/usuario/:id').delete(middleWaresAutenticacao.bearer, usuariosControlador.deleta);
};
