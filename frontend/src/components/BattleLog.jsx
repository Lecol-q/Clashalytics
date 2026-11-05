import "./BattleLog.css";

function BattleLog({ battlelog }) {

    const battles = battlelog?.battleLog || [];

    return (
        <div className="battleLog">
            <h2>Recent Battles</h2>

            {battles.map((battle, index) => (
                <div className="battleCard" key={index}>
                    {/* Battle information goes here */}
                </div>
            ))}
        </div>
    );
}

export default BattleLog;