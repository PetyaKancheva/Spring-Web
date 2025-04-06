// $(document).ready(function(){
//     alert("alert petya");
// });
$('#get-all-button').click(fetchAllComments);

$('#single-comment-button').click(fetchSingleComment);
// post complete form. do by each field to catch errors
$('#add-comment-button').click(() => $('#new-comment-form').submit());
$('#delete-comment-button').click(deleteComment);

let errorMsg = 'Must be populated';
let errorP = document.createElement('p');
errorP.textContent = errorMsg;
errorP.className = " alert alert-danger input-group-sm mb-3";

async function fetchAllComments() {
    const url = '/api/comments/fetch';

    try {
        const response = await fetch(url);
        if (!response.ok) {
            alert(response.status);
        }

        const json = await response.json();

        json.forEach((c, comments) => {
            if (comments % 3 === 0) {
                $('.data-container').append('<div class="row d-flex justify-content-around mt-4">');
            }
            let commentCard =

                '<div class="card m-3" style="width: 18rem">' +
                '<div className="card-body">' +
                '<h5 class="card-title">' + c.title + '</h5>' +
                '<h6 class="card-subtitle mb-2 text-body-secondary">ID: ' + c.id + ' By: ' + c.user_name + '</h6>' +
                '<p class="card-text ">' + c.body + '</p>'
                + '</div>' + '</div>' + '</div>';
            $('.data-container .row:last-child').append(commentCard);
        });
    } catch (error) {
        alert(error);
    }
}


async function fetchSingleComment() {
    let singleCommentID = $('#single-comment-input').val();
    if (singleCommentID>0) {
        fetch(`/api/comment/${singleCommentID}`)

            .then((response) => response.json())
            .then((c) => {
                let commentCard =
                    // '<div class="row d-flex">' +
                    '<div class="card m-3" style="width: 18rem">' +
                    '<div className="card-body">' +
                    '<h5 class="card-title">' + c.title + '</h5>' +
                    '<h6 class="card-subtitle mb-2 text-body-secondary">ID: ' + c.id + ' By: ' + c.user_name + '</h6>' +
                    '<p class="card-text ">' + c.body + '</p>'
                    + '</div>' + '</div>' + '</div>';
                $('#single-comment-container').after(commentCard);
            })
            .catch(error => alert(error));

    } else {
        $('#single-comment-container').after(errorP);
    }


}


// $('#delete-comment-button').click(() => {
//     let deleteID = $('#delete-comment-input').val();
//
//     fetch(`/api/comment/delete/${deleteID}`)
//         .then((response) => response.json())
//         .then((json) => {
//             $('#delete-comment-error').append(json)
//         })
//         .catch(error => $('#delete-comment-error').append(error));
// });


function deleteComment() {

    let deleteID = $('#delete-comment-input').val();
    if (deleteID.length>0) {
        fetch(`/api/comment/delete/${deleteID}`)
            .catch(error => alert(error));
    } else {
        $('#delete-comment-container').after(errorP);
    }
}