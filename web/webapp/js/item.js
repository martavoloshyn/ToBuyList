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
                    var $li = $("<li>",{class:"list-group-item"}).prependTo("#items");
                    var $div = $("<div>",{style:"text-align:right;"}).prependTo($li);
                    var $button = $("<button>", {type:"button", class:"btn btn-primary", onclick:"deleteItem("+item.id.toString()+")"}).prependTo($div);
                    $("<i>", {class:"fas fa-trash-alt"}).prependTo($button);
                    var $input = $("<input>", {
                        type: "checkbox",
                        id: item.id.toString(),
                        onchange: "changeDone('http://localhost:9090/ToBuyList_war_exploded/changeItemDone?idItem="+item.id.toString()+"')",
                        checked: item.isDone,
                        style:"margin-right:5px;"
                    }).prependTo($div);


                    var $label = $("<label>", {text: item.text, for: item.id.toString()}).prependTo($li);
                });
            },
            error: function () {
                alert('error');
            }
        }
    )


}

function deleteItem(idItem) {
    $.ajax({

            url: 'http://localhost:9090/ToBuyList_war_exploded/deleteItem?idItem='+idItem,
            type: 'delete',
            cache: false,
            success: function () {
                document.getElementById("all").click();
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