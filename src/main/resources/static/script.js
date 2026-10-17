const submit = document.querySelector("#submit")
const tag = document.querySelector("#tag")
const stats = document.querySelector("#stats")

submit.addEventListener("click", () => {
    const playerTag = tag.value;
   makeRequest(playerTag);
});

function makeRequest(tag) {
    const url = "http://localhost:8080/stats" + `?tag=${encodeURIComponent(tag)}`;
    fetch(url)
        .then((response) => {
            if(!response.ok) {
                throw new Error(`HTTP error: ${response.status}`);
            }
            return response.text();
        })
        .then((playerStats) => {
            stats.textContent = playerStats;
        })
        .catch((err) => console.error(`Fetch problem: ${err.message}`));
}