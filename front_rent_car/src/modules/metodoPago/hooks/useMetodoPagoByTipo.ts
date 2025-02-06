import { useState } from "react";
import { getMetodoPagoByTipo } from "../services/metodoPagoServices";

export function useMetodoPagoByTipo() {
    const [metodoPago, setMetodoPago] = useState<any>(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<Error | null>(null);

    const getMetodoPago = async (tipo: string) => {
        setLoading(true);
        try {
            const data = await getMetodoPagoByTipo(tipo);
            setMetodoPago(data);
            setLoading(false);
        } catch (error: any) {
            setError(error);
            setLoading(false);
        }
    }
    
    return { metodoPago, loading, error, getMetodoPago };
}