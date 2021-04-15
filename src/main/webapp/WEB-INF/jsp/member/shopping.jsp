<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/shopping_Style.css">
<h2 id="shoppingHeader">Shopping Cart</h2>
<div class="=content">
    <c:choose>
        <c:when test="${empty sessionScope.cart.cartItems}">
            <h2 id="empty">Your Shopping Cart Is Empty</h2>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>Album Name</th>
                    <th>Image</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total Price</th>
                    <th>Delete</th>
                </tr>
                <c:set var="totalPrice" value="0"> </c:set>
                <c:forEach items="${sessionScope.cart.cartItems}" var="item">
                    <tr>
                        <td>${item.value.musicAlbum.albumName}</td>
                        <c:choose>
                            <c:when test="${ not empty item.value.musicAlbum.images}">
                                <c:forEach items="${item.value.musicAlbum.images}" end="0" var="image">
                                    <td><img src="${image}" alt="itemImage"></td>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <td>-------</td>
                            </c:otherwise>
                        </c:choose>
                        <td>${item.value.musicAlbum.price}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/cart/update" method="get">
                                <input type="hidden" name="albumId" value="${item.value.musicAlbum.albumId}"/>
                                <label>
                                    <input type="text" pattern=".*\d+.*" onchange="this.form.submit()" size="2"
                                           name="quantity" value="${item.value.quantity}"/>
                                </label>
                            </form>
                        </td>
                        <td>
                                ${item.value.musicAlbum.price*item.value.quantity}
                            <c:set var="totalPrice"
                                   value="${totalPrice+(item.value.musicAlbum.price*item.value.quantity)}"> </c:set>
                        </td>
                        <td>
                            <button id="delete"
                                    onclick="location.href='${pageContext.request.contextPath}/cart/remove/${item.value.musicAlbum.albumId}'">
                                Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td id="tol">${totalPrice}</td>
                    <td>
                        <button id="checkout"
                                onclick="location.href='${pageContext.request.contextPath}/cart/checkOut/${totalPrice}'">
                            Check Out
                        </button>
                    </td>
                </tr>
            </table>
            <br>
        </c:otherwise>
    </c:choose>
</div>