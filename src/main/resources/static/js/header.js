const createHeader = () => {
    let nav = document.querySelector('.navbar');

    nav.innerHTML = `
    <div class="container">
        <a class="navbar-brand" href="#"><img src="/images/img/logo.png" alt="Ката" width="30" height="24"
                                              class="d-inline-block align-text-top" />
            KATA</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Поиск" aria-label="Search" />
            <button class="btn" type="submit">
                <i class="fa-solid fa-music"></i>
            </button>
        </form>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link disabled" href="#"><i class="fa-regular fa-lg fa-bell"></i></a>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" data-bs-toggle="modal" data-bs-target="#userModal">
                        <i class="fa-solid fa-lg fa-grip"></i></a>
                    <div class="modal fade" id="userModal" tabindex="-1" aria-labelledby="userModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="userModalLabel">
                                        Наши сервисы
                                    </h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="container-fluid">
                                        <div class="row">

                                            <div class="row">
                                                <div class="col-md-3 ms-auto text-center title"><i class="fa-regular fa-file-lines fa-xl fa-beat"></i><p>Объявления</p></div>
                                                <div class="col-md-3 ms-auto text-center title"><i class="fa-solid fa-user-group fa-xl"></i><p>Знакомства</p></div>
                                                <div class="col-md-3 ms-auto text-center title"><i class="fa-solid fa-envelope-open-text fa-xl"></i><p>Почта</p></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 ms-auto text-center title"><i class="fa-solid fa-chalkboard-user fa-xl"></i><p>Учеба</p></div>
                                                <div class="col-md-3 ms-auto text-center title"><i class="fa-solid fa-champagne-glasses fa-xl fa-flip"></i><p>Отдых</p></div>
                                                <div class="col-md-3 ms-auto text-center title"><i class="fa-solid fa-person-digging fa-xl fa-bounce"></i><p>Работа</p></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 ms-auto text-center title"><i class="fa-regular fa-handshake fa-xl fa-flip"></i><p>Друзья</p></div>
                                                <div class="col-md-3 ms-auto text-center title"><i class="fa-solid fa-radio fa-xl fa-beat"></i><p>Новости</p></div>
                                                <div class="col-md-3 ms-auto text-center title"><i class="fa-solid fa-bullhorn fa-xl"></i><p>Анонсы</p></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary btn-sm btn-light" data-bs-dismiss="modal">
                                            Close
                                        </button>
                                        <button type="button" class="btn btn-primary btn-sm btn-info">
                                            ...Еще
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        <i class="fa-regular fa-xl fa-circle-user"></i>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li>
                            <a class="dropdown-item" href="#"><i class="fa-solid fa-gear" style="color: #8c9ef7"></i> Настройки</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#"><i class="fa-regular fa-circle-question" style="color: #8c9ef7"></i>
                                Помощь</a>
                        </li>
                        <li>
                            <hr class="dropdown-divider" />
                        </li>
                        <li>
                            <a class="dropdown-item" href="/logout"><i class="fa-solid fa-arrow-right-from-bracket"
                                                                 style="color: #8c9ef7"></i>
                                Выйти</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

    `;
}
createHeader();