/*
document.getElementById('newsletterForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    const id = document.getElementById('id').value;
    const subject = document.getElementById('subject').value;
    const content = document.getElementById('content').value;

    const newsletter = { id, subject, content };

    try {
        const setResponse = await fetch('/api/newsletter/set', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newsletter),
        });

        if (setResponse.ok) {
            alert('Newsletter set successfully!');
        } else {
            alert('Failed to set newsletter!');
            return;
        }

        // Delay of 2 seconds (2000 milliseconds)
        setTimeout(async () => {
            const sendResponse = await fetch('/api/newsletter/send', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ id }),
            });

            if (sendResponse.ok) {
                alert('Newsletter sent successfully!');
            } else {
                alert('Failed to send newsletter!');
            }
        }, 2);
    } catch (error) {
        alert('Failed to perform newsletter operation: ' + error);
    }
});*/

document.getElementById('newsletterForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    const id = document.getElementById('id').value;
    const subject = document.getElementById('subject').value;
    const content = document.getElementById('content').value;

    const newsletter = { id, subject, content };

    try {
        const setResponse = await fetch('/api/newsletter/set', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newsletter),
        });

        if (setResponse.ok) {
            alert('Newsletter set successfully!');

            const sendResponse = await fetch('/api/newsletter/send', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ id }),
            });

            if (sendResponse.ok) {
                alert('Newsletter sent successfully!');
            } else {
                alert('Failed to send newsletter!');
            }
        } else {
            alert('Failed to set newsletter!');
        }
    } catch (error) {
        alert('Failed to perform newsletter operation: ' + error);
    }
});