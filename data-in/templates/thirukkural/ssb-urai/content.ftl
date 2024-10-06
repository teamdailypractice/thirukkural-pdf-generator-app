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
</#list>
#pagebreak()
<#assign currentGroupId = bookPage.getGroupId()?number>
<#assign englishHeadingFontSize=pdfFontSettings.getEnglishHeadingFontSize()?number>
<#if currentGroupId == 6>
#set text(
  font: "${pdfFontSettings.getEnglishFontName()}",
  size: ${englishHeadingFontSize - 1}pt
)
<#else>
#set text(
  font: "${pdfFontSettings.getEnglishFontName()}",
  size: ${englishHeadingFontSize}pt
)
</#if>
#set align(center)
<#assign separator = ".  ">
= ${bookPage.getGroupId()}${separator}${bookPage.getTitleInEnglish()}
\
<#assign englishBodyFontSize=pdfFontSettings.getEnglishBodyFontSize()?number>
<#if currentGroupId == 1 || currentGroupId == 2 || currentGroupId == 19 || currentGroupId == 26 || currentGroupId == 45 || currentGroupId == 48 || currentGroupId == 50 || currentGroupId == 64 || currentGroupId == 71 || currentGroupId == 72 ||  currentGroupId == 73 || currentGroupId == 90 || currentGroupId == 92 || currentGroupId == 104>
#set text(
  font: "${pdfFontSettings.getEnglishFontName()}",
  size: ${englishBodyFontSize - 1}pt
)
<#else>
#set text(
  font: "${pdfFontSettings.getEnglishFontName()}",
  size: ${englishBodyFontSize}pt
)
</#if>
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
