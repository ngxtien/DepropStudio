document.querySelectorAll('.accordion-button').forEach(button => {
    button.addEventListener('click', function() {
        // Find the input radio button within the clicked accordion button
        const radioButton = this.querySelector('input[type="radio"]');
        if (radioButton) {
            // Set the radio button to checked
            radioButton.checked = true;
        }
    });
});