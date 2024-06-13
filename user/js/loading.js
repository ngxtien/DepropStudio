const spinnerWrapperE1 = document.querySelector('.spinner-wrapper');

window.addEventListener('load', () => {
    spinnerWrapperE1.style.opacity = '0';

    setTimeout(() => {
        spinnerWrapperE1.style.display = 'none';
    }, 500);
})
