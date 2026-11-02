
import React from "react";

function CurrentDeck({ cards = [] }) {

    const averageElixir = cards.length
        ? (cards.reduce((total, card) => total + card.elixirCost, 0) / cards.length).toFixed(1)
        : "0.0";

    return (
        <div className="current-deck">
            <div className="deck-header">
                <h2>Current Deck</h2>
                <span>Average Elixir: {averageElixir}</span>
            </div>

            <div className="deck-grid">
                {cards.map((card) => (
                    <div className="deck-card" key={card.id}>
                        <img src={card.iconUrl} alt={card.name} />
                        <p>{card.name}</p>
                        <span>Level {card.level}</span>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default CurrentDeck;
