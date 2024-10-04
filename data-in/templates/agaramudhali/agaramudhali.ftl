<!DOCTYPE html>
<html lang="ta">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>அகரமுதலி</title>
    <!-- Latest Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="agaramudhali.css">
</head>

<body>

    <div class="container mt-5">
        <!-- Static List of Headings and Details -->
        <div>
            <span class="tamil-content">உரை: மு. வரதராசனார்</span><br />
            <span class="english-content">Translation: Kavi Yogi Shudhdhanandha Bharati</span>
        </div>
        <!-- ThirukkuralAgaraMudhali entity-->
        <div class="accordion" id="itemAccordion">
            <#list items as item>
                <#assign currentItemIndex=item?index+1>
                <#assign headingId="heading" +currentItemIndex>
                <#assign collapseName="collapse" +currentItemIndex>
                            <div class="accordion-item">
                                <h2 class="accordion-header" id="${headingId}">
                                    <button class="accordion-button tamil-content-header" type="button"
                                        data-bs-toggle="collapse" data-bs-target="#${collapseName}" aria-expanded="true"
                                        aria-controls="${collapseName}">
                                        ${item.getLine1()} <br />
                                        ${item.getLine2()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${currentItemIndex}
                                    </button>
                                </h2>
                                <div id="${collapseName}" class="accordion-collapse collapse"
                                    aria-labelledby="${headingId}" data-bs-parent="#itemAccordion">
                                    <div class="accordion-body">
                                        <p>
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
                                                <span><a
                                                        href="../index.html?${item.getGroup_id()}a">${item.getId_title_ta()}</a></span>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <span><a
                                                        href="../index.html?${item.getGroup_id()}a">${item.getId_title_en()}</a></span>
                                                <br />
                                                <br />
                                                <!-- kural number and hyperlink -->
                                                <a
                                                    href="../index.html?${item.getKural_id()}">${item.getKural_id()}</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <audio controls src="../kural/media/${item.getKural_id()}.mp3"></audio>
                                        </p>
                                    </div>
                                </div>
                            </div>
            </#list>
        </div>
    </div>
    <!-- Latest Bootstrap 5 JS (for Collapse functionality) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>