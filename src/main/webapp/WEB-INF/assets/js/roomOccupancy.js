$(document).ready(function() {
    var today = Date.now();
    $("#beginDate").attr("value", today.);
    $("#end-date").attr("value", today);
    room_occupancy();
});
function room_occupancy() {
    $.ajax({
        url: '/admin/analytic/room/occupancy',
        data: 
        {
            "id": $("#roomId").val(),
            "beginDate": $("#beginDate").val(),
            "endDate": $("#endDate").val(),
        },
        dataType: "json",
        success: function (data, textStatus) {
            var occupancy = $("#occupancy");
            occupancy.empty();
            occupancy.append(data);
        }
    });
}
