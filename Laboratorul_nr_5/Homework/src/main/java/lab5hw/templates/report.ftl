
<!DOCTYPE html>

<html lang="en">
<head>
    <title>${title}</title>
</head>
<body>
<h1>${title}</h1>

<p>${CatalogA.name}</p>

<ul>
    <#list items as item>
    <p>${item_index + 1}. ${item.id}, ${item.title}, ${item.location}, ${item.author}, ${item.year}</p>
</#list>
</ul>

</body>
</html>