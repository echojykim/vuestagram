//client/src/setupProxy.js
const proxy = require('http-proxy-middleware');
module.exports = function(app){
  app.use(
    '/api',
    proxy({
      target: 'http://localhost:7777', //api 요청을 보낼 서버 주소
      changeOrigin: true,
    })
  );
};