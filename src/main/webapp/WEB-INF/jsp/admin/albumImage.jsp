<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/albumImage_Style.css">
<div>
    <form id="imageForm" method="post" enctype="multipart/form-data">
        <label for="albumList"></label>
        <select id="albumList" name="albumId" required>
            <option id="selectMusicAlbum" value="">Select Music Album</option>
            <c:forEach items="${albums}" var="album">
                <option value="${album.albumId}">
                        ${album.albumName} (${album.artist.nickName})
                </option>
            </c:forEach>
        </select>
        <label for="myImage">Upload Album Image: </label>
        <input id="myImage" type="file" name="albumImage" onchange="fileValidation()" required>
        <input type="submit" value="submit">
    </form>
</div>
<script>
    checkFileExtension = () => {
        const fileName = document.getElementById('myImage').value;
        const ext = fileName.substring(fileName.lastIndexOf('.') + 1);
        if (ext !== 'jpg' && ext !== 'JPG') {
            alert("Upload Files Only with (*.jpg) or (*.JPG) Extension!");
            document.getElementById('myImage').value = "";
            return false;
        }
    };
    checkFileSize = () => {
        const file = document.getElementById('myImage');
        const fileSize = file.files.item(0).size;
        const size = Math.round((fileSize / 1024));
        if (size >= 5120) {
            document.getElementById('myFile').value = "";
            alert("Invalid File , Please Select a File Less Than 5120 KB (5 MB)!");
        } else if (size < 5) {
            document.getElementById('myImage').value = "";
            alert("Invalid File , Please Select a File Greater Than 5 KB!");
        } else {
            alert("File Accepted. Size= " + size + " KB");
        }
    };
    fileValidation = () => {
        checkFileExtension();
        checkFileSize();
    }
</script>