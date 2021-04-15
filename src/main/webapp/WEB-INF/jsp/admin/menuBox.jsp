<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/menuBox_Style.css">
<div class="left-container container">
    <div class="menu-box block">
        <h2 class="titular">MENU BOX</h2>
        <ul class="menu-box-menu">
            <li>
                <a class="menu-box-tab" href="${pageContext.request.contextPath}/admin/addArtist">
                    <span class="icon fontawesome-envelope scnd-font-color"></span>New Artist
                </a>
            </li>
            <li>
                <a class="menu-box-tab" href="${pageContext.request.contextPath}/admin/addAlbum">
                    <span class="icon entypo-paper-plane scnd-font-color"></span>New Music Album
                </a>
            </li>
            <li>
                <a class="menu-box-tab" href="${pageContext.request.contextPath}/admin/bestSellers">
                    <span class="icon entypo-calendar scnd-font-color"></span>Best Selling Albums
                </a>
            </li>
            <li>
                <a class="menu-box-tab" href="${pageContext.request.contextPath}/admin/membersVoteTable"><span
                        class="icon entypo-cog scnd-font-color"></span>Best Albums Based On Votes
                </a>
            </li>
            <li>
                <a class="menu-box-tab" href="${pageContext.request.contextPath}/admin/addImage"><span
                        class="icon entypo-cog scnd-font-color"></span>Add Images to Album
                </a>
            </li>
        </ul>
    </div>
</div>