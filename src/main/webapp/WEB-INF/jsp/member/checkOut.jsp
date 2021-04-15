<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/checkOut_Style.css">
<div class="main-block">
    <form id="checkout" action="${pageContext.request.contextPath}/cart/checkOut" method="post">
        <div class="info">
            <input class="fname" type="text" value="Fill Out The Check Out Form to Complete The Purchase" readonly>
            <input type="text" name="province" pattern=".*\S+.*" placeholder="Province" required>
            <input id="date" type="text" name="orderDate" value="${date}" readonly>
            <input type="text" name="city" pattern=".*\S+.*" placeholder="City" required>
            <input id="total" type="text" name="totalPrice" value="${total}" readonly>
            <input type="text" name="street" pattern=".*\S+.*" placeholder="Street" required>
            <input id="email" type="text" name="email" value="Email : ${member.email}" readonly>
            <input type="text" name="postalCode" pattern=".*\d+.*" placeholder="Postal Code" required>
            <select readonly>
                <option>Cart Items</option>
                <c:forEach items="${items}" var="item">
                    <option>
                            ${item.value.musicAlbum.albumName} Price:(${item.value.musicAlbum.price} T)
                        Quantity:(${item.value.quantity})
                    </option>
                </c:forEach>
            </select>
            <input id="fullName" type="text" name="phoneNumber" pattern=".*\S+.*" placeholder="Phone Number" required>
        </div>
        <button id="checkOutButton" onclick="this.form.submit()" class="button">Submit</button>
    </form>
</div>