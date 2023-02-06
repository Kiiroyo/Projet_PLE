import React from "react";
// @ts-ignore
import { Marker, Popup } from "react-leaflet";
// @ts-ignore
import cameraIcon from "../assets/cameraIcon.png";
// @ts-ignore
import tubeIcon from "../assets/tubeIcon.png";
// @ts-ignore
import radarIcon from "../assets/radarIcon.png";
// @ts-ignore
import { Icon } from "leaflet";
// @ts-ignore
import { Typography } from "@mui/material";


type Props = {
    title: string;
    type: string;
    position: [number, number];
    description?: string;
};

// @ts-ignore
const CustomMarker = ({ title, type, position }) => {
    const cameraMarker = new Icon({
        iconUrl: cameraIcon,
        iconRetinaUrl: cameraIcon,
        popupAnchor: [-0, -0],
        iconSize: [30, 30],
    });

    const tubeMarker = new Icon({
        iconUrl: tubeIcon,
        iconRetinaUrl: tubeIcon,
        popupAnchor: [-0, -0],
        iconSize: [30, 30],
    });

    const radarMarker = new Icon({
        iconUrl: radarIcon,
        iconRetinaUrl: radarIcon,
        popupAnchor: [-0, -0],
        iconSize: [30, 30],
    });

    // @ts-ignore
    // @ts-ignore
    return (
        <Marker
            position={position}
            icon={
                type === "radar"
                    ? radarMarker
                    : type === "camera"
                    ? cameraMarker
                    : tubeMarker
            }
        >
            <Popup>
                <Typography
                    variant="body1"
                    fontWeight="bold"
                    textAlign="center"
                >
                    {title}
                </Typography>
                <Typography variant="body2" textAlign="center">
                    {type}
                </Typography>

            </Popup>
        </Marker>
    );
};

export default CustomMarker;
