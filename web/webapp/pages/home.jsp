<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 2019-10-03
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>ToBuyList</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/b9192cac7d.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webapp/js/home.js"></script>
    <link href="${pageContext.request.contextPath}/webapp/css/item-home.css" rel="stylesheet">

</head>
<body>

<jsp:include page="../components/header.jsp"/>

<div class="container">
    <div class="row justify-content-center align-self-center">
        <div class="col-md-6">

            <div class="filter filter-basic">
                <div class="filter-nav">
                    <button class="btn btn-primary active" id="all"
                            onclick="setActive(id,'true','false');sendRequest(id)">All
                    </button>
                    <button class="btn btn-primary" id="true"
                            onclick="setActive(id, 'all', 'false');sendRequest(id);">Done
                    </button>
                    <button class="btn btn-primary" id="false"
                            onclick="setActive(id, 'all','true');sendRequest(id);">Undone
                    </button>
                    <a href="http://localhost:9090/ToBuyList_war_exploded/logout">
                        <button class="btn btn-btn-dark"><i class="fas fa-door-open"></i></button>
                    </a>
                    <span>${username}</span>
                </div>
            </div>

            <form class="inputForm" action="addList" method="post">
                <div class="add-items d-flex"><input type="text" name="listName" class="form-control todo-list-input"
                                                     placeholder="What list do you need to create?" required>
                    <button type="submit" class="add btn btn-primary font-weight-bold todo-list-add-btn"
                            style="margin-left:5px;">Add
                    </button>
                </div>
            </form>

            <form class="inputForm" id="editListForm" method="post" hidden>
                <div class="add-items d-flex"><input type="text" name="newListName" class="form-control todo-list-input"
                                                     placeholder="What is your edited item?" required>
                    <button type="submit" class="add btn btn-primary font-weight-bold todo-list-add-btn"
                            style="margin-left:5px;">Edit
                    </button>
                </div>
            </form>

            <ul class="list-group" id="lists">

            </ul>

        </div>
    </div>
</div>
</body>
</html>
