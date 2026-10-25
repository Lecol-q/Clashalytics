import { useNavigate } from "react-router-dom";
import { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [hasSearched, setHasSearched] = useState(false);
  const [tag, setTag] = useState("")
  const [playerStats, setPlayerStats] = useState(null);
  const navigate = useNavigate();
  const [loggedInUser, setLoggedInUser] = useState(null);
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);

  useEffect(() => {
      fetch("http://localhost:8080/me", {
          credentials: "include"
      })
          .then((response) => {
              if (response.status == 401) {
                  return null;
              }

              if (!response.ok) {
                  throw new Error(`HTTP error: ${response.status}`);
              }
              return response.json();
          })
          .then((user) => {
              setLoggedInUser(user);
              console.log(user);
          })
          .catch((err) => {
              console.error("Failed to check login session:", err);
          });
  }, []);
    const searchPlayer = () => {
        if (tag.trim() === "") {
            alert("Enter a valid tag");
            return;
        }

        const url = "http://localhost:8080/stats" +
            `?tag=${encodeURIComponent(tag.trim())}`;

        fetch(url)
            .then((response) => {
                if (!response.ok) {
                    throw new Error(`HTTP error: ${response.status}`);
                }
                return response.json();
            })
            .then((data) => {
                setPlayerStats(data);
                setHasSearched(true);
            })
            .catch((err) => {
                console.error(`Fetch problem: ${err.message}`);
            });
    };

  // this is the main render block
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

                {/* This is the main toolbar*/}
              <button
                  className="searchButton"
                  onClick={searchPlayer}
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

              <button
                  className="userButton"
                  onClick={() => setIsSidebarOpen(!isSidebarOpen)}
                  aria-label={"Login"}
                  title={"Login"}
              >
                  <svg
                      viewBox="0 0 24 24"
                      width="26"
                      height="26"
                      fill="none"
                      stroke="currentColor"
                      strokeWidth="1.8"
                      strokeLinecap="round"
                      strokeLinejoin="round"
                  >
                      <circle cx="12" cy="8" r="4" />
                      <path d="M5 21v-2a7 7 0 0 1 14 0v2" />
                  </svg>
              </button>
          </nav>
        </header>

          <div
              className={`sidebarOverlay ${isSidebarOpen ? "open" : ""}`}
              onClick={() => setIsSidebarOpen(false)}
          />

          <aside className={`accountSidebar ${isSidebarOpen ? "open" : ""}`}>
              <button
                  className="closeSidebar"
                  onClick={() => setIsSidebarOpen(false)}
              >
                  ✕
              </button>

              {loggedInUser ? (
                  <>
                      <h2>Account</h2>
                      <p>Username: {loggedInUser.username}</p>
                      <p>User ID: {loggedInUser.id}</p>
                  </>
              ) : (
                  <>
                      <h2>Welcome</h2>
                      <p>Log in to access your account.</p>
                      <button onClick={() => navigate("/login")}>
                          Log in
                      </button>
                  </>
              )}
          </aside>

          {/* This is the main dashboard */}

          <main className={`mainLayout ${hasSearched ? "searched" : ""}`}>
              {!hasSearched && (
                  <section className="heroSection">
                      <div className="heroContent">
                <span className="heroEyebrow">
                    YOUR CLASH ROYALE DASHBOARD
                </span>

                          <h2>All your stats in one place!</h2>

                          <p>
                              Search your player tag to explore your
                              trophies, battles, wins, and performance.
                          </p>

                          <div className="heroSearch">
                              <input
                                  type="text"
                                  placeholder="#PlayerTag"
                                  aria-label="Search player tag"
                                  value={tag}
                                  onChange={(e) => setTag(e.target.value)}
                                  onKeyDown={(e) => {
                                      if (e.key === "Enter") searchPlayer();
                                  }}
                              />

                              <button onClick={searchPlayer}>
                                  Search
                              </button>
                          </div>
                      </div>
                  </section>
              )}

              <aside className={`statsPanel ${hasSearched ? "visible" : ""}`}>
                  <div className="playerStatsInfo">
                      <h2><p className="playerName">{playerStats?.name}</p></h2>
                      <p>Trophies: {playerStats?.trophies}</p>
                      <p>Battle Count: {playerStats?.battleCount}</p>
                      <p>Wins: {playerStats?.wins}</p>
                      <p>Losses: {playerStats?.losses}</p>
                      <button
                          className="addPlayerButton"
                          onClick={() => {
                              if (!loggedInUser) {
                                  navigate("/login");
                                  return;
                              }

                              // We'll add the save-player API call here.
                              console.log("Add player:", playerStats?.tag);
                          }}
                      >
                          <span className="addPlayerIcon">+</span>
                          Save Player
                      </button>
                  </div>

                  <div className="winLossCircle">
                      <div
                          className="circlePlaceholder"
                          style={{
                              "--winrate": `${
                                  Number(playerStats?.wins) + Number(playerStats?.losses) > 0
                                      ? (Number(playerStats.wins) /
                                      (Number(playerStats.wins) + Number(playerStats.losses))) * 100
                                      : 0
                              }%`
                          }}
                      >
                <span>
                    {playerStats?.winrate != null
                        ? `${playerStats.winrate}%`
                        : "—"}
                </span>
                          <small>WIN RATE</small>
                      </div>
                  </div>
              </aside>
          </main>

      </div>
  );
}

export default App;
