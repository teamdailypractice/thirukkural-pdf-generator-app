<#macro content>
#set page(numbering: "1")
#counter(page).update(1)
#set heading(numbering: none)

<#assign pdfFontSettings = book.getPdfFontSettings()>
<#assign lastKuralId = book.getBookConfiguration().getLastKuralId()>
<#list book.getBookPages() as bookPage>
#set page("a4")
<#assign currentGroupId=bookPage.getGroupId()>

<#if currentGroupId == 64 || currentGroupId == 70>
#set text(
  font: "${pdfFontSettings.getTamilFontName()}",
  size: ${pdfFontSettings.getTamilHeadingFontSize()?number-1.5}pt
)
<#else>
#set text(
  font: "${pdfFontSettings.getTamilFontName()}",
  size: ${pdfFontSettings.getTamilHeadingFontSize()?number-1}pt
)
</#if>
#set align(center)
<#assign separator = ".  ">
= ${bookPage.getGroupId()}${separator}${bookPage.getTitleInTamil()}
\
#set align(left)
#set text(
  font: "${pdfFontSettings.getTamilFontName()}",
  size: ${pdfFontSettings.getTamilBodyFontSize()}pt
)
<#if currentGroupId == 64 || currentGroupId == 70>
#set text(
  font: "${pdfFontSettings.getTamilFontName()}",
  size: ${pdfFontSettings.getTamilBodyFontSize()?number-1.0}pt
)
</#if>
<#assign thirukkuralAttributeValueMapList = bookPage.getThirukkuralAttributeValueMapList()>
<#list thirukkuralAttributeValueMapList as thirukkuralAttributeValueMap>
#table(
  stroke: none,
  columns: (2cm, auto),
  [], [],
  [${thirukkuralAttributeValueMap.lineNumber}], [${thirukkuralAttributeValueMap.line1} \ ${thirukkuralAttributeValueMap.line2} \ ]
)
<#assign urai=thirukkuralAttributeValueMap.urai_1>
${urai?replace("\n", " ")}
<#assign currentKuralNumber = thirukkuralAttributeValueMap.lineNumber?number>
<#if currentKuralNumber % 5 == 0 && currentKuralNumber != lastKuralId>
#pagebreak()
</#if>

</#list>

</#list>
</#macro>
