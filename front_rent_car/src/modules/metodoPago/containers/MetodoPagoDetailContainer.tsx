import { useMetodoPagoByTipo } from "../hooks/useMetodoPagoByTipo";
import { useParams } from "react-router-dom";
import { useEffect } from "react";
import { FaCreditCard } from "react-icons/fa";

const MetodoPagoDetailContainer: React.FC = () => {
    const { tipo } = useParams(); // Obtén el parámetro "tipo" de la URL
    const { metodoPago, loading, error, getMetodoPago } = useMetodoPagoByTipo();

    useEffect(() => {
        if (tipo) { // Verifica si "tipo" existe antes de hacer la llamada
            getMetodoPago(tipo);
        }
    }, [tipo]);

    if (loading) return <p className="text-center text-primary fw-bold">Cargando...</p>;
    if (error) {
        return <p className="text-center text-danger fw-bold">Error: {error.message}</p>;
    }

    // Verifica que "metodoPago" no sea null o undefined antes de renderizar
    if (!metodoPago) {
        return <p className="text-center text-warning">No se encontraron detalles del método de pago.</p>;
    }

    return (
        <div className="container d-flex justify-content-center align-items-center vh-100">
            <div className="row justify-content-center w-100">
                <div className="col-md-8">
                    <div className="card shadow-lg rounded-3 p-4">
                        {/* Título pequeño y centrado en la parte superior de la tarjeta */}
                        <div className="card-header text-center">
                            <h5 className="text-primary mb-0 d-flex justify-content-center align-items-center gap-2">
                                <FaCreditCard /> Detalle del Método de Pago
                            </h5>
                        </div>
                        <div className="card-body text-center">
                            <h5 className="card-title text-primary">{metodoPago.tipo}</h5>
                            <div className="row justify-content-center">
                                <div className="col-md-6">
                                    <p className="card-text">
                                        <span className="fw-bold">Tipo:</span> {metodoPago.tipo}
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default MetodoPagoDetailContainer;
