<#import "/spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title>Add new event</title>
</head>
<body>
<div id="header">
    <H2>
        Add event form
    </H2>
</div>

<div id="content">
    <fieldset>
        <legend>Add Event</legend>
        <form name="event" action="addEvent" method="post">
            Name: <input type="text" name="name"/> <br/>
            Date: <input type="date" name="date"/> <br/>
            Price: <input type="number" min="1" name="basePrice"/> <br/>
            Rating:
        <#macro enumSelect selectName enumValues>
            <select name="${selectName}">
		        <#list enumValues as enum>
                    <option value="${enum}">${enum.description}</option>
		        </#list>
            </select>
        </#macro>
        <@enumSelect "rating" ratings/><br/>
            <input type="submit" value="   Save   "/>
        </form>
    </fieldset>
</div>
</body>
</html>