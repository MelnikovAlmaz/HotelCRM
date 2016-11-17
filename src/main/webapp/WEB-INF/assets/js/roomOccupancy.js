$(document).ready(function() {
    var date = new Date(Date.now());
    var month = date.getMonth() + 1;
    var day = date.getDay();
    var year = date.getFullYear();

    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;

    var today = year + "-" + month + "-" + day;
    $("#beginDate").attr("value", today);
    date.setDate(date.getDate() + 1);
    month = date.getMonth() + 1;
    day = date.getDay();
    year = date.getFullYear();

    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;
    var tomorow = year + "-" + month + "-" + day;
    $("#endDate").attr("value", tomorow);
    room_occupancy();
});
function room_occupancy() {
    $.ajax({
        url: '/admin/analytic/room/occupancy',
        data: 
        {
            "id": $("#roomId").val(),
            "beginDate": $("#beginDate").val(),
            "endDate": $("#endDate").val()
        },
        dataType: "json",
        success: function (data, textStatus) {
            var occupancy = $("#occupancy");
            occupancy.empty();
            occupancy.append(data + "%");
        }
    });
}
