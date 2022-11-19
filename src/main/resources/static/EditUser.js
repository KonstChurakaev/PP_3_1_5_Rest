const formEdit = document.getElementById("formEdit");
formEdit.addEventListener('submit', e => {
    e.preventDefault();

    const formData = new FormData(formEdit);
    const object = {
        roles:[]
    };

    formData.forEach((value, key) => {
        if (key === "rolesId"){

            const roleId = value.split(" ")[0];
            const roleName = value.split(" ")[1];
            const role = {
                id : roleId,
                name : "ROLE_" + roleName
            };
            object.roles.push(role);
        } else {
            object[key] = value;
        }
    });
    fetch("api/edit/"+formData.get("id"), {
        method: "PUT",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(object)
    })
        .then(() => allUsers());
    $("#ModalEdit").modal("hide");
    formEdit.reset();
})

const editModal = document.getElementById('ModalEdit')
editModal.addEventListener('show.bs.modal', event => {
    // Button that triggered the modal
    const button = event.relatedTarget
    // Extract info from data-bs-* attributes
    const userId = button.getAttribute('data-bs-userId')
    const userUsername = button.getAttribute('data-bs-userUsername')
    const userLastname = button.getAttribute('data-bs-userLastname')
    const userAge = button.getAttribute('data-bs-userAge')
    const userEmail = button.getAttribute('data-bs-userEmail')
    const userPassword = button.getAttribute('data-bs-userPassword')

    // Update the modal's content.

    const modaluserId = editModal.querySelector('#userId')
    const modaluserUsername = editModal.querySelector('#userUsername')
    const modaluserLastname = editModal.querySelector('#userLastname')
    const modaluserAge = editModal.querySelector('#userAge')
    const modaluserEmail = editModal.querySelector('#userEmail')
    const modaluserPassword = editModal.querySelector('#userPassword')

    modaluserId.value = userId
    modaluserUsername.value = userUsername
    modaluserLastname.value = userLastname
    modaluserAge.value = userAge
    modaluserEmail.value = userEmail
    modaluserPassword.value = userPassword
})

