const formDelete = document.getElementById('formDelete')
formDelete.addEventListener('submit', e =>{
    e.preventDefault();
    const formData = new FormData(formDelete);
    fetch("api/delete/"+formData.get("id"), {
        method: "DELETE"
    })
        .then(() => allUsers());
    $("#ModalDelete").modal("hide");
    formDelete.reset();
})


const DeleteModal = document.getElementById('ModalDelete')
DeleteModal.addEventListener('show.bs.modal', event => {
    // Button that triggered the modal
    const Dbutton = event.relatedTarget
    // Extract info from data-bs-* attributes
    const DuserId = Dbutton.getAttribute('data-bs-userId')
    const DuserUsername = Dbutton.getAttribute('data-bs-userUsername')
    const DuserLastname = Dbutton.getAttribute('data-bs-userLastname')
    const DuserAge = Dbutton.getAttribute('data-bs-userAge')
    const DuserEmail = Dbutton.getAttribute('data-bs-userEmail')
    const DuserPassword = Dbutton.getAttribute('data-bs-userPassword')

    // Update the modal's content.
    const DmodaluserId = DeleteModal.querySelector('#userIdDelete')
    const DmodalUsername = DeleteModal.querySelector('#userUsernameDelete')
    const DmodalLastname = DeleteModal.querySelector('#userLastnameDelete')
    const DmodaluserAge = DeleteModal.querySelector('#userAgeDelete')
    const DmodaluserEmail = DeleteModal.querySelector('#userEmailDelete')
    const DmodaluserPassword = DeleteModal.querySelector('#userPasswordDelete')

    DmodaluserId.value = DuserId
    DmodalUsername.value = DuserUsername
    DmodalLastname.value = DuserLastname
    DmodaluserAge.value = DuserAge
    DmodaluserEmail.value = DuserEmail
    DmodaluserPassword.value = DuserPassword

})