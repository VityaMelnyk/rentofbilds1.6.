<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>update Record</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>
<div>
    <fieldset>
        <legend>update Client</legend>
        <form name="record" action="" method="POST">
            Name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Des:<@spring.formInput "form.description" "" "text"/>
            <br>
            Start:<@spring.formInput "form.start" "" "date"/>
            <br>
            Finish:<@spring.formInput "form.finish" "" "date"/>
            <br>
            Client:<@spring.formSingleSelect "form.client", clients, ""/>
            <br>
            <#-- Bulid:<@spring.formSingleSelect "form.build", builds, ""/>-->
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>
</body>
</html>