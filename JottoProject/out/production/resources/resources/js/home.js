function logout(){
    $.cookie('username', null);
    document.location.href="./index.html";
}
function append_json(data){
    $(document).ready(function(){
        var table = document.getElementById("historyTable");
        console.log(table);
        data.forEach(function(object) {
            var tr = document.createElement('tr');
            tr.innerHTML =
                '<td  class="d0">' + object.date_created + '</td>'+
                '<td  class="d0">' + object.game_id + '</td>' +
                '<td  class="d0">' + object.game_state + '</td>' +
                '<td  class="d0">' + object.user_word + '</td>' +
                '<td  class="d0">' + object.cpu_word + '</td>'+
                '<td  class="d0">' + '<a style="color:#004b80" onclick="detailredirect()">Details</a>' + '</td>';
            table.appendChild(tr);
        });
    });

}
function getHistory(){
    var cusername = $.cookie('username');
    $.ajax({
        url: "history.html/show",
        type: "post",
        async: false,
        data: {username:$.cookie('username')},
        dataType:"text",
        success: function (data) {
            $.cookie('jsonString',data);
        }
    });
}
function getHistory(){
    var cusername = $.cookie('username');
    $.ajax({
        url: "history.html/show",
        type: "post",
        async: false,
        data: {username:$.cookie('username')},
        dataType:"text",
        success: function (data) {
            $.cookie('jsonString',data);
        }
    });
}