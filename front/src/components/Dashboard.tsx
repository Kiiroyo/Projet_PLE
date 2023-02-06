// @ts-ignore
// @ts-ignore
import {
    ButtonGroup,
    IconButton,
    Typography,
    useTheme,
    Select,
    MenuItem,
} from "@mui/material";
// @ts-ignore
import { Box } from "@mui/system";
import React, { useEffect } from "react";
import Card from "./Card";
import Map from "./Map";

type Props = {
    onThemeChange: (theme: string) => void;
};

const Dashboard = () => {


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

            </Box>

            <Box id="aze" className="flex space-x-3 w-full h-full">
                <Box className="w-3/4">
                    <Card fullScreen={false}>
                        <Map />
                    </Card>
                </Box>

            </Box>{" "}


        </Box>
    );
};

export default Dashboard;
