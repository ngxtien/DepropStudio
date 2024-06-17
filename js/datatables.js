new DataTable('#productTable', {
    columnDefs: [
        {
            orderable: false,
            render: DataTable.render.select(),
            targets: 0
        }
    ],
    select: {
        style: 'multi+shift',
        selector: 'td'
    },
    order: [[1, 'asc']]
});