<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>->Car<-</title>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link type="text/css" href="/static/interfacestyle/style.css" rel="stylesheet">
</head>
<body>

 <div class="text">
<h1>Car List</h1>
  </div>

<style>
   .text {
    text-align:  center;
   }
  </style>

<body style="background-color:#93F763;">
</body>

<div class="div1">
    <button type="button" class="btn btn-outline-primary" onclick="window.location.href = '/index.html'">
        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-box-arrow-in-left" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" d="M10 3.5a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-2a.5.5 0 0 1 1 0v2A1.5 1.5 0 0 1 9.5 14h-8A1.5 1.5 0 0 1 0 12.5v-9A1.5 1.5 0 0 1 1.5 2h8A1.5 1.5 0 0 1 11 3.5v2a.5.5 0 0 1-1 0v-2z"></path>
            <path fill-rule="evenodd" d="M4.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H14.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"></path>
        </svg>
    </button>
<#--    <div class="dropdown-menu">-->
<#--        <a>menu</a>-->
<#--        <button class="btn btn-outline-success dropdown-item" onclick="window.location.href = '/web/item/all/sort/id'">Id</button>-->
<#--        <button class="btn btn-outline-success" onclick="window.location.href = '/web/item/all/sort/name'">Name</button>-->
<#--        <button class="btn btn-outline-success" onclick="window.location.href = '/web/item/all/sort/modified'">Modified</button>-->
<#--    </div>-->
    <#--<a href="/index.html" class="button1">Back</a>-->
</div>
<br>

<button class="btn btn-info" onclick="window.location.href = '/web/client/list'">Refresh</button>
<div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Sorted
    </button>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
<#--        <button class="dropdown-item btn btn-danger" onclick="window.location.href = '/web/item/all/sort/id'">Id</button>-->
        <button type="button" class="btn btn-outline-primary" onclick="window.location.href = '/web/item/all/sort/id'">
            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-sort-numeric-down" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" d="M4 2a.5.5 0 0 1 .5.5v11a.5.5 0 0 1-1 0v-11A.5.5 0 0 1 4 2z"></path>
                <path fill-rule="evenodd" d="M6.354 11.146a.5.5 0 0 1 0 .708l-2 2a.5.5 0 0 1-.708 0l-2-2a.5.5 0 0 1 .708-.708L4 12.793l1.646-1.647a.5.5 0 0 1 .708 0z"></path>
                <path d="M12.438 7V1.668H11.39l-1.262.906v.969l1.21-.86h.052V7h1.046zm-2.84 5.82c.054.621.625 1.278 1.761 1.278 1.422 0 2.145-.98 2.145-2.848 0-2.05-.973-2.688-2.063-2.688-1.125 0-1.972.688-1.972 1.836 0 1.145.808 1.758 1.719 1.758.69 0 1.113-.351 1.261-.742h.059c.031 1.027-.309 1.856-1.133 1.856-.43 0-.715-.227-.773-.45H9.598zm2.757-2.43c0 .637-.43.973-.933.973-.516 0-.934-.34-.934-.98 0-.625.407-1 .926-1 .543 0 .941.375.941 1.008z"></path>
            </svg>
        </button>
<#--        <button class="dropdown-item btn btn-danger" onclick="window.location.href = '/web/item/all/sort/name'">Name</button>-->
        <button type="button" class="btn btn-outline-primary" onclick="window.location.href = '/web/item/all/sort/name'">
            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" d="M10 5a2 2 0 1 1-4 0 2 2 0 0 1 4 0zM8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6 5c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"></path>
            </svg>
        </button>
<#--        <button class="dropdown-item btn btn-danger" onclick="window.location.href = '/web/item/all/sort/modified'">Modified</button>-->
        </button>
        <button type="button" class="btn btn-outline-primary" onclick="window.location.href = '/web/item/all/sort/modified'">
            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-calendar2-date" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM2 2a1 1 0 0 0-1 1v11a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1H2z"></path>
                <path d="M2.5 4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H3a.5.5 0 0 1-.5-.5V4zm3.945 8.688V7.354h-.633A12.6 12.6 0 0 0 4.5 8.16v.695c.375-.257.969-.62 1.258-.777h.012v4.61h.675zm1.188-1.305c.047.64.594 1.406 1.703 1.406 1.258 0 2-1.066 2-2.871 0-1.934-.781-2.668-1.953-2.668-.926 0-1.797.672-1.797 1.809 0 1.16.824 1.77 1.676 1.77.746 0 1.23-.376 1.383-.79h.027c-.004 1.316-.461 2.164-1.305 2.164-.664 0-1.008-.45-1.05-.82h-.684zm2.953-2.317c0 .696-.559 1.18-1.184 1.18-.601 0-1.144-.383-1.144-1.2 0-.823.582-1.21 1.168-1.21.633 0 1.16.398 1.16 1.23z"></path>
            </svg>
        </button>
    </div>
</div>

<button type="button" class="btn btn-warning" onclick="window.location.href='/web/item/create'">
    Create
    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-plus" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
        <path fill-rule="evenodd" d="M8 5a2 2 0 1 1-4 0 2 2 0 0 1 4 0zM6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6 5c0 1-1 1-1 1H1s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C9.516 10.68 8.289 10 6 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10zM13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"></path>
    </svg>
</button>
<div>

    <fieldset>
        <legend></legend>
        <nav class="navbar navbar-light" style="background-color: #87B9FE;">
            <!-- Navbar content -->

            <form name="Client" action="" method="POST">
                Search:<@spring.formInput "search.name" "" "text"/>
                <input type="submit" value="Push"/>
            </form>

        </nav>
    </fieldset>

    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th>id</th></th>
            <th>Name</th>
            <th>Description</th>
            <th>Created</th>
            <th>Modified</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list spisok as element> <!--Цикл по всем element !! -->
            <!--Для каждого element в списке items , который мы получили
             из контроллера . -----------------------------
             Формируем строку <tr>. У этой строки есть ..5.. ячеек
              Каждая ичейка является полем ..елемента.. !
              (id)(name) т.д !!! -->
            <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.description}</td>
                <td>${element.created_at}</td>
                <td>${element.modified_at}</td>
<#--                <td><a href="/web/item/delete/${element.id}" class="btn btn-outline-danger">Delete</a></td>-->
               <td><button type="button" class="btn btn-outline-danger" onclick="window.location.href='/web/item/delete/${element.id}'">
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-dash-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm5-.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5z"></path>
                    </svg>
                </button></td>
                <td>
<#--                    <a href="/web/item/update/${element.id}" class="btn btn-outline-success">Edit</a>-->
                    <button type="button" class="btn btn-outline-success" onclick="window.location.href='/web/item/update/${element.id}'">
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-sliders" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M11.5 2a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM9.05 3a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0V3h9.05zM4.5 7a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM2.05 8a2.5 2.5 0 0 1 4.9 0H16v1H6.95a2.5 2.5 0 0 1-4.9 0H0V8h2.05zm9.45 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zm-2.45 1a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0v-1h9.05z"></path>
                        </svg>
                    </button>
                </td>
            </tr>
        </#list>
    </table>
<#--    <a href="/web/item/create" class="btn btn-warning">Create</a>-->

</div>
</body>
</html>