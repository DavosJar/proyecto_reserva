import { FaCarSide, FaTag, FaHashtag, FaCalendarAlt, FaUserFriends, FaCheckCircle, FaTimesCircle } from "react-icons/fa";
import { useVehiculos } from '../hooks/useVehiculos';

const VehiculoContainer: React.FC = () => {
    const { vehiculos, loading, error } = useVehiculos();

    if (loading) return <p className="text-center text-primary fw-bold">Cargando...</p>;
    if (error) return <p className="text-center text-danger fw-bold">Error: {error}</p>;

    return (
        <div className="container mt-5">
            <h1 className="text-center mb-4 text-primary d-flex justify-content-center align-items-center gap-2">
                <FaCarSide /> Listado de Vehículos
            </h1>
            <div className="table-responsive rounded-3 shadow-sm">
                <table className="table table-hover table-striped table-borderless text-center align-middle rounded-3">
                    <thead className="table-primary text-white rounded-3">
                    <tr>
                        <th><FaCarSide /> Modelo</th>
                        <th><FaTag /> Marca</th>
                        <th><FaHashtag /> Matrícula</th>
                        <th><FaCalendarAlt /> Año</th>
                        <th><FaUserFriends /> Pasajeros</th>
                        <th>Disponibilidad</th>
                    </tr>
                    </thead>
                    <tbody>
                    {vehiculos.map((vehiculo: any) => (
                        <tr key={vehiculo.id} className="rounded-3">
                            <td className="fw-semibold">{vehiculo.modelo}</td>
                            <td>{vehiculo.marca}</td>
                            <td className="text-uppercase">{vehiculo.matricula}</td>
                            <td>{vehiculo.yearFabricacion}</td>
                            <td>{vehiculo.capacidadPersonas}</td>
                            <td>
                                    <span
                                        className={`badge px-3 py-2 d-flex align-items-center gap-1 ${
                                            vehiculo.estadoVehiculo.toLowerCase() === "disponible"
                                                ? "text-success bg-success-subtle"
                                                : "text-danger bg-danger-subtle"
                                        }`}
                                    >
                                        {vehiculo.estadoVehiculo.toLowerCase() === "disponible" ? (
                                            <FaCheckCircle className="text-success" />
                                        ) : (
                                            <FaTimesCircle className="text-danger" />
                                        )}
                                        {vehiculo.estadoVehiculo}
                                    </span>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default VehiculoContainer;
