import React, { useState } from "react";
import { useSaveVehiculo } from "../hooks/useSaveVehiculo";
import { FaCar, FaCalendarAlt, FaUsers } from "react-icons/fa"; // Iconos de Font Awesome

const VehiculoFormContainer: React.FC = () => {
    const [vehiculo, setVehiculo] = useState<any>({
        modelo: "",
        marca: "",
        matricula: "",
        yearFabricacion: "",
        capacidadPersonas: "",
    });

    const { save, loading, error } = useSaveVehiculo();

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setVehiculo({
            ...vehiculo,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        console.log("Datos del vehículo:", vehiculo);
        save(vehiculo);
    };

    return (
        <div className="container mt-5 d-flex justify-content-center">
            <div className="card shadow-lg p-4" style={{ maxWidth: "600px", borderRadius: "10px", backgroundColor: "#f8f9fa" }}>
                <h1 className="text-center mb-4 text-primary">
                    Formulario de Vehículos
                </h1>
                <form onSubmit={handleSubmit}>
                    <div className="row">
                        <div className="col-md-6">
                            <div className="mb-3">
                                <label htmlFor="marca" className="form-label">
                                    <FaCar className="me-2" /> Marca
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="marca"
                                    name="marca"
                                    value={vehiculo.marca}
                                    onChange={handleChange}

                                />
                            </div>
                            <div className="mb-3">
                                <label htmlFor="modelo" className="form-label">
                                    <FaCar className="me-2" /> Modelo
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="modelo"
                                    name="modelo"
                                    value={vehiculo.modelo}
                                    onChange={handleChange}

                                />
                            </div>
                            <div className="mb-3">
                                <label htmlFor="matricula" className="form-label">
                                    Matrícula
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="matricula"
                                    name="matricula"
                                    value={vehiculo.matricula}
                                    onChange={handleChange}

                                />
                            </div>
                        </div>
                        <div className="col-md-6">
                            <div className="mb-3">
                                <label htmlFor="yearFabricacion" className="form-label">
                                    <FaCalendarAlt className="me-2" /> Año de Fabricación
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="yearFabricacion"
                                    name="yearFabricacion"
                                    value={vehiculo.yearFabricacion}
                                    onChange={handleChange}
                                />
                            </div>
                            <div className="mb-3">
                                <label htmlFor="capacidadPersonas" className="form-label">
                                    <FaUsers className="me-2" /> Capacidad de Personas
                                </label>
                                <input
                                    type="number"
                                    className="form-control"
                                    id="capacidadPersonas"
                                    name="capacidadPersonas"
                                    value={vehiculo.capacidadPersonas}
                                    onChange={handleChange}
                                />
                            </div>
                        </div>
                    </div>
                    <button type="submit" className="btn btn-primary w-100" style={{ borderRadius: "8px" }}>
                        Guardar Vehículo
                    </button>
                </form>
                {loading && <p className="text-center text-primary fw-bold mt-3">Guardando...</p>}
                {error && <p className="text-center text-danger fw-bold mt-3">Error: {error.message}</p>}
            </div>
        </div>
    );
};

export default VehiculoFormContainer;

