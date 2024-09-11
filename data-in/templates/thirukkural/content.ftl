<#macro content>
#set page(numbering: "1")
#counter(page).update(1)
<#list book.getBookPages() as bookPage>
#set page("a4")
#set text(
  font: "TSCu_SaiIndira",
  size: 12pt
)
#set align(center)
= ${bookPage.getTitle()}
\
#set align(left)
#table(
  stroke: none,
  columns: (2cm, auto),
  [], [],
  <#assign lineNumberContentMapList = bookPage.getLineNumberContentMapList()>
  <#list lineNumberContentMapList as lineNumberContentMap>
  [${lineNumberContentMap.lineNumber}], [${lineNumberContentMap.a1} \ ${lineNumberContentMap.a2} \ \ ],
  </#list>
)
</#list>
</#macro>
