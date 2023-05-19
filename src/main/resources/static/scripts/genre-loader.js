const halls = document.getElementById('genres');

fetch('/api/admins/films') 
  .then((response) => response.json())
  .then((data) => {
    halls.innerHTML = '';
    
    data.forEach(genre => {
      const option = document.createElement('option');
      option.value = genre.name;
      option.textContent = genre.name;
      halls.appendChild(option);
    });
  })
