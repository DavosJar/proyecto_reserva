import { useEffect, useState } from "react";
import { getVehiculos } from "../services/vehiculoServices";

export function useVehiculos(){

    const [vehiculos, setVehiculos] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        getVehiculos()
        .then((data) => {
            setVehiculos(data);
            setLoading(false);
        })
        .catch((error) => {
            setError(error);
            setLoading(false);
        });
    }, []);

    return { vehiculos, loading, error };
}





