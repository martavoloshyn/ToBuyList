function setActive(id, id1, id2) {
    document.getElementById(id).className = "btn btn-primary active";
    document.getElementById(id1).className = "btn btn-primary";
    document.getElementById(id2).className = "btn btn-primary";
}

function sendRequest(criterion, idUser) {
    $.ajax({
        url: "http://localhost:9090/ToBuyList_war_exploded/filterLists?criterion=" + criterion + "&idUser=" + idUser,
        type: 'get',
        cache: false,
        success: function (filteredLists) {
            document.getElementById("lists").innerHTML = "";
            $.each(filteredLists, function (index, list) {
                var $li = $("<li>", {class: "list-group-item"}).prependTo("#lists");
                var $div = $("<div>", {style: "text-align:right;"}).prependTo($li);
                var $buttonDelete = $("<button>", {
                    type: "button",
                    class: "btn btn-primary",
                    onclick: "deleteList(" + list.id.toString() + ")"
                }).prependTo($div);
                var $buttonEdit = $("<button>", {
                    type: "button",
                    class: "btn btn-primary",
                    onclick: "prepareEditForm(" + list.id + ")",
                    style: "margin-right:5px;"
                }).prependTo($div);
                $("<i>", {class: "fas fa-pencil-alt"}).prependTo($buttonEdit);
                $("<i>", {class: "fas fa-trash-alt"}).prependTo($buttonDelete);
                var $a = $("<a>", {
                    href: "http://localhost:9090/ToBuyList_war_exploded/itemPage?idList=" + list.id.toString(),
                    style: "text-decoration:none;color:black"
                }).text(list.name).prependTo($li);
                var $input = $("<input>", {
                    type: "checkbox",
                    id: list.id.toString(),
                    onchange: "changeDone(" + list.id.toString() + ")",
                    checked: list.isDone,
                    style: "margin-right: 5px;"
                }).prependTo($div);
            });
        },
        error: function () {
            alert('error');
        }
    })
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
