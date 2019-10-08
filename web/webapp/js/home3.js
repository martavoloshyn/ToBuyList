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
                    var $th = $("<th>").appendTo($tr);
                    var $a = $("<a>",{href: "http://localhost:9090/ToBuyList_war_exploded/itemPage?idList="+list.id.toString(), style: "text-decoration:none;color:black"}).text(list.name).prependTo($th);
                    //alert(list);
                    var $input = $("<input>", {
                        type: "checkbox",
                        id: list.id.toString(),
                        onchange: "changeDone('http://localhost:9090/ToBuyList_war_exploded/changeListDone?idList="+list.id.toString()+"')",
                        checked: list.isDone
                    }).prependTo($th);
                    //var $label = $("<label>", {text: item.text, for: item.id.toString()}).prependTo($th);
                });
            },
            error: function () {
                alert('error');
            }
        }
    )
}

function changeDone(link){
    $.ajax({
            url: link,
            type: 'post',
            error: function () {
                alert('error');
            }
        }
    )
}

$(document).ready(function () {
    document.getElementById("all").click();
});
