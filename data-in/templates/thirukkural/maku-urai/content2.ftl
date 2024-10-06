<#macro content>
#set page(numbering: "1")
#counter(page).update(1)
#set heading(numbering: none)

<#assign pdfFontSettings = book.getPdfFontSettings()>
<#assign lastKuralId = book.getBookConfiguration().getLastKuralId()>
<#list book.getBookPages() as bookPage>
#set page("a4")
#set text(
  font: "${pdfFontSettings.getTamilFontName()}",
  size: ${pdfFontSettings.getTamilHeadingFontSize()}pt
)
#set align(center)
<#assign separator = ".  ">
= ${bookPage.getGroupId()}${separator}${bookPage.getTitleInTamil()}
\
#set text(
  font: "${pdfFontSettings.getTamilFontName()}",
  size: ${pdfFontSettings.getTamilBodyFontSize()}pt
)
#set align(left)

<#assign thirukkuralAttributeValueMapList = bookPage.getThirukkuralAttributeValueMapList()>
<#list thirukkuralAttributeValueMapList as thirukkuralAttributeValueMap>
#table(
  stroke: none,
  columns: (2cm, auto),
  [], [],
  [${thirukkuralAttributeValueMap.lineNumber}], [${thirukkuralAttributeValueMap.line1} \ ${thirukkuralAttributeValueMap.line2} \ ]
)
${thirukkuralAttributeValueMap.urai_1}
<#assign currentKuralNumber = thirukkuralAttributeValueMap.lineNumber?number>
<#if currentKuralNumber % 5 == 0 && currentKuralNumber != lastKuralId>
#pagebreak()
</#if>

</#list>

</#list>
</#macro>
