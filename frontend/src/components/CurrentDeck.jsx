import React from "react";
import "./CurrentDeck.css";

function CurrentDeck({ player }) {
    const currentDeck = player?.currentDeck || [];

    return (
        <div className="current-deck">
            <h2>Current Deck</h2>

            <div className="deck-grid">
                {currentDeck.map((card) => (
                    <div className="deck-card" key={card.id}>
                        <img
                            src={card.iconUrls?.medium}
                            alt={card.name}
                        />
                    </div>
                ))}
            </div>
        </div>
    );
}

export default CurrentDeck;