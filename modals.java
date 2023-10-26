// Define your content URLs for each modal
const researchContentUrl = 'html/research.html';
const projectContentUrl = 'html/project.html';
const outreachContentUrl = 'html/outreach.html';
const cvContentUrl = 'html/CV.html';

// Function to open the Research modal
function openResearchModal() {
    openModal('myModal1', researchContentUrl);
}

// Function to open the Project modal
function openProjectModal() {
    openModal('myModal2', projectContentUrl);
}

// Function to open the Outreach modal
function openOutreachModal() {
    openModal('myModal3', outreachContentUrl);
}

// Function to open the CV modal
function openCVModal() {
    openModal('myModal4', cvContentUrl);
}

// Call these functions when specific links are clicked
document.getElementById('research-link').addEventListener('click', openResearchModal);
document.getElementById('project-link').addEventListener('click', openProjectModal);
document.getElementById('outreach-link').addEventListener('click', openOutreachModal);
document.getElementById('cv-link').addEventListener('click', openCVModal);

const modals = document.querySelectorAll('.modal');
const modalContent = document.getElementById('modal-content-container');
const closeButtons = document.querySelectorAll('.close');

function openModal(modalId, contentUrl) {
    const modal = document.getElementById(modalId);
    modal.style.display = 'block';
    fetch(contentUrl)
        .then(response => response.text())
        .then(data => {
            modalContent.innerHTML = data;
        });
}

function closeModal(modalId) {
    const modal = document.getElementById(modalId);
    modal.style.display = 'none';
    modalContent.innerHTML = ''; // Clear the modal content
}

closeButtons.forEach(button => {
    button.addEventListener('click', () => {
        const modalId = button.getAttribute('data-modal-id');
        closeModal(modalId);
    });
});

window.addEventListener('click', event => {
    if (event.target.classList.contains('modal')) {
        const modalId = event.target.getAttribute('id');
        closeModal(modalId);
    }
});
