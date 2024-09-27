<#macro content>
#set page(numbering: "1")
#counter(page).update(1)
#set heading(numbering: "1.")

<#list book.getBookPages() as bookPage>
#set page("a4")
#set text(
  font: "TSCu_SaiIndira",
  size: 12pt
)
#set align(center)
= ${bookPage.getTitleInTamil()}
\
#set align(left)
#table(
  stroke: none,
  columns: (1.5cm, auto),
  [], [],
  <#assign thirukkuralAttributeValueMapList = bookPage.getThirukkuralAttributeValueMapList()>
  <#list thirukkuralAttributeValueMapList as thirukkuralAttributeValueMap>
  [${thirukkuralAttributeValueMap.lineNumber}], [${thirukkuralAttributeValueMap.line1} \ ${thirukkuralAttributeValueMap.line2} \ \ ],
  </#list>
)
</#list>
</#macro>
