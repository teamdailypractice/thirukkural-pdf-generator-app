<#macro content>
#outline(
  title: "Tirukkural Topics"
)
#set page(numbering: "1")
#counter(page).update(1)
#set heading(numbering: none)

<#assign pdfFontSettings = book.getPdfFontSettings()>
<#assign lastKuralId = book.getBookConfiguration().getLastKuralId()?c>
<#list book.getBookPages() as bookPage>
#set page("a4")
<#assign thirukkuralAttributeValueMapList = bookPage.getThirukkuralAttributeValueMapList()>
#set text(
  font: "${pdfFontSettings.getEnglishFontName()}",
  size: ${pdfFontSettings.getEnglishHeadingFontSize()}pt
)
#set align(center)
<#assign separator = ".  ">
= ${bookPage.getGroupId()}${separator}${bookPage.getTitleInEnglish()}
\
#set text(
  font: "${pdfFontSettings.getEnglishFontName()}",
  size: ${pdfFontSettings.getEnglishBodyFontSize()}pt
)
#set align(left)
<#assign spaces=".  ">
<#assign lineNumber=".  ">
<#list thirukkuralAttributeValueMapList as thirukkuralAttributeValueMap>
<#assign uraiLines=thirukkuralAttributeValueMap.urai_1?split("\n")>
#table(
  stroke: none,
  columns: (1.6cm, auto),
  [], [],
  [${thirukkuralAttributeValueMap.lineNumber}], [${uraiLines[0]} \ ${uraiLines[1]} \ ]
)
<#assign lineNumber=thirukkuralAttributeValueMap.lineNumber>

</#list>
<#if lineNumber != lastKuralId>
    #pagebreak()
</#if>

</#list>
</#macro>
