$(document).ready(function() {
    $('#productTable').DataTable({
        // Customization options
        paging: true,
        searching: true,
        ordering: true,
        columnDefs: [
            { 
                orderable: false,
                render: DataTable.render.select(),
                targets: 0,
            } 
        ],
        select: {
            style: 'multi+shift',
            selector: 'td'
        },
        order: [[1, 'asc']]
    });

    $('#deleteButton').on('click', function() {
        var table = $('#productTable').DataTable();
        table.rows('.selected').remove().draw();
    });
});