import { useState } from "react";
import { saveMetodoPago } from "../services/metodoPagoServices";

export function useSaveMetodoPago() {
    const [metodoPago, setMetodoPago] = useState<any>(null); 
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<Error | null>(null);

    const save = async (metodoPago: any) => {
        setLoading(true);
        try {
            const data = await saveMetodoPago(metodoPago);
            setMetodoPago(data);
            setLoading(false);
        } catch (error: any) {
            setError(error);
            setLoading(false);
        }
    }
    return { metodoPago, loading, error, save };
}
