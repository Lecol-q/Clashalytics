
import React from "react";
import "./TopThree.css";

function TopThree({ topThreePlayers = [] }) {

    return (
        <div className="topThreeContainer">
            <div className="leaderboardHeader">
                <h2>Top Players</h2>
            </div>

            <div className="leaderboardPodium">
                {topThreePlayers.map((player) => (
                    <div
                        key={player.tag}
                        className={`playerCard rank-${player.rank}`}
                    >
                        <div className="playerRank">
                            {player.rank === 1 && (
                                <span className="championCrown">♛</span>
                            )}
                            <span>#{player.rank}</span>
                        </div>

                        <h3 className="userName">{player.name}</h3>

                        <p className="clanName">
                            {player.clan?.name ?? "No Clan"}
                        </p>

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
