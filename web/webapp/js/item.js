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
                    $("<thead>").appendTo("#items")
                        .append($("<tr>"))
                        .append($("<th>").text(item.text));
                });
            },
            error: function () {
                alert('error');
            }
        }
    )


}

