import { Button, IconButton, Modal, Typography } from "@mui/material";
import Box from "@mui/material/Box";
import FullscreenIcon from "@mui/icons-material/Fullscreen";
import { width } from "@mui/system";
import React from "react";
type Props = {
    /// <reference path="" />
    children?: React.ReactElement;
    fullScreen?: boolean;
    chart?: React.FC;
};

const Card = ({ children, fullScreen = true }: Props) => {
    const [open, setOpen] = React.useState(false);
    return (
        <Box
            className="h-full rounded-md"
            sx={{
                backgroundColor: "background.paper",
            }}
        >
            {fullScreen && (
                <IconButton
                    sx={{
                        position: "relative",
                        top: "0",
                        left: "0",
                    }}
                    onClick={() => setOpen(true)}
                    size="small"
                >
                    <FullscreenIcon />
                </IconButton>
            )}
            <Modal open={open}>
                <Box
                    className="flex flex-col justify-between items-center p-4 rounded-md filter drop-shadow-xl"
                    sx={{
                        position: "absolute",
                        top: "50%",
                        left: "50%",
                        width: "70vw",
                        height: "70vh",
                        transform: "translate(-50%, -50%)",
                        backgroundColor: "background.paper",
                        opacity: 0.9,
                    }}
                >
                    <>

                        <Button
                            variant="contained"
                            onClick={() => setOpen(false)}
                            size="small"
                        >
                            <Typography variant="body2">Close</Typography>
                        </Button>
                    </>
                </Box>
            </Modal>

            {children && children}
        </Box>
    );
};

export default Card;