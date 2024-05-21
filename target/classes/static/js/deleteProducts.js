document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("deleteButton").addEventListener("click", function() {
        var checkboxes = document.querySelectorAll('input[name="selectedProducts"]:checked');

        const ids = Array.from(checkboxes)
            .map(checkbox => checkbox.value)
            .filter(value => value !== "on" && !isNaN(value))
            .join(',');

        if (ids.length > 0) {
            console.log(ids);
            window.location.href = `/delete/${ids}`;
        } else {
            console.log('No products selected for deletion');
        }
    });
});