import {
    ButtonGroup,
    IconButton,
    Typography,
    useTheme,
    Select,
    MenuItem,
} from "@mui/material";
import { Box } from "@mui/system";
import React, { useEffect } from "react";
import Card from "./Card";
import Map from "./Map";

import BarChartExample from "./charts/Barcharts";
import LightModeIcon from "@mui/icons-material/LightMode";
import DarkModeIcon from "@mui/icons-material/DarkMode";
import RadarChart from "./charts/Radarcharts";
import SpeedChart from "./charts/SpeedChart";
import {
    getAllDirections,
    getDataByDirection,
} from "../services/averageTrafficByHour";
import { getDataByDirectionDate } from "../services/averageTrafficByDate";
import {
    getAllDates,
    getPostsByDate,
} from "../services/numberOfVehiclesPerPost";
import { getEntryExitByDate } from "../services/entryExit";

type Props = {
    onThemeChange: (theme: string) => void;
};

const Dashboard = () => {
    const [date, setDate] = React.useState(new Date().toLocaleDateString());
    const [value, setValue] = React.useState<Date | null>(new Date());
    const availableDates = getAllDates();
    const [selectedDate, setSelectedDate] = React.useState<string>(
        availableDates[0]
    );



    const [direction, setDirection] = React.useState("vers BEC");

    const [entryExit, setEntryExit] = React.useState(
        getEntryExitByDate(selectedDate)
    );

    const [VehiclesPerDate, setVehiclesPerDate] = React.useState(
        getPostsByDate(selectedDate)
    );

    const [trafficDataByDay, setTrafficDataByDay] = React.useState(
        getDataByDirectionDate(direction)
    );

    const [trafficDataByHour, setTrafficDataByHour] = React.useState(
        getDataByDirection(direction)
    );
    const directions = getAllDirections();



    return (
        <Box className="flex flex-col space-y-2 h-full w-full">
            <Box
                className="flex justify-between items-center rounded-md p-3 w-full"
                sx={{
                    backgroundColor: "background.paper",
                }}
            >
                <Typography variant="h6" color="primary" fontWeight="bold">
                    Traffic Analyser
                </Typography>





                <Box className="flex justify-center items-center space-x-2">
                    <Select
                        size="small"
                        value={selectedDate}
                        onChange={(e) => {
                            setSelectedDate(e.target.value);
                            setVehiclesPerDate(getPostsByDate(e.target.value));
                            setEntryExit(getEntryExitByDate(e.target.value));
                        }}
                    >
                        {availableDates.map((date) => (
                            <MenuItem value={date}>{date}</MenuItem>
                        ))}
                    </Select>
                    <Select
                        size="small"
                        value={direction}
                        onChange={(e) => {
                            setDirection(e.target.value);
                            setTrafficDataByHour(
                                getDataByDirection(e.target.value)
                            );
                            setTrafficDataByDay(
                                getDataByDirectionDate(e.target.value)
                            );
                        }}
                    >
                        {directions.map((direction) => (
                            <MenuItem value={direction}>{direction}</MenuItem>
                        ))}
                    </Select>
                </Box>


            </Box>

            <Box id="aze" className="flex space-x-3 w-full h-full">
                <Box className="w-3/4">
                    <Card fullScreen={false}>
                        <Map />
                    </Card>
                </Box>

            </Box>{" "}

            <Box className="flex space-x-3 w-full md:h-2/5 h-1/5">

                <Box className="w-1/4">
                    <Card chart={SpeedChart} />
                </Box>

                <Box className="w-1/4">
                    <Card chart={BarChartExample} data={trafficDataByDay} />
                </Box>

                <Box className="w-1/4">
                    <Card chart={RadarChart} data={entryExit} />
                </Box>
            </Box>

        </Box>
    );
};

export default Dashboard;
