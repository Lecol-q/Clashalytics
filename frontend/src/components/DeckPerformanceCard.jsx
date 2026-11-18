import React from "react";
import "./DeckPerformance.css";

function DeckPerformance({ deckPerformances, onClose, initialView = "all" }) {
    const getWinRate = (deck) => {
        return deck.numOfBattle > 0
            ? (deck.wins / deck.numOfBattle) * 100
            : 0;
    };

    return (
        <div className="deckPerformanceBackdrop" onClick={onClose}>
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
                        {deckPerformances.map((deck, index) => (
                            <div className="performanceItem" key={index}>
                                <h3>Deck {index + 1}</h3>

                                <p>Wins: {deck.wins}</p>
                                <p>Losses: {deck.loses}</p>
                                <p>Battles: {deck.numOfBattle}</p>
                                <p>Win Rate: {getWinRate(deck).toFixed(1)}%</p>

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
                        ))}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default DeckPerformance;