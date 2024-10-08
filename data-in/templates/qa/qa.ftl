<!DOCTYPE html>
<html lang="ta">

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

  <title>QA - Thirukkural?</title>
  <!-- Latest Bootstrap 5 CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <link rel="stylesheet" href="styles/qa.css">
</head>

<body>
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark" aria-label="Thirukkural Agara Mudhali">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">திருக்குறள் Thirukkural</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03"
        aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample03">
        <ul class="navbar-nav me-auto mb-2 mb-sm-0">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">Thirukkural</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="../index.html">தேடுக Search</a></li>
              <li><a class="dropdown-item" href="../topics.html">அதிகாரங்கள் Topics</a></li>
              <li><a class="dropdown-item active" href="#">QA கேள்வி பதில்?</a></li>
              <li><a class="dropdown-item" href="../am/index.html">அ..ஆ..க..கா</a></li>
              <li><a class="dropdown-item" href="../books.html">Books Download</a></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">Tamil
              Resources</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="https://www.tamilvu.org/">Tamil Virtual Academy</a></li>
              <li><a class="dropdown-item" href="https://www.tamildigitallibrary.in/">Tamil Digital library</a></li>
              <li><a class="dropdown-item" href="https://www.projectmadurai.org/pmworks.html">Project Madurai</a></li>
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
    <!-- Static List of Headings and Details -->
    <div>
      <span class="tamil-content">உரை: மு. வரதராசனார்</span><br />
      <span class="english-content">Translation: Kavi Yogi Shudhdhanandha Bharati</span>
    </div>

    <!-- Navigation Links -->
    <div class="mt-4 mb-4 d-flex justify-content-between">
      <a href="index.html" class="btn btn-primary">QA Home</a>
    </div>
    <!-- ThirukkuralAgaraMudhali entity-->
    <div class="accordion" id="itemAccordion">
      <#list qac.getQuestionAnswerKuralList() as qacItem>
        <#assign currentItemIndex=qacItem?index+1>
          <#assign headingId="heading" +currentItemIndex>
            <#assign collapseName="collapse" +currentItemIndex>
              <div class="accordion-item">
                <h2 class="accordion-header" id="${headingId}">
                  <button class="accordion-button tamil-content-header" type="button" data-bs-toggle="collapse"
                    data-bs-target="#${collapseName}" aria-expanded="true" aria-controls="${collapseName}">
                    ${qacItem.getQuestion()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${currentItemIndex}
                  </button>
                </h2>
                <div id="${collapseName}" class="accordion-collapse collapse" aria-labelledby="${headingId}"
                  data-bs-parent="#itemAccordion">
                  <div class="accordion-body">
                    <!-- List<ThirukkuralAgaraMudhali> items  -->
                    <#list items as item>
                      <p>
                        <span class="tamil-content-kural">${item.getLine1()}</span><br />
                        <span class="tamil-content-kural">${item.getLine2()}</span><br />
                        <audio controls src="../../kural/media/${item.getKural_id()}.mp3"></audio>
                        <br />
                        <!-- Tamil Explanation -->
                        <span class="tamil-content">${item.getTamil()}</span>
                        <br />
                        <br />
                        <!-- English Explanation -->
                        <#assign uraiLines=item.getEnglish()?split("\n")>
                          <span class="english-content">${uraiLines[0]}
                            <br />${uraiLines[1]}</span>
                          <br />
                          <br />
                          <!-- Topic title in Tamil and english hyperlink -->
                          <span>
                            <a href="../index.html?${item.getKural_id()}"
                              target="_blank">${item.getKural_id()}</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="../index.html?${item.getGroup_id()}a"
                              target="_blank">${item.getId_title_ta()}</a></span>&nbsp;&nbsp;&nbsp;&nbsp;
                          <a href="../index.html?${item.getGroup_id()}a"
                            target="_blank">${item.getId_title_en()}</a></span>
                          <br />
                      </p>
                    </#list>
                  </div>
                </div>
              </div>
      </#list>
    </div>

    <!-- Navigation Links -->
    <div class="mt-4 mb-4 d-flex justify-content-between">
      <a href="index.html" class="btn btn-primary">QA Home</a>
    </div>
  </div>
  <!-- Latest Bootstrap 5 JS (for Collapse functionality) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
</body>

</html>