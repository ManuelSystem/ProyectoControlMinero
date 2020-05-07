/* 
 by Manuel Silva
 */

var a = document.getElementById('nuConductores').value;
var b = document.getElementById('nuVehiculos').value;
var c = document.getElementById('nuAccidentes').value;
var d = document.getElementById('nuFallas').value;
var e = document.getElementById('nuPatios').value;
var f = document.getElementById('nuMineros').value;
new Morris.Donut({
    // ID of the element in which to draw the chart.
    
    element: 'chart',
    // Chart data records -- each entry in this array corresponds to a point on
    // the chart.
    data: [ 
        {label: 'Número de Conductores', value: `${a.toString()}`},
        {label: 'Número de Vehículos', value: `${b.toString()}`},
        {label: 'Número de Accidentes', value: `${c.toString()}`},
        {label: 'Número de Fallas mecanicas', value: `${d.toString()}`},
        {label: 'Número de Patios', value: `${e.toString()}`},
        {label: 'Número de Mineros', value: `${f.toString()}`}
    ],
    colors: [
        '#007bff',
        '#ffb900',
        '#C6C6C6',
        '#FA3C13',
        '#34495E',
        '#A9CCE3'
    ]
});
