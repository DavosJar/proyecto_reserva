import { useState } from "react";
import { getVehiculoByMatricula } from "../services/vehiculoServices";

export function useVehiculoByMatricula() {
    const [vehiculo, setVehiculo] = useState<any>(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<Error | null>(null);

    const getVehiculo = async (matricula: string) => {
        setLoading(true);
        try {
            const data = await getVehiculoByMatricula(matricula);
            setVehiculo(data);
            setLoading(false);
        } catch (error: any) {
            setError(error);
            setLoading(false);
        }
    }

    return { vehiculo, loading, error, getVehiculo };
}