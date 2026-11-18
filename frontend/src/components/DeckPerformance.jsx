
import React from "react";
import "./DeckPerformance.css";

function DeckPerformance({ player, onClose, initialView = "all" }) {
    const deckPerformances = player || [];

    const getWinRate = (deck) => {
        return deck.numOfBattle > 0
            ? (deck.wins / deck.numOfBattle) * 100
            : 0;
    };

    return (
        <div
            className="deckPerformanceBackdrop"
            onClick={onClose}
        >
            <div
                className="deckPerformanceWindow"
                onClick={(e) => e.stopPropagation()}
            >
                <div className="deckPerformanceHeader">
                    <div>
                        <h2>Deck Performance</h2>
                        <p>Analyze your recent deck performance</p>
                    </div>

                    <button
                        className="closeDeckPerformance"
                        onClick={onClose}
                    >
                        ✕
                    </button>
                </div>

                <div className="deckPerformanceBody">
                    <div className="performanceCard">
                        {deckPerformances.length > 0 ? (
                            deckPerformances.map((deck, index) => {
                                const winRate = getWinRate(deck);

                                return (
                                    <div
                                        className="performanceItem"
                                        key={index}
                                    >
                                        <div className="performanceRow">

                                            {/* Deck cards */}
                                            <div className="performanceDeckCards">
                                                <div className="deck-grid">
                                                    {deck.deck.map((card) => (
                                                        <div
                                                            className="battleDeckCard"
                                                            key={card.id}
                                                        >
                                                            <img
                                                                src={card.iconUrls?.medium}
                                                                alt={card.name}
                                                            />
                                                        </div>
                                                    ))}
                                                </div>
                                            </div>

                                            {/* Deck statistics */}
                                            <div className="performanceStats">
                                                <p>
                                                    <span>Battles</span>
                                                    <strong>{deck.numOfBattle}</strong>
                                                </p>

                                                <p>
                                                    <span>Wins</span>
                                                    <strong>{deck.wins}</strong>
                                                </p>

                                                <p>
                                                    <span>Losses</span>
                                                    <strong>{deck.loses}</strong>
                                                </p>
                                            </div>

                                            {/* Win rate circle */}
                                            <div className="winLossCircle">
                                                <div
                                                    className="circlePlaceholder"
                                                    style={{
                                                        "--winrate": `${winRate}%`
                                                    }}
                                                >
                                                    <span>
                                                        {winRate.toFixed(1)}%
                                                    </span>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                );
                            })
                        ) : (
                            <p>No deck performance data available.</p>
                        )}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default DeckPerformance;
