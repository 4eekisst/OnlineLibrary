<#import "../layout.ftlh" as profile>
<@profile.layout ; spring>

    <body>
    <h1>User Profile</h1>
    <p>Name: <span>${user.name}</span></p>
    <p>Surname: <span>${user.surname}</span></p>
    <p>Patronymic: <span>${user.patronymic}</span></p>
    <p>Address: <span>${user.address}</span></p>
    <p>Passport Number: <span>${user.passportNumber}</span></p>
    <p>Reader Card Number: <span>${user.readerCardNumber}</span></p>
    </body>


</@profile.layout>