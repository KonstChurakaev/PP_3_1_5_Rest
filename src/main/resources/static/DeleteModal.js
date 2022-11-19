const DeleteModal = document.getElementById('ModalDelete')
DeleteModal.addEventListener('show.bs.modal', event => {
    // Button that triggered the modal
    const Dbutton = event.relatedTarget
    // Extract info from data-bs-* attributes
    const DuserId = Dbutton.getAttribute('data-bs-userId')
    const DuserUsername = Dbutton.getAttribute('data-bs-userUsername')
    const DuserPassword = Dbutton.getAttribute('data-bs-userPassword')
    const DuserEmail = Dbutton.getAttribute('data-bs-userEmail')
    const DuserAge = Dbutton.getAttribute('data-bs-userAge')
    // Update the modal's content.

    const DmodaluserId = DeleteModal.querySelector('#userIdDelete')
    const DmodalUsername = DeleteModal.querySelector('#userUsernameDelete')
    const DmodaluserPassword = DeleteModal.querySelector('#userPasswordDelete')
    const DmodaluserEmail = DeleteModal.querySelector('#userEmailDelete')
    const DmodaluserAge = DeleteModal.querySelector('#userAgeDelete')

    DmodaluserId.value = DuserId
    DmodalUsername.value = DuserUsername
    DmodaluserPassword.value = DuserPassword
    DmodaluserEmail.value = DuserEmail
    DmodaluserAge.value = DuserAge

})