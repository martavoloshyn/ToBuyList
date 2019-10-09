function setActive(id, id1, id2) {
    document.getElementById(id).className = "btn btn-primary active";
    document.getElementById(id1).className = "btn btn-primary";
    document.getElementById(id2).className = "btn btn-primary";
}

function sendRequest(criterion, idUser) {
    $.ajax({
        url: "http://localhost:9090/ToBuyList_war_exploded/filterLists?criterion=" + criterion,
        type: 'get',
        cache: false,
        success: function (filteredLists) {
            document.getElementById("lists").innerHTML = "";
            $.each(filteredLists, function (index, list) {
                generateList(list);
            });
        },
        error: function () {
            alert('error');
        }
    })
}

function generateList(list) {

    var $li = $("<li>", {class: "list-group-item"}).prependTo("#lists");

    var $span1 = $("<span>", {
        class: "form-text text-muted",
        text: "created: " + parseDate(list.createDate)
    }).prependTo($li);

    var $span2 = $("<span>", {
        class: "form-text text-muted",
        text: "updated: " + parseDate(list.updateDate)
    }).prependTo($li);

    var $div = $("<div>", {style: "text-align:right;"}).prependTo($li);

    var $buttonDelete = $("<button>", {
        type: "button",
        class: "btn btn-primary",
        onclick: "deleteList(" + list.id.toString() + ")"
    }).prependTo($div);

    $("<i>", {class: "fas fa-trash-alt"}).prependTo($buttonDelete);

    var $buttonEdit = $("<button>", {
        type: "button",
        class: "btn btn-primary btn-edit",
        onclick: "prepareEditForm(" + list.id + ")"
    }).prependTo($div);

    $("<i>", {class: "fas fa-pencil-alt"}).prependTo($buttonEdit);

    var $input = $("<input>", {
        type: "checkbox",
        class: "checkbox-item",
        id: list.id.toString(),
        onchange: "changeDone(" + list.id.toString() + ")",
        checked: list.isDone
    }).prependTo($div);

    var $a = $("<a>", {
        class: "list-name",
        href: "http://localhost:9090/ToBuyList_war_exploded/itemPage?idList=" + list.id.toString()
    }).text(list.name).prependTo($li);
}

function parseDate(jsonDate) {
    return jsonDate.day + "." + jsonDate.month + "." +jsonDate.year;
}

function prepareEditForm(idList) {
    document.getElementById("editListForm").hidden = false;
    document.getElementById("editListForm").action = "editList?idList=" + idList;
}

function deleteList(idList) {
    $.ajax({
        url: 'http://localhost:9090/ToBuyList_war_exploded/deleteList?idList=' + idList,
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

function changeDone(idList) {
    $.ajax({
        url: "http://localhost:9090/ToBuyList_war_exploded/changeListDone?idList=" + idList,
        type: 'post',
        error: function () {
            alert('error');
        }
    })
}

$(document).ready(function () {
    document.getElementById("all").click();
});
