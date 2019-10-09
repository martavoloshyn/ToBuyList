function setActive(id, id1, id2) {
    document.getElementById(id).className = "btn btn-primary active";
    document.getElementById(id1).className = "btn btn-primary";
    document.getElementById(id2).className = "btn btn-primary";
}

function sendRequest(criterion, idList) {
    $.ajax({
        url: "http://localhost:9090/ToBuyList_war_exploded/filterItems?criterion=" + criterion + "&idList=" + idList,
        type: 'get',
        cache: false,
        success: function (filteredItems) {
            document.getElementById("items").innerHTML = "";
            $.each(filteredItems, function (index, item) {
                var $li = $("<li>", {class: "list-group-item"}).prependTo("#items");
                var $p1 = $("<span>", {
                    class: "form-text text-muted",
                    text: "created: " + parseDate(item.createDate),
                    style: "font-size: 10px;"
                }).prependTo($li);
                var $p2 = $("<span>", {
                    class: "form-text text-muted",
                    text: "updated: " + parseDate(item.updateDate),
                    style: "font-size: 10px;"
                }).prependTo($li);
                var $div = $("<div>", {style: "text-align:right;"}).prependTo($li);
                var $buttonDelete = $("<button>", {
                    type: "button",
                    class: "btn btn-primary",
                    onclick: "deleteItem(" + item.id.toString() + ")"
                }).prependTo($div);
                var $buttonEdit = $("<button>", {
                    type: "button",
                    class: "btn btn-primary",
                    onclick: "prepareEditForm(" + item.id + "," + item.idList + ")",
                    style: "margin-right:5px;"
                }).prependTo($div);
                $("<i>", {class: "fas fa-trash-alt"}).prependTo($buttonDelete);
                $("<i>", {class: "fas fa-pencil-alt"}).prependTo($buttonEdit);
                var $input = $("<input>", {
                    type: "checkbox",
                    id: item.id.toString(),
                    onchange: "changeDone(" + item.id + ")",
                    checked: item.isDone,
                    style: "margin-right:5px;"
                }).prependTo($div);
                var $label = $("<label>", {text: item.text, for: item.id.toString()}).prependTo($li);
            });
        },
        error: function () {
            alert('error');
        }
    })
}

function parseDate(jsonDate) {
    return jsonDate.day + "." + jsonDate.month + "." +jsonDate.year;
}

function prepareEditForm(idItem, idList) {
    document.getElementById("editItemForm").hidden = false;
    document.getElementById("editItemForm").action = "editItem?idItem=" + idItem + "&idList=" + idList;
}

function deleteItem(idItem) {
    $.ajax({
        url: 'http://localhost:9090/ToBuyList_war_exploded/deleteItem?idItem=' + idItem,
        type: 'delete',
        cache: false,
        success: function () {
            document.getElementById("all").click();
        },
        error: function () {
            alert('error');
        }
    })
}

function changeDone(idItem) {
    $.ajax({
            url: "http://localhost:9090/ToBuyList_war_exploded/changeItemDone?idItem=" + idItem,
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