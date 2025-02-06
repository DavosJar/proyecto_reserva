import React, { useState } from "react";
import { useSaveMetodoPago } from "../hooks/useSaveMetodoPago";
import { FaCreditCard } from "react-icons/fa"; 

const MetodoPagoFormContainer: React.FC = () => {
    const [metodoPago, setMetodoPago] = useState<any>({
        tipo: "",
    });

    const { save, loading, error } = useSaveMetodoPago();

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setMetodoPago({
            ...metodoPago,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        console.log("Datos del método de pago:", metodoPago);
        save(metodoPago);
    };

    return (
        <div className="container mt-5 d-flex justify-content-center">
            <div className="card shadow-lg p-4" style={{ maxWidth: "600px", borderRadius: "10px", backgroundColor: "#f8f9fa" }}>
                <h1 className="text-center mb-4 text-primary">
                    Formulario de Método de Pago
                </h1>
                <form onSubmit={handleSubmit}>
                    <div className="row">
                        <div className="col-md-12">
                            <div className="mb-3">
                                <label htmlFor="tipo" className="form-label">
                                    <FaCreditCard className="me-2" /> Tipo de Método de Pago
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="tipo"
                                    name="tipo"
                                    value={metodoPago.tipo}
                                    onChange={handleChange}
                                    placeholder="Ej: Tarjeta de Crédito, PayPal, Efectivo"
                                />
                            </div>
                        </div>
                    </div>
                    <button type="submit" className="btn btn-primary w-100" style={{ borderRadius: "8px" }}>
                        Guardar Método de Pago
                    </button>
                </form>
                {loading && <p className="text-center text-primary fw-bold mt-3">Guardando...</p>}
                {error && <p className="text-center text-danger fw-bold mt-3">Error: {error.message}</p>}
            </div>
        </div>
    );
};

export default MetodoPagoFormContainer;