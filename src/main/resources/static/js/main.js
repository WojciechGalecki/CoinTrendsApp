
var chart = document.getElementById("myChart");


/*var logChart = new Chart(chart, {
    type: 'line',
    data: {
        datasets: [{
            // This dataset appears on the first axis
            yAxisID: 'first-y-axis'
        }, {
            // This dataset appears on the second axis
            yAxisID: 'second-y-axis'
        }]
    },
    options: {
        scales: {
            yAxes: [{
                id: 'first-y-axis',
                type: 'linear'
            }, {
                id: 'second-y-axis',
                type: 'linear'
            }]
        }
    }
});*/

var c = new Chart(chart, {

    type: 'line',
    data: {
        labels: ["Jan", "Feb", "March", "April"],
        datasets: [
            {
                label: "My Label",
                fill: false,
                lineTension: 0.1,
                backgroundColor: "",
                data: [1,2,3,4,5],
            }
        ]
    }
});

