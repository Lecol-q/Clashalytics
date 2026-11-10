import "./DeckPerformanceCard.css"
import React from "react";
function DeckPerformanceCard({ deckPerformances }) {
    console.log(deckPerformances);

    const getWinRate = (deck) => {
        return deck.battlesPlayed > 0
            ? (deck.wins / deck.battlesPlayed) * 100
            : 0;
    };

    const bestDeck = [...deckPerformances].sort(
        (a, b) => getWinRate(b) - getWinRate(a)
    )[0];

    const worstDeck = [...deckPerformances].sort(
        (a, b) => getWinRate(a) - getWinRate(b)
    )[0];

    return (
        <div className="performanceCard">
            {deckPerformances.map((deck, index) => (
                <div key={index} className="performanceItem">
                    <h3>Deck {index + 1}</h3>

                    <p>Wins: {deck.wins}</p>
                    <p>Losses: {deck.loses}</p>
                    <p>Battles: {deck.numOfBattle}</p>

                    <div className="deck-grid">
                        {deck.deck.map((card) => (
                            <div className="battleDeckCard" key={card.id}>
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
    )
};

export default DeckPerformanceCard;