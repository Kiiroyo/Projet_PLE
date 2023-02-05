import React, { useEffect, useMemo } from "react";
import "./App.css";
import { ThemeProvider, createTheme } from "@mui/material/styles";
import CssBaseline from "@mui/material/CssBaseline";
import { Box } from "@mui/system";
import Dashboard from "./components/Dashboard";
const App = () => {

    const theme = useMemo(
        () =>
            createTheme({
                typography: {
                    fontFamily: "Poppins",
                },
            }),
        []
    );

    return (
        <ThemeProvider theme={theme}>
            <CssBaseline />
            <Box>
                <Box
                    sx={{
                        display: "flex",
                        flexDirection: "row",
                    }}
                >
                    <Box
                        className="h-screen"
                        sx={{
                            flexGrow: 1,
                            padding: 1,
                        }}
                    >
                        <Dashboard/>
                    </Box>
                </Box>
            </Box>
        </ThemeProvider>
    );
};
export default App;
