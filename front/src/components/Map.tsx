import { MapContainer, TileLayer, TileLayerProps } from "react-leaflet";
import "leaflet/dist/leaflet.css";
import "leaflet/dist/images/marker-shadow.png";
import { useEffect, useRef, useState } from "react";
import { Box } from "@mui/system";
import CustomMarker from "./CustomMarker";
import data from "../data/posts";


type Props = {
    children?: React.ReactNode;
};

const Map = () => {

    const [mapState, setMapState] = useState({
        lat: 44.80416345,
        lng: -0.599976,
        zoom: 14,
    });
    const [firstRender, setFirstRender] = useState(true);
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition((position) => {
            setMapState({
                lat: position.coords.latitude,
                lng: position.coords.longitude,
                zoom: 6,
            });
        });
    }


    // Change the value of map-tiles class when theme changes


    const [markers, setMarkers] = useState(data);

    return (
        <Box className="w-full h-full rounded-md">
            <MapContainer
                id="map"
                center={[mapState.lat, mapState.lng]}
                zoom={mapState.zoom}
                scrollWheelZoom={true}
                style={{ height: "100%", width: "100%", borderRadius: "5px" }}
            >
                <TileLayer

                    attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                    url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                />
                {markers.map((marker) => (
                    <CustomMarker
                        key={marker.title}
                        title={marker.title}
                        type={marker.type}
                        position={[
                            marker.location.latitude,
                            marker.location.longitude,
                        ]} description={undefined}/>
                ))}
            </MapContainer>
        </Box>
    );
};

export default Map;

