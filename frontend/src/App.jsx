
import { useState } from 'react';
import './App.css';

function App() {
  const [hasSearched, setHasSearched] = useState(false);
  const [tag, setTag] = useState("")
  const [playerStats, setPlayerStats] = useState(null)


  return (
      <div className={`dashboard ${hasSearched ? 'searched' : ''}`}>
        <header className="toolBar">

          <h1 className="brand">
            <svg
                viewBox="0 0 24 24"
                width="28"
                height="28"
                fill="none"
                stroke="#f6c85f"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
            >
              <path d="m2 7 5 5 5-8 5 8 5-5-2 13H4L2 7Z" />
            </svg>
            <span>Clashalytics</span>
          </h1>


          <nav className="navActions">
            <div className="searchBox">
              <input
                  type="text"
                  placeholder="#PlayerTag"
                  aria-label="Player tag"
                  value={tag}
                  onChange={e => setTag(e.target.value)}
              />

              <button
                  className="searchButton"
                  onClick={() =>  {
                    if(tag.trim() === "") {
                      alert("Enter a valid tag")
                      return;
                    }
                    const url = "http://localhost:8080/stats" + `?tag=${encodeURIComponent(tag)}`;
                    fetch(url)
                        .then((response) => {
                          if(!response.ok) {
                            throw new Error(`HTTP error: ${response.status}`);
                          }
                          return response.json();
                        })
                        .then((playerStats) => {
                          setPlayerStats(playerStats)
                          console.log(playerStats)
                        })
                        .catch((err) => console.error(`Fetch problem: ${err.message}`));

                    setHasSearched(true)
                  }}
                  aria-label="Search player"
              >
                <svg
                    viewBox="0 0 24 24"
                    width="20"
                    height="20"
                    fill="none"
                    stroke="currentColor"
                    strokeWidth="2"
                    strokeLinecap="round"
                    strokeLinejoin="round"
                >
                  <circle cx="11" cy="11" r="7" />
                  <path d="m16 16 4 4" />
                </svg>
              </button>
            </div>
          </nav>
        </header>

        <main className="mainLayout">
          <section className="characterPanel">
            <h2>All Your Stats in One Place</h2>
            <p>Search for a player to see their stats.</p>

            <div className="characterPlaceholder">
              <span>Character Artwork</span>
            </div>
          </section>

          <aside className="statsPanel">
            <h2>Player Stats</h2>
            <p>{playerStats?.name}</p>
            <p>Trophies: {playerStats?.trophies}</p>
            <p>Battle Count: {playerStats?.battleCount}</p>
            <p>Wins: {playerStats?.wins}</p>
            <p>Losses: {playerStats?.losses}</p>
            <p>Winrate: {playerStats?.winrate}</p>
          </aside>
        </main>
      </div>
  );
}

export default App;
