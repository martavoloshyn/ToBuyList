function setActive(id, id1, id2) {
    document.getElementById(id).className = "btn btn-primary active";
    document.getElementById(id1).className = "btn btn-primary";
    document.getElementById(id2).className = "btn btn-primary";
}
function sendRequest(link) {
    $.ajax({
            url: link,
            type: 'get',
            cache: false,
            success: function (filteredLists) {
                document.getElementById("lists").innerHTML = "";
                $.each(filteredLists, function (index, list) {
                    var $thead = $("<thead>").appendTo("#lists");
                    var $tr = $("<tr>").appendTo($thead);
                    var $th = $("<th>").appendTo($tr)
                    var $a = $("<a>",{href: "http://localhost:9090/ToBuyList_war_exploded/itemPage?idList="+list.id.toString()}).prependTo($th)
                        .append($("<button>").text(list.name));
                });
            },
            error: function () {
                alert('error');
            }
        }
    )


}

