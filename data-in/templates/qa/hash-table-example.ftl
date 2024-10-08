<#-- Accessing the values from the HashMap -->
<p>Key1: ${myMap.key1}</p>
<p>Key2: ${myMap.key2}</p>

<#-- Iterating over the HashMap -->
<ul>
<#list myMap as key, value>
    <li>${key}: ${value}</li>
</#list>
</ul>

<#-- Iterating over the HashMap entries -->
<#list myMap2 as key, valueList>
    <h2>${key}</h2>
    <ul>
        <#-- Iterating over the List<String> for each key -->
        <#list valueList as value>
            <li>${value}</li>
        </#list>
    </ul>
</#list>

<#-- Iterating over the HashMap entries -->
<#list xxx as key, valueList>
    <h2>${key}</h2>
    <ul>
        <#-- Iterating over the List<String> for each key -->
        <#list valueList as value>
            <li>${value.getTamil()}</li>
        </#list>
    </ul>
</#list>