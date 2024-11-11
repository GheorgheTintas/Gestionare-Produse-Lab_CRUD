document.addEventListener('DOMContentLoaded', function() {
    const produseList = document.getElementById('produseList');
    const produsForm = document.getElementById('produsForm');

    // Obține toate produsele la încărcarea paginii
    fetchProduse();

    // Adaugă un produs
    produsForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const produs = {
            nume: document.getElementById('nume').value,
            pret: document.getElementById('pret').value,
            descriere: document.getElementById('descriere').value
        };

        // Trimite produsul către API
        fetch('http://localhost:8080/api/produse', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(produs)
        })
            .then(response => response.json())
            .then(data => {
                alert('Produsul a fost adăugat!');
                fetchProduse(); // Actualizează lista cu produse
                produsForm.reset(); // Resetează formularul
            })
            .catch(error => {
                console.error('Eroare la adăugarea produsului:', error);
            });
    });

    // Funcția pentru a obține produsele
    function fetchProduse() {
        fetch('http://localhost:8080/api/produse')
            .then(response => response.json())
            .then(produse => {
                produseList.innerHTML = ''; // Golește lista existentă
                produse.forEach(produs => {
                    const li = document.createElement('li');
                    li.textContent = `${produs.nume} - ${produs.pret} RON - ${produs.descriere}`;
                    produseList.appendChild(li);
                });
            })
            .catch(error => {
                console.error('Eroare la obținerea produselor:', error);
            });
    }
});
