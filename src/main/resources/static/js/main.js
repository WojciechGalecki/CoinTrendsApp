var chart = document.getElementById("myChart");


var c = new Chart(chart, {

    type: 'line',
    data: {
        labels: myLabels,
        datasets: [
            {
                fill: false,
                lineTension: 0.1,
                backgroundColor: "",
                data: myData,
                yAxisID: 'btc-y-axis'
            }
        ]
    },
    options: {
        scales: {
            yAxes: [{
                id: 'btc-y-axis',
                type: 'logarithmic'
            }
            ]
        }
    }
});


