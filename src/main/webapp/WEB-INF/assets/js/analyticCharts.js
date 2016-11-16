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
                        label: "Day income",
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
                        label: "Month income",
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
function renderMonthTable() {
    $.ajax({
        url: '/admin/accountancy/search/income_year_month',
        data: {"date": $("#yearAnalyticTable").val()},
        dataType: "json",
        success: function (data, textStatus) {
            var monthTable = $("#monthTable1");
            var monthTable2 = $("#monthTable2");
            var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
            var totalIncome = [];
            var totalIncome2 = [];
            for (i = 0; i < 6; i++){
                totalIncome[i] = 0.0;
                totalIncome2[i] = 0.0;
            }
            var tableContent = "";
            var tableContent2 = "";
            tableContent += '<thead>';
            tableContent2 += '<thead>';
            tableContent += '<th>Day</th>';
            tableContent2 += '<th>Day</th>';
            for (i = 0; i < months.length / 2; i++){
                tableContent += '<th>' + months[i] + '</th>';
                tableContent2 += '<th>' + months[i + 6] + '</th>';
            }
            tableContent += '</thead><tbody>';
            tableContent2 += '</thead><tbody>';
            for (var i = 0; i < data.length; i++) {
                tableContent += '<tr>';
                tableContent2 += '<tr>';
                tableContent += '<td>' + (i + 1) + '</td>';
                tableContent2 += '<td>' + (i + 1) + '</td>';
                for (var j = 0; j < data[i].length / 2; j++){
                    tableContent += '<td>' + data[i][j] + '</td>';
                    tableContent2 += '<td>' + data[i][j + 6] + '</td>';
                    totalIncome[j] += data[i][j];
                    totalIncome2[j] += data[i][j + 6];
                }
                tableContent += '</tr>';
                tableContent2 += '</tr>';
            }
            tableContent += '<tr class="info"><td>Total:</td>';
            tableContent2 += '<tr class="info"><td>Total:</td>';
            for (i = 0; i < totalIncome.length; i++){
                tableContent += '<td>' + totalIncome[i] + '</td>';
                tableContent2 += '<td>' + totalIncome2[i] + '</td>';
            }
            tableContent += '</tr>';
            tableContent2 += '</tr>';
            tableContent += '</tbody>';
            tableContent2 += '</tbody>';
            monthTable.empty();
            monthTable2.empty();
            monthTable.append(tableContent);
            monthTable2.append(tableContent2);
        }
    });
}