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
            success: function (filteredItems) {
                document.getElementById("items").innerHTML = "";
                $.each(filteredItems, function (index, item) {
                    var $thead = $("<thead>").appendTo("#items");
                    var $tr = $("<tr>").appendTo($thead);
                    var $th = $("<th>").appendTo($tr);
                    var $input = $("<input>", {
                        type: "checkbox",
                        id: item.id.toString(),
                        onchange: "changeDone('http://localhost:9090/ToBuyList_war_exploded/changeDone?idItem="+item.id.toString()+"')",
                        checked: item.isDone
                    }).prependTo($th);
                    var $label = $("<label>", {text: item.text, for: item.id.toString()}).prependTo($th);
                });
            },
            error: function () {
                alert('error');
            }
        }
    )


}

function changeDone(link) {
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