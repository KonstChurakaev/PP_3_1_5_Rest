const editModal = document.getElementById('ModalEdit')
editModal.addEventListener('show.bs.modal', event => {
    // Button that triggered the modal
    const button = event.relatedTarget
    // Extract info from data-bs-* attributes
    const userId = button.getAttribute('data-bs-userId')
    const userUsername = button.getAttribute('data-bs-userUsername')
    const userPassword = button.getAttribute('data-bs-userPassword')
    const userEmail = button.getAttribute('data-bs-userEmail')
    const userAge = button.getAttribute('data-bs-userAge')
    // Update the modal's content.

    const modaluserId = editModal.querySelector('#userId')
    const modaluserUsername = editModal.querySelector('#userUsername')
    const modaluserPassword = editModal.querySelector('#userPassword')
    const modaluserEmail = editModal.querySelector('#userEmail')
    const modaluserAge = editModal.querySelector('#userAge')

    modaluserId.value = userId
    modaluserUsername.value = userUsername
    modaluserPassword.value = userPassword
    modaluserEmail.value = userEmail
    modaluserAge.value = userAge


})