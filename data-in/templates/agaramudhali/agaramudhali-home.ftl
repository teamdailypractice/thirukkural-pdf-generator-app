<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Bootstrap 5 Table with Links</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2>${hyperlinks.getTitle()}</h2>
    <table id="example" class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>${hyperlinks.getTitle()}</th>
            </tr>
        </thead>
        <tbody>
            <#assign hyperlinkItemsList = hyperlinks.getHyperlinks()>
            <#list hyperlinkItemsList as hyperlinkItem>
            <tr>
                <td><a href="${hyperlinkItem.url}" target="_blank">${hyperlinkItem.text}</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>

<!-- jQuery (required for DataTables) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Bootstrap 5 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<!-- DataTables JS -->
<script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>

<!-- Initialize DataTable -->
<script>
    $(document).ready(function() {
        $('#example').DataTable({
           "paging": false  // Disable pagination
        });
    });
</script>

</body>
</html>
