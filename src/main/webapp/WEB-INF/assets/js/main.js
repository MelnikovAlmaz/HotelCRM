
document.addEventListener('DOMContentLoaded', function(){
    var d = new Date();
    var day = d.getDate();
    var month = d.getMonth() + 1;
    var year = d.getFullYear();
    var begin_date = document.getElementById('begin-date');

    var end_date = document.getElementById('end-date');
    begin_date.value = year + "-" + month + "-" + day;

    end_date.value = begin_date.value;

    document.getElementById('begin-date').setAttribute("min", begin_date.value);
    document.getElementById('end-date').setAttribute("min", document.getElementById('begin-date').value);
});
$("#search").on("input", function searchHotels() {
    var name = document.getElementById('search').value;
    var dataList = $("#hotelNames");
    if(name != "") {
        $.ajax({
            url: '/search/hotel',
            data: {name: name},
            dataType: "json",
            success: function (data) {
                dataList.empty();
                $.each(data, function (i, val) {
                    dataList.append("<option>"+ val +"</option>");
                });
            }
        });
    }
    else {
        dataList.empty();
    }
});