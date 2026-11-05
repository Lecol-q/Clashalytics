import "./BattleLog.css";
import React from "react";

function BattleLog({battlelog}) {
    console.log("Battlelog prop: ", battlelog);
    const battles = battlelog?.battleLog || [];
    console.log("Battles array: ", battles);

    function battleResult(userTeam, opponent) {
        if (userTeam.crowns > opponent.crowns) {
            return "Victory";
        } else if (userTeam.crowns < opponent.crowns) {
            return "Defeat";
        } else {
            return "Draw";
        }
    }

    function trophySign(userTeam, opponent) {
        if (battleResult(userTeam, opponent) === "Victory" || battleResult(userTeam, opponent) === "Draw") {
            return "+";
        } else {
            return "-";
        }
    }

    return (
        <div className="battleLog">
            <h2>Recent Battles</h2>
            {battles.map((battle, index) => {
                const userTeam = battle.team?.[0];
                const opponent = battle.opponent?.[0];
                return (
                    <div className={`battleCard ${battleResult(userTeam, opponent).toLowerCase()}`} key={index}>

                        {/* battle heading */}
                        <div className="gameHeading">
                            <span>{battleResult(userTeam, opponent)}</span>
                            <span>{trophySign(userTeam, opponent)}{userTeam.trophyChange}</span>
                        </div>
                        {/* player information*/}
                        <div className="battlePlayers">
                            <div className="battleUser">
                                <h3>{userTeam?.name}</h3>
                                <p>{userTeam?.clan?.name}</p>
                                <div className="deck-grid">
                                    {userTeam.cards.map((card) => (
                                        <div className="battleDeckCard" key={card.id}>
                                            <img
                                                src={card.iconUrls?.medium}
                                                alt={card.name}
                                            />
                                        </div>
                                    ))}
                                </div>
                            </div>
                            <div className="battleOpponent">
                                <h3>{opponent?.name}</h3>
                                <p>{opponent?.clan?.name}</p>
                                <div className="deck-grid">
                                    {opponent.cards.map((card) => (
                                        <div className="battleDeckCard" key={card.id}>
                                            <img
                                                src={card.iconUrls?.medium}
                                                alt={card.name}
                                            />
                                        </div>
                                    ))}
                                </div>
                            </div>
                        </div>
                    </div>
                );
            })}
        </div>
    );
}

export default BattleLog;