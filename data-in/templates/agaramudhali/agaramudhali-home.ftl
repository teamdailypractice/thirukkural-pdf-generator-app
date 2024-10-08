<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Tirukkural - Wisdom">
    <meta name="robots" content="index, follow">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="ta">
    <meta http-equiv="cache-control" content="max-age=31536000">
    <meta name="theme-color" content="#333333">
    <meta property="og:title" content="Tirukkural">
    <meta property="og:description" content="Tirukkural - Wisdom">
    <meta property="og:image"
        content="https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Tiruvalluvar_Statue_Kanyakumari.jpg/340px-Tiruvalluvar_Statue_Kanyakumari.jpg">
    <meta property="og:url" content="https://dailypractice.info/thirukkural">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/2.1.8/css/dataTables.bootstrap5.css" rel="stylesheet">
    <link rel="stylesheet" href="styles/agaramudhali.css">

    <title>${hyperlinks.getTitle()}</title>
</head>

<body>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark" aria-label="Thirukkural Navigation Bar">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">திருக்குறள் Thirukkural</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03"
                aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExample03">
                <ul class="navbar-nav me-auto mb-2 mb-sm-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown"
                            aria-expanded="false">Thirukkural</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="../index.html">தேடுக Search</a></li>
                            <li><a class="dropdown-item" href="../topics.html">அதிகாரங்கள் Topics</a></li>
                            <li><a class="dropdown-item active" href="../qa/index.html">கேள்வி? பதில்! QA</a></li>
                            <li><a class="dropdown-item active" href="#">அ..ஆ..க..கா</a></li>
                            <li><a class="dropdown-item" href="../books.html">Books Download</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown"
                            aria-expanded="false">Tamil
                            Resources</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="https://www.tamilvu.org/">Tamil Virtual Academy</a></li>
                            <li><a class="dropdown-item" href="https://www.tamildigitallibrary.in/">Tamil Digital
                                    library</a></li>
                            <li><a class="dropdown-item" href="https://www.projectmadurai.org/pmworks.html">Project
                                    Madurai</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown"
                            aria-expanded="false">DailyPractice</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="../../addition.html">Addition</a></li>
                            <li><a class="dropdown-item" href="../../subtraction.html">Subtraction</a></li>
                            <li><a class="dropdown-item" href="../../mul-table-s1.html">Multiplication Table</a></li>
                            <li><a class="dropdown-item" href="../../division.html">Division</a></li>
                            <li><a class="dropdown-item" href="../../index.html">Home</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <h2 align="center">${hyperlinks.getTitle()}</h2>
        <table id="example" class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>${hyperlinks.getTitle()}</th>
                    <th>திருக்குறள் எண்ணிக்கை</th>
                </tr>
            </thead>
            <tbody>
                <#assign hyperlinkItemsList=hyperlinks.getHyperlinksWithCount()>
                    <#list hyperlinkItemsList as hyperlinkItem>
                        <tr>
                            <td><a href="${hyperlinkItem.getUrl()}" target="_blank">${hyperlinkItem.getText()}</a></td>
                            <td>${hyperlinkItem.getCount()}</td>
                        </tr>
                    </#list>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

    <script src="https://cdn.datatables.net/2.1.8/js/dataTables.js"></script>
    <script src="https://cdn.datatables.net/2.1.8/js/dataTables.bootstrap5.js"></script>



    <!-- Initialize DataTable -->
    <script>
        $(document).ready(function () {
            $('#example').DataTable({
                "paging": false  // Disable pagination
            });
        });
    </script>

</body>

</html>