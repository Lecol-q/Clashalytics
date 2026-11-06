import {useNavigate} from "react-router-dom";
import "./PlayerStats.css";

function PlayerStats({player}) {
    const playerStats = player;

    return (
        <aside className={`statsPanel visible`}>
            <div className="playerStatsInfo">
                <h2><p className="playerName">{playerStats?.name}</p></h2>
                <p>Trophies: {playerStats?.trophies}</p>
                <p>Battle Count: {playerStats?.battleCount}</p>
                <p>Wins: {playerStats?.wins}</p>
                <p>Losses: {playerStats?.losses}</p>
            </div>

            <div className="winLossCircle">
                <div
                    className="circlePlaceholder"
                    style={{
                        "--winrate": `${Number(playerStats?.wins) + Number(playerStats?.losses) > 0 ? (Number(playerStats.wins) / (Number(playerStats.wins) + Number(playerStats.losses))) * 100 : 0}%`
                    }}
                >
                <span>
                    {playerStats?.winrate != null ? `${playerStats.winrate}` : "—"}
                </span>
                    <small>WIN RATE</small>
                </div>
            </div>
        </aside>
    );
}

export default PlayerStats;