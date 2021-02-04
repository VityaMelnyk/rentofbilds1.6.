<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>update Client</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<div>
    <fieldset>
        <legend>update Client</legend>
        <form name="client" action="" method="POST">
            Full Name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Gender:<@spring.formSingleSelect "form.gender", genders, ""/>
            <br>
            Adress:<@spring.formInput "form.adress" "" "text"/>
            <br>
            Phone:<@spring.formInput "form.phone" "" "tel"/>
            <br>
            Birthday:<@spring.formInput "form.dateOfBirthday" "" "date"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>

</body>
</html>