$(document).ready(function() {
    var date = new Date();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    if (month < 10) month = "0" + month;

    var today = year + "-" + month;
    $("#monthAnalytic").attr("value", today);
    $("#yearAnalytic").attr("value", year);
    
    renderYearChart();
    renderMonthChart();
});
