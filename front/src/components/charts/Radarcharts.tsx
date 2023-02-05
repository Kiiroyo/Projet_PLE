import React, { PureComponent } from "react";
import { useTheme } from "@mui/material/styles";
import {
    Radar,
    BarChart,
    PolarGrid,
    PolarAngleAxis,
    PolarRadiusAxis,
    ResponsiveContainer, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend,
} from "recharts";
import { EntryExit } from "../../services/entryExit";
import Typography from "@mui/material/Typography";


type Props = {
    width?: number;
    height?: number;
    data?: EntryExit[];
};

const RadarCharts = ({ width, height, data }: Props) => {
    const theme = useTheme();
    return (
        <>
            <Typography variant="body2" fontWeight="green">
                Entrée / Sortie par type
            </Typography>
            <BarChart
                width={width}
                height={height}
                cx="50%"
                cy="50%"
                outerRadius="80%"
                data={data}
            >
                <XAxis dataKey="type" />
                <YAxis />
                <CartesianGrid stroke="#ccc" strokeDasharray="5 5" />
                <Tooltip />
                <Legend />
                <Bar
                    dataKey="entry"
                    stroke={theme.palette.primary.main}
                    fill={theme.palette.primary.main}
                    fillOpacity={0.6}
                />
                <Bar
                    dataKey="exit"
                    stroke={theme.palette.warning.main}
                    fill={theme.palette.warning.main}
                    fillOpacity={0.6}
                />
            </BarChart>
        </>
    );
};

export default RadarCharts;
