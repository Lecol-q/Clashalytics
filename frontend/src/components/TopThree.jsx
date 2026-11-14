
import React from "react";
import "./TopThree.css";
import BadgeImage from "../data/BadgeImage.jsx";

function TopThree({ topThreePlayers = [], onPlayerClick }) {

    const rankClasses = {
        1: "firstPlace",
        2: "secondPlace",
        3: "thirdPlace"
    };

    return (
        <div className="topThreeContainer" id="top-players">
            <div className="leaderboardHeader">
                <h2>Top Players</h2>
            </div>

            <div className="leaderboardPodium">
                {topThreePlayers.map((player) => (
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
                                <BadgeImage id={player.clan?.badgeId} />
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
    );
}

export default TopThree;
