document.getElementById('scanBtn').addEventListener('click', function() {
    const files = document.getElementById('fileInput').files;
    if (files.length > 0) {
        const formData = new FormData();
        for (let i = 0; i < files.length; i++) {
            formData.append('files', files[i]);
        }

        fetch('/scan', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            document.getElementById('results').innerText = JSON.stringify(data, null, 2);
        });
    } else {
        alert('Please select files to scan.');
    }
});