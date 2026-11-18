import React, {useState} from "react";
import "./CurrentDeck.css";
import DeckPerformance from "./DeckPerformance.jsx";

function CurrentDeck({ player }) {
    const [showDeckPerformance, setShowDeckPerformance] = useState(false);

    const currentDeck = player?.currentDeck || [];

    return (
        <>
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

        <div className="viewDecksContainer">
            <button
                className="viewDecks"
                onClick={() => setShowDeckPerformance(true)}
            >
                View More
            </button>
        </div>

            {showDeckPerformance && (
                <DeckPerformance
                    player={player.deckPerformances}
                    onClose={() => setShowDeckPerformance(false)}
                />
            )}
        </>
    );
}

export default CurrentDeck;