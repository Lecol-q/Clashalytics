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
  const [savedPlayers, setSavedPlayers] = useState([]);

    const isPlayerSaved = savedPlayers.some(
        (player) => player.savedTag === playerStats?.tag
    );

    const loadSavedPlayers = () => {
        const url = "http://localhost:8080/retrieve-saved-players";
        fetch(url, {
            credentials: "include"
        })
            .then((response) => {
                if(!response.ok) {
                    throw new Error(`HTTP error: ${response.status}`);
                }
                return response.json();
            })
            .then((data) => {
                console.log("Saved players: ", data);
                setSavedPlayers(data);
            })
            .catch((err) => {
                console.error("Failed to fetch saved players:", err);
            });
    };

    const savePlayer = () => {
        const url = "http://localhost:8080/save-player" + `?tag=${encodeURIComponent(playerStats.tag)}`
        fetch(url, {
            method: 'POST',
            credentials: "include"
        })
            .then((response) => {
                if(!response.ok) {
                    throw new Error(`HTTP error: ${response.status}`);
                }
            })
            .then(() => {
                loadSavedPlayers();
            })
            .catch((err) => {
                console.error("Failed to save player:", err);
            });
    };

    const removePlayer = () => {
        const url = "http://localhost:8080/remove-player" + `?tag=${encodeURIComponent(playerStats.tag)}`
        fetch(url, {
            method: 'POST',
            credentials: "include"
        })
            .then((response) => {
                if(!response.ok) {
                    throw new Error(`HTTP error: ${response.status}`);
                }
            })
            .then(() => {
                loadSavedPlayers();
            })
            .catch((err) => {
                console.error("Failed to remove player:", err);
            });
    };

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
              if(user != null) {
                  loadSavedPlayers();
              }
              console.log(user);
          })
          .catch((err) => {
              console.error("Failed to check login session:", err);
          });
  }, []);

    const searchPlayer = (playerTag = tag) => {
        console.log("playerTag:", playerTag, typeof playerTag);
        if (playerTag.trim() === "") {
            alert("Enter a valid tag");
            return;
        }

        const url = "http://localhost:8080/stats" +
            `?tag=${encodeURIComponent(playerTag.trim())}`;

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
                  onClick={() => searchPlayer()}
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
              {loggedInUser ? (
                      <>
              <div className="sidebarHeader">
                  <div className="accountIdentity">
                      <div className="accountAvatar">
                          {loggedInUser?.username?.charAt(0).toUpperCase()}
                      </div>

                      <div className="accountDetails">
                          <span className="accountLabel">SIGNED IN AS</span>
                          <strong>{loggedInUser?.username}</strong>
                      </div>
                  </div>

                  <button
                      className="closeSidebar"
                      onClick={() => setIsSidebarOpen(false)}
                      aria-label="Close sidebar"
                  >
                      ✕
                  </button>
              </div>

              <div className="savedPlayersHeader">
                  <h3>Saved Players</h3>
                  <span className="savedCount">0</span>
              </div>

              <div className="savedPlayersList">
                  {savedPlayers.length === 0 ? (
                      <>
                        <strong>Your roster is empty</strong>
                        <p>Save a player to see them here.</p>
                      </>
                  ) : (
                        savedPlayers.map((player) => (
                            <div className="savedPlayerCard" key={player.id} onClick={() => searchPlayer(player.savedTag)}>
                                <strong className="savedPlayerName">
                                    {player.savedName}
                                </strong>

                                <span className="savedPlayerTag">
                                    {player.savedTag}
                                </span>
                            </div>
                        ))
                      )}
              </div>

              <div className="sidebarBottom">
                  <button
                      className="signOutButton"
                      onClick={async () => {
                          const response = await fetch("http://localhost:8080/logout", {
                              method: "POST",
                              credentials: "include"
                          });

                          if (response.ok) {
                              setLoggedInUser(null);
                              setSavedPlayers([]);
                              setIsSidebarOpen(false);
                              navigate("/");
                          }
                      }}
                  >
                      <span className="signOutIcon">↪</span>
                      Sign Out
                  </button>
              </div>
                      </>
              ) : (
                  <div className="sidebarLoggedOut">
                      <h3>Welcome to Clashalytics!</h3>
                      <p>Log in to save and manage your players.</p>
                      <button onClick={() => navigate("/login")}>
                          Log In
                      </button>
                  </div>
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

                              <button onClick={() => searchPlayer()}>
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

                              if(isPlayerSaved) {
                                  removePlayer();
                              } else {
                                  savePlayer();
                              }
                          }}
                      >
                          {isPlayerSaved ? "Remove Player" : "Save Player"}
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
                        ? `${playerStats.winrate}`
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
