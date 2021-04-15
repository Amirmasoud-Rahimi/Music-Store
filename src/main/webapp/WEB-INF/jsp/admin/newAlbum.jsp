<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/newAlbum_Style.css">
<div>
    <h3 id="albumHeader">Add Music Album</h3>
    <form id="albumForm" method="post" enctype="multipart/form-data">
        <div class="container">
            <label for="artistList"></label>
            <select id="artistList" name="artistId" required>
                <option id="selectArtist" value="">Select Artist</option>
                <c:forEach items="${artists}" var="artist">
                    <option id="artist" value="${artist.artistId}">
                            ${artist.firstName} ${artist.lastName} (${artist.nickName})
                    </option>
                </c:forEach>
            </select><br>
            <label>
                <input type="text" placeholder="Enter Album Name" pattern=".*\S+.*" name="albumName"
                       title="Invalid Input" required>
            </label><br>
            <label>
                <input type="text" placeholder="Enter Release Date (YYYY-MM-DD)" name="releaseDate"
                       title="Invalid Input" required
                       pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))">
            </label><br>
            <label>
                <input type="text" placeholder="Enter Price (Toman)" pattern=".*\S+.*" name="price"
                       title="Invalid Input"
                       required>
            </label><br>
            <label for="genreList"></label>
            <select id="genreList" name="genreId" required>
                <option id="selectGenre" value="">Select Album Genre</option>
                <c:forEach items="${genres}" var="genre">
                    <option id="genre" value="${genre.genreId}">${genre.name}</option>
                </c:forEach>
            </select><br>
            <label for="myFile">Upload Sample Song (Optional)</label>
            <input type="file" id="myFile" name="sampleSong" onchange="fileValidation()"><br>
            <button class="button album-button" type="submit">Register</button>
        </div>
    </form>
</div>
<script>
    checkFileExtension = () => {
        const fileName = document.getElementById('myFile').value;
        const ext = fileName.substring(fileName.lastIndexOf('.') + 1);
        if (ext !== 'mp3' && ext !== 'MP3') {
            alert("Upload Files Only with (*.mp3) or (*.MP3) Extension!");
            document.getElementById('myFile').value = "";
            return false;
        }
    };
    checkFileSize = () => {
        const file = document.getElementById('myFile');
        const fileSize = file.files.item(0).size;
        const size = Math.round((fileSize / 1024));
        if (size >= 10240) {
            document.getElementById('myFile').value = "";
            alert("Invalid File , Please Select a File Less Than 10240 KB (10 MB)!");
        } else if (size < 100) {
            document.getElementById('myFile').value = "";
            alert("Invalid File , Please Select a File Greater Than 100 KB!");
        } else {
            alert("File Accepted. Size= " + size + " KB");
        }
    };
    fileValidation = () => {
        checkFileExtension();
        checkFileSize();
    }
</script>