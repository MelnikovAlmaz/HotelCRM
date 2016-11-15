function renderMonthChart() {
    $.ajax({
        url: '/admin/accountancy/search/income_month',
        data: {"date": $("#monthAnalytic").val()},
        dataType: "json",
        success: function (data, textStatus) {
            var arr = [];
            for (var i = 0; i < 31; i++) {
                arr[i] = i + 1;
            }
            var monthData = {
                labels: arr,
                datasets: [
                    {
                        label: "Количество заказов в день",
                        fill: false,
                        lineTension: 0.1,
                        backgroundColor: "rgba(75,192,192,0.4)",
                        borderColor: "rgba(75,192,192,1)",
                        borderCapStyle: 'butt',
                        borderDash: [],
                        borderDashOffset: 0.0,
                        borderJoinStyle: 'miter',
                        pointBorderColor: "rgba(75,192,192,1)",
                        pointBackgroundColor: "#fff",
                        pointBorderWidth: 1,
                        pointHoverRadius: 5,
                        pointHoverBackgroundColor: "rgba(75,192,192,1)",
                        pointHoverBorderColor: "rgba(220,220,220,1)",
                        pointHoverBorderWidth: 2,
                        pointRadius: 1,
                        pointHitRadius: 10,
                        data: data
                    }
                ]
            };
            var monthChartElem = document.getElementById("monthChart");
            var monthChart = new Chart(monthChartElem, {
                type: 'line',
                data: monthData
            });
        }
    });
}
function renderYearChart() {
    $.ajax({
        url: '/admin/accountancy/search/income_year',
        data: {"date": $("#yearAnalytic").val()},
        dataType: "json",
        success: function (data, textStatus) {
            var yearData = {
                labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
                datasets: [
                    {
                        label: "Количество заказов в месяц",
                        backgroundColor: "rgba(255,99,132,0.2)",
                        borderColor: "rgba(255,99,132,1)",
                        borderWidth: 1,
                        hoverBackgroundColor: "rgba(255,99,132,0.4)",
                        hoverBorderColor: "rgba(255,99,132,1)",
                        data: data
                    }
                ]
            };
            var yearChartElem = document.getElementById("yearChart");
            var yearChart = new Chart(yearChartElem, {
                type: 'bar',
                data: yearData
            });
        }
    });
}