<#macro content>
#set page(numbering: "1")
#counter(page).update(1)
#set heading(numbering: none)

<#assign pdfFontSettings = book.getPdfFontSettings()>
<#assign lastKuralId = book.getBookConfiguration().getLastKuralId()?c>
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
#set align(left)
#set text(
  font: "${pdfFontSettings.getTamilFontName()}",
  size: ${pdfFontSettings.getTamilBodyFontSize()}pt
)
<#assign thirukkuralAttributeValueMapList = bookPage.getThirukkuralAttributeValueMapList()>
<#list thirukkuralAttributeValueMapList as thirukkuralAttributeValueMap>
#table(
  stroke: none,
  columns: (2cm, auto),
  [], [],
  [${thirukkuralAttributeValueMap.lineNumber}], [${thirukkuralAttributeValueMap.line1} \ ${thirukkuralAttributeValueMap.line2} \ ]
)
</#list>
#pagebreak()
<#assign currentGroupId=bookPage.getGroupId()>
<#if currentGroupId == 59 || currentGroupId == 73 || currentGroupId == 108>
#set text(
  font: "${pdfFontSettings.getTamilFontName()}",
  size: ${pdfFontSettings.getTamilBodyFontSize()?number-2}pt
)
<#elseif currentGroupId == 64>
#set text(
  font: "${pdfFontSettings.getTamilFontName()}",
  size: ${pdfFontSettings.getTamilBodyFontSize()?number-2.2}pt
)
<#else>
#set text(
  font: "${pdfFontSettings.getTamilFontName()}",
  size: ${pdfFontSettings.getTamilBodyFontSize()?number-1.5}pt
)
</#if>

<#assign spaces=".  ">
<#assign lineNumber=".  ">
<#list thirukkuralAttributeValueMapList as thirukkuralAttributeValueMap>
    <#assign urai=thirukkuralAttributeValueMap.urai_1>
    ${thirukkuralAttributeValueMap.lineNumber}${spaces}${urai?replace("\n", " ")}
    <#assign lineNumber=thirukkuralAttributeValueMap.lineNumber>
\
</#list>
<#if lineNumber != lastKuralId>
    #pagebreak()
</#if>

</#list>
</#macro>
