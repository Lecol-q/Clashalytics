import "./PlayerBanner.css"
import {useNavigate} from "react-router-dom";
import { useState } from "react";
import TrophyChart from "./TrophyChart.jsx";
import PlayerStats from "./PlayerStats.jsx";
function PlayerBanner({ player, loggedInUser, isPlayerSaved, savePlayer, removePlayer, chartData}) {

    const navigate = useNavigate();
    const [isExpanded, setIsExpanded] = useState(false);
    if(!player) return null;

    const deckPerformances = player.deckPerformances || [];

    const getWinRate = (deck) => {
        if (deck.numsOfBattle === 0) return 0;

        return (deck.wins / deck.numOfBattle) * 100;
    };

    const sortedDecks = [...deckPerformances].sort(
        (a, b) => getWinRate(b) - getWinRate(a)
    );

    const bestDeck = sortedDecks[0];
    const worstDeck = sortedDecks[sortedDecks.length - 1];

    return (
        <section className="playerBanner">

            <div className="playerIdentity">
                <div className="playerAvatar">
                    {/* Player avatar */}
                </div>

                <div className="playerInfo">
                    <h2>{player.name}</h2>
                    <p>{player.tag}</p>
                    <span>{player.clan?.name || "No Clan"}</span>
                </div>
            </div>

            <div className="playerLevel">
                <span>King Level</span>
                <h3>{player.kingTowerLevel}</h3>
            </div>

            <div className="playerTrophies">
                <span>Trophies</span>
                <h3>{player.trophies}</h3>
            </div>

            <div className="playerExtraStats">
                <div className="playerStat">
                    <span>Account Level</span>
                    <strong>65</strong>
                </div>

                <div className="playerStat">
                    <span>Total Wins</span>
                    <strong>{player.wins}</strong>
                </div>
            </div>
            <div className="playerActions">
                <button className="addPlayerButton"
                        onClick={() => {
                            if (!loggedInUser) {
                                navigate("/login");
                                return;
                            }

                            if (isPlayerSaved) {
                                removePlayer(player.tag);
                            } else {
                                savePlayer(player.tag);
                            }
                        }}
                >
                    {isPlayerSaved ? "Remove Player" : "Save Player"}
                </button>
            </div>

            <button
                className="bannerExpandButton"
                onClick={() => setIsExpanded(!isExpanded)}
                aria-expanded={isExpanded}
            >
                {isExpanded ? "⌃" : "⌄"}
            </button>

            <div className={`expandedTrophyChart ${isExpanded ? "expanded" : ""}`}>
                <TrophyChart data={chartData} />
                <div className="bestWorstDecks">
                    {bestDeck && (
                        <div className="bestDeck">
                            <h3>Best Performing Deck</h3>
                            <p>Win Rate: {getWinRate(bestDeck).toFixed(1)}%</p>

                            <div className="deck-grid-banner">
                                {bestDeck.deck.map((card) => (
                                    <img
                                        key={card.id}
                                        src={card.iconUrls?.medium}
                                        alt={card.name}
                                    />
                                ))}
                            </div>
                        </div>
                    )}

                    {worstDeck && (
                        <div className="worstDeck">
                            <h3>Worst Performing Deck</h3>
                            <p>Win Rate: {getWinRate(worstDeck).toFixed(1)}%</p>

                            <div className="deck-grid-banner">
                                {worstDeck.deck.map((card) => (
                                    <img
                                        key={card.id}
                                        src={card.iconUrls?.medium}
                                        alt={card.name}
                                    />
                                ))}
                            </div>
                        </div>
                    )}
                </div>
            </div>
        </section>
    );
}

export default PlayerBanner;