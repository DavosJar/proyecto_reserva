import { useState } from "react";
import { saveVehiculo } from "../services/vehiculoServices";

export function useSaveVehiculo() {
    const [vehiculo, setVehiculo] = useState<any>(null); // Puedes añadir el tipo de vehiculo si lo deseas
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<Error | null>(null); // Tipo explícito para el error

    const save = async (vehiculo: any) => {
        setLoading(true);
        try {
            const data = await saveVehiculo(vehiculo);
            setVehiculo(data);
            setLoading(false);
        } catch (error: any) { // Tipar el error aquí también
            setError(error); // Aquí ya no deberías tener problemas
            setLoading(false);
        }
    }

    return { vehiculo, loading, error, save };
}