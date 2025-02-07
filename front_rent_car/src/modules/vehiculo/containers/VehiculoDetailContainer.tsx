import { useVehiculoByMatricula } from "../hooks/useVehiculoByMatricula";
import { useParams } from "react-router-dom";
import { useEffect } from "react";
import { FaCarSide } from "react-icons/fa";

const VehiculoDetailContainer: React.FC = () => {
    const { matricula } = useParams();
    const { vehiculo, loading, error, getVehiculo } = useVehiculoByMatricula();

    useEffect(() => {
        if (matricula) { // Verifica si matricula existe antes de hacer la llamada
            getVehiculo(matricula);
        }
    }, [matricula]);

    if (loading) return <p className="text-center text-primary fw-bold">Cargando...</p>;
    if (error) {
        // @ts-ignore
        return <p className="text-center text-danger fw-bold">Error: {error.message}</p>;
    }

    // Verifica que vehiculo no sea null o undefined antes de renderizar
    if (!vehiculo) {
        return <p className="text-center text-warning">No se encontraron detalles del vehículo.</p>;
    }

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-8">
                    <div className="card shadow-lg rounded-3 p-4">
                        {/* Título pequeño y centrado en la parte superior de la tarjeta */}
                        <div className="card-header text-center">
                            <h5 className="text-primary mb-0 d-flex justify-content-center align-items-center gap-2">
                                <FaCarSide /> Detalle del Vehículo
                            </h5>
                        </div>
                        <div className="card-body">
                            <h5 className="card-title text-primary">{vehiculo.modelo}</h5>
                            <div className="row">
                                <div className="col-md-6">
                                    <p className="card-text">
                                        <span className="fw-bold">Marca:</span> {vehiculo.marca}
                                    </p>
                                    <p className="card-text">
                                        <span className="fw-bold">Matrícula:</span> {vehiculo.matricula}
                                    </p>
                                    <p className="card-text">
                                        <span className="fw-bold">Año de Fabricación:</span> {vehiculo.yearFabricacion}
                                    </p>
                                </div>
                                <div className="col-md-6">
                                    <p className="card-text">
                                        <span className="fw-bold">Capacidad de Personas:</span> {vehiculo.capacidadPersonas}
                                    </p>
                                    <p className="card-text">
                                        <span className="fw-bold">Estado:</span> {vehiculo.estadoVehiculo}
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default VehiculoDetailContainer;
