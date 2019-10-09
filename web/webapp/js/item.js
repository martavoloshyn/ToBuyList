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
                generateItem(item);
            });
        },
        error: function () {
            alert('error');
        }
    })
}

function generateItem(item) {

    var $li = $("<li>", {class: "list-group-item"}).prependTo("#items");

    var $span1 = $("<span>", {
        class: "form-text text-muted",
        text: "created: " + parseDate(item.createDate)
    }).prependTo($li);

    var $span2 = $("<span>", {
        class: "form-text text-muted",
        text: "updated: " + parseDate(item.updateDate)
    }).prependTo($li);

    var $div = $("<div>", {class: "list-buttons"}).prependTo($li);

    var $buttonDelete = $("<button>", {
        type: "button",
        class: "btn btn-primary",
        onclick: "deleteItem(" + item.id.toString() + ")"
    }).prependTo($div);

    $("<i>", {class: "fas fa-trash-alt"}).prependTo($buttonDelete);

    var $buttonEdit = $("<button>", {
        type: "button",
        class: "btn btn-primary btn-edit",
        onclick: "prepareEditForm(" + item.id + "," + item.idList + ")"
    }).prependTo($div);

    $("<i>", {class: "fas fa-pencil-alt"}).prependTo($buttonEdit);

    var $input = $("<input>", {
        type: "checkbox",
        class: "checkbox-item",
        id: item.id.toString(),
        onchange: "changeDone(" + item.id + ")",
        checked: item.isDone
    }).prependTo($div);

    var $label = $("<label>", {text: item.text, for: item.id.toString()}).prependTo($li);
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