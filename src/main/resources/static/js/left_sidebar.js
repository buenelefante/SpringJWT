const createSidebar = () => {
    let sideBar = document.querySelector('.sidebar');

    sideBar.innerHTML = `
    <ul class="list-group">
                <a href="index.html" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-regular fa-xl fa-circle-user"></i> Моя страница</a>
                <a href="mainPage.html" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-solid fa-square-rss"></i> Новости</a>
                <a href="messenger.html" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-regular fa-comment-dots"></i> Мессенджер</a>
                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-solid fa-user-group"></i> Друзья</a>
                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-solid fa-phone-volume"></i> Звонки</a>
                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-solid fa-users-between-lines"></i> Сообщества</a>
                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-regular fa-images"></i> Фотографии</a>
                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-solid fa-film"></i> Видео</a>
                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-solid fa-clapperboard"></i> Клипы</a>
                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-solid fa-gamepad"></i> Игры</a>
                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-regular fa-face-smile-wink"></i> Стикеры</a>
                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-regular fa-rectangle-list"></i> Объявления</a>
            </ul>
            <ul class="list-group list-group2">
                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-regular fa-clone"></i> Мини-приложения</a>
                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-solid fa-ruble-sign"></i> КАТА-Pay</a>
            </ul>
            <ul class="list-group list-group2">
                <a href="#" class="list-group-item list-group-item-action list-group-item-secondary"><i
                        class="fa-regular fa-file"></i> Файлы</a>

            </ul>
            <p>какая-то инфа...</p>
    `;
}
    createSidebar();
