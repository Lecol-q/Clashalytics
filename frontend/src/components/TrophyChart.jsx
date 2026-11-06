import { LineChart, Line, XAxis, YAxis, Tooltip, ResponsiveContainer } from "recharts";
import "./TrophyChart.css";

function TrophyChart({ data }) {
    return(
        <div className="trophyChart">
            <h2>Trophy Progression (30 Games)</h2>

            <ResponsiveContainer width="100%" height={100}>
                <LineChart data={data}>
                    <XAxis dataKey="battle" />
                    <YAxis />
                    <Tooltip />
                    <Line
                        type="monotone"
                        dataKey="trophies"
                        stroke="#f6c85f"
                        strokeWidth={2}
                        dot={false}
                    />
                </LineChart>
            </ResponsiveContainer>
        </div>
    );
}

export default TrophyChart;