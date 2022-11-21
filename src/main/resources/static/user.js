function userPage() {
    const url = '/api/user'

    fetch(url).then(response => response.json()).then(user => {
        let userRoles = ''
        for (const rolesListElement of user.roles) {
            userRoles = userRoles + rolesListElement.name.split("_")[1] + ', '
        }
        userRoles = userRoles.substring(0, userRoles.length-2)

        $('#navbarName').text(`${user.username}`)
        $('#navbarRole').text(`${userRoles}`)

        let trHtml =
            `<tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.lastname}</td>
                    <td>${user.age}</td>
                    <td>${user.email}</td>
                    <td>${userRoles}</td>
                </tr>`
        $('#userTable').html(trHtml)
    })
}
userPage()
