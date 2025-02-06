import { useEffect, useState } from "react";
import { getMetodoPagos } from "../services/metodoPagoServices";


export function useMetodoPago(){
    const [metodoPagos, setMetodoPagos] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        getMetodoPagos()
        .then((data) => {
            setMetodoPagos(data);
            setLoading(false);
        })
        .catch((error) => {
            setError(error);
            setLoading(false);
        });
    }, []);

    return { metodoPagos, loading, error };
}
