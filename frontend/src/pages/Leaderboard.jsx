import "./Leaderboard.css"
import BadgeImage from "../data/BadgeImage.jsx";
import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import NavBar from "../components/NavBar.jsx";

function Leaderboard() {
    const [topGlobalPlayers, setTopGlobalPlayers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [tag, setTag] = useState("")
    const [isSidebarOpen, setIsSidebarOpen] = useState(false);
    const searchPlayerDashboard = (playerTag = tag) => {
        searchPlayer(playerTag);
    };

    const navigate = useNavigate();

    useEffect(() => {
        const fetchLeaderboard = async () => {
            try {
                setLoading(true);
                setError(null);

                const url = `${import.meta.env.VITE_API_URL}/global-leaderboard`;
                const response = await fetch(url);

                if (!response.ok) {
                    throw new Error(`HTTP error: ${response.status}`);
                }

                const data = await response.json();

                setTopGlobalPlayers(data.items);
            } catch (err) {
                console.error(`Fetch problem: ${err.message}`);
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };
        fetchLeaderboard();
    }, []);

    const rankClasses = {
        1: "firstPlace",
        2: "secondPlace",
        3: "thirdPlace"
    };

    const onPlayerClick = (tag) => {
        navigate("/", { state: { playerTag: tag } });
    };

    if (loading) return <p>Loading leaderboard...</p>;
    if (error) return <p>Unable to load leaderboard: {error}</p>;



    return (
        <div className="dashboard">
        <NavBar
            tag={tag}
            setTag={setTag}
            searchPlayerDashboard={searchPlayerDashboard}
            setIsSidebarOpen={setIsSidebarOpen}

        />

        <div className="topThreeContainer" id="top-players">
            <div className="leaderboardHeader">
                <h2>Top 100 Global Players</h2>
            </div>

            <div className="leaderboardPodium">
                {topGlobalPlayers.map((player) => (
                    <div
                        key={player.tag}
                        className={`playerCard ${rankClasses[player.rank] || ""}`}
                        onClick={() => onPlayerClick(player.tag)}
                    >
                        <div className="playerRank">
                            {player.rank === 1 && (
                                <span className="championCrown"></span>
                            )}
                            <span>{player.rank}</span>
                        </div>

                        <div className="playerIdentity">
                            <div className="playerAvatar">
                                <BadgeImage id={player.clan?.badgeId}/>
                            </div>
                        </div>

                        <div className="playerInfo">
                            <h3 className="userName">{player.name}</h3>
                            <h4 className="userTag">{player.tag}</h4>
                            <p className="clanName">
                                {player.clan?.name ?? "No Clan"}
                            </p>
                        </div>

                        <div className="playerElo">
                            <strong>{player.eloRating}</strong>
                        </div>
                    </div>
                ))}
            </div>
        </div>
        </div>
    );
}

export default Leaderboard;
