<#macro content>
#set page(numbering: "1")
#counter(page).update(1)
#set heading(numbering: none)

<#assign lastKuralId = book.getBookConfiguration().getLastKuralId()>
<#list book.getBookPages() as bookPage>
#set page("a4")
#set text(
  font: "TSCu_SaiIndira",
  size: 12pt
)
#set align(center)
<#assign separator = ".  ">
= ${bookPage.getGroupId()}${separator}${bookPage.getTitleInTamil()}
\
<#assign currentGroupId = bookPage.getGroupId()?number>
<#if currentGroupId == 26 || currentGroupId == 64>
#set text(
  font: "JetBrains Mono",
  size: 11.0pt
)
<#else>
#set text(
  font: "JetBrains Mono",
  size: 12.1pt
)
</#if>

${bookPage.getGroupId()}${separator}${bookPage.getTitleInEnglish()}
\
#set align(left)
<#assign thirukkuralAttributeValueMapList = bookPage.getThirukkuralAttributeValueMapList()>
<#list thirukkuralAttributeValueMapList as thirukkuralAttributeValueMap>

#table(
  stroke: none,
  columns: (2cm, auto),
  [], [],
  [${thirukkuralAttributeValueMap.lineNumber}], [${thirukkuralAttributeValueMap.line1} \ ${thirukkuralAttributeValueMap.line2} \ ]
)

<#assign uraiLines=thirukkuralAttributeValueMap.urai_1?split("\n")>
#table(
  stroke: none,
  columns: (2cm, auto),
  [], [],
  [${thirukkuralAttributeValueMap.lineNumber}], [${uraiLines[0]} \ ${uraiLines[1]} \ ]
)
<#assign currentKuralNumber = thirukkuralAttributeValueMap.lineNumber?number>
<#if currentKuralNumber != lastKuralId && currentKuralNumber % 5 == 0>
#pagebreak()
<#elseif currentKuralNumber % 10 == 0 && currentKuralNumber != lastKuralId >
#pagebreak()
</#if>
</#list>

</#list>
</#macro>
