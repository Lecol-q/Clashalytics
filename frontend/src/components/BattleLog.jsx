import "./BattleLog.css";
import React from "react";
import trophyIcon from "../assets/trophy.png";
import blueCrown from "../assets/blue_crown.png";
import redCrown from "../assets/red_crown.png";

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
        }
    }

    function gameModeType(type) {
        if(type === "pathOfLegend") {
            return "Ranked Mode";
        }
        else if(type === "trail") {
            return "Trophy Road";
        }
        else if(type === "friendly") {
            return "Friendly"
        }
    }

    return (
        <div className="battleLog">
            <h2>Recent Battles</h2>
            {battles.map((battle, index) => {
                const userTeam = battle.team?.[0];
                const opponent = battle.opponent?.[0];
                const type = battle.type;
                return (
                    <div className={`battleCard ${battleResult(userTeam, opponent).toLowerCase()}`} key={index}>

                        {/* battle heading */}
                        <div className="gameHeading">
                            <span>{gameModeType(type)}</span>

                            <span className="battleScore">
                                <img className="blueCrown" src={blueCrown}/>

                                <span>{userTeam.crowns} {battleResult(userTeam, opponent)} {opponent.crowns}</span>

                                <img className="redCrown" src={redCrown}/>
                            </span>

                            <span className="trophies">
                                <img className="trophyIcon" src={trophyIcon}/>
                                {trophySign(userTeam, opponent)}
                                {userTeam.trophyChange}
                            </span>
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