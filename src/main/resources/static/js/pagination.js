document.addEventListener('DOMContentLoaded', function () {
    const products = Array.from(document.querySelectorAll('.product_item'));
    const productsPerPage = 12;
    const paginationContainer = document.getElementById('pagination');
    const productContainer = document.getElementById('product-container');
    let currentPage = 1;

    function showPage(page) {
        productContainer.innerHTML = '';
        const start = (page - 1) * productsPerPage;
        const end = start + productsPerPage;
        const paginatedProducts = products.slice(start, end);

        paginatedProducts.forEach(product => productContainer.appendChild(product));
    }

    function setupPagination() {
        paginationContainer.innerHTML = '';
        const pageCount = Math.ceil(products.length / productsPerPage);

        if (pageCount <= 1) {
            paginationContainer.style.display = 'none';
            return;
        }

        // Previous button
        if (currentPage > 1) {
            const prevLi = document.createElement('li');
            prevLi.className = 'page-item';
            const prevA = document.createElement('a');
            prevA.className = 'page-link';
            prevA.href = '#';
            prevA.innerHTML = '<i class="ti-angle-left"></i>';
            prevA.addEventListener('click', (e) => {
                e.preventDefault();
                if (currentPage > 1) {
                    currentPage--;
                    showPage(currentPage);
                    updatePagination();
                }
            });
            prevLi.appendChild(prevA);
            paginationContainer.appendChild(prevLi);
        }

        // Page numbers
        const maxPagesToShow = 5;
        let startPage, endPage;

        if (pageCount <= maxPagesToShow) {
            startPage = 1;
            endPage = pageCount;
        } else {
            if (currentPage <= Math.ceil(maxPagesToShow / 2)) {
                startPage = 1;
                endPage = maxPagesToShow;
            } else if (currentPage + Math.floor(maxPagesToShow / 2) >= pageCount) {
                startPage = pageCount - maxPagesToShow + 1;
                endPage = pageCount;
            } else {
                startPage = currentPage - Math.floor(maxPagesToShow / 2);
                endPage = currentPage + Math.floor(maxPagesToShow / 2);
            }
        }

        for (let i = startPage; i <= endPage; i++) {
            addPageNumber(i);
        }

        // Next button
        if (currentPage < pageCount) {
            const nextLi = document.createElement('li');
            nextLi.className = 'page-item';
            const nextA = document.createElement('a');
            nextA.className = 'page-link';
            nextA.href = '#';
            nextA.innerHTML = '<i class="ti-angle-right"></i>';
            nextA.addEventListener('click', (e) => {
                e.preventDefault();
                if (currentPage < pageCount) {
                    currentPage++;
                    showPage(currentPage);
                    updatePagination();
                }
            });
            nextLi.appendChild(nextA);
            paginationContainer.appendChild(nextLi);
        }
    }

    function addPageNumber(i) {
        const li = document.createElement('li');
        li.className = 'page-item';
        if (i === currentPage) {
            li.classList.add('active');
        }
        const a = document.createElement('a');
        a.className = 'page-link';
        a.href = '#';
        a.textContent = i;
        a.addEventListener('click', (e) => {
            e.preventDefault();
            currentPage = i;
            showPage(currentPage);
            updatePagination();
        });
        li.appendChild(a);
        paginationContainer.appendChild(li);
    }

    function updatePagination() {
        setupPagination();
    }

    showPage(currentPage);
    setupPagination();
});
