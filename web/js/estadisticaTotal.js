/* 
 Develope @Manuel
 */
var a = document.getElementById('cargaTotal').value;
var b = document.getElementById('producidoTotal').value;
new Morris.Bar({
  element: 'bar-example',
  data: [
    { y: 'Toneladas de Cargamento transportado', a: `${a.toString()}`},
    { y: 'Toneladas de Producción de mineros', b: `${b.toString()}`}
  ],
  xkey: 'y',
  ykeys: ['a', 'b'],
  labels: ['Total de carga Transportado', 'Total de Producción']
});
