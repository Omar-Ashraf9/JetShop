<nav class="navbar navbar-expand-xl">
    <div class="container h-100">
        <a class="navbar-brand" href="front?controller=admin">
            <h1 class="tm-site-title mb-0">JetShop Admin</h1>
        </a>
        <button
                class="navbar-toggler ml-auto mr-0"
                type="button"
                data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fas fa-bars tm-nav-icon"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto h-100">
                <li class="nav-item">
                    <a class="nav-link ${param.active == 'home' ? 'active' : ''}" href="front?controller=admin">
                        <i class="fas fa-tachometer-alt"></i>
                        Dashboard
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${param.active == 'products' ? 'active' : ''}" href="front?controller=adminProduct">
                        <i class="fas fa-shopping-cart"></i>
                        Products
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link ${param.active == 'accounts' ? 'active' : ''}" href="front?controller=adminAccount">
                        <i class="far fa-user"></i>
                        Accounts
                    </a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link d-block" href="front?controller=adminLogin">
                        Admin, <b>Logout</b>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>