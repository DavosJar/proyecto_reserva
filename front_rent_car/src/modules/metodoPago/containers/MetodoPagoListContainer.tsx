import { FaCreditCard, FaMoneyBillAlt } from "react-icons/fa";
import { useMetodoPago } from '../hooks/useMetodoPagoList';

const MetodoPagoContainer: React.FC = () => {
    const { metodoPagos, loading, error } = useMetodoPago();

    if (loading) return <p className="text-center text-primary fw-bold">Cargando...</p>;
    if (error) return <p className="text-center text-danger fw-bold">Error: {error}</p>;

    return (
        <div className="container mt-5">
            <h1 className="text-center mb-4 text-primary d-flex justify-content-center align-items-center gap-2">
                <FaCreditCard /> Listado de Métodos de Pago
            </h1>
            <div className="card shadow-sm rounded-3">
                <div className="card-header bg-primary text-white rounded-top-3">
                    <h2 className="card-title mb-0 d-flex align-items-center gap-2">
                        <FaCreditCard /> Métodos de Pago Disponibles
                    </h2>
                </div>
                <div className="card-body p-0">
                    <div className="table-responsive">
                        <table className="table table-hover table-striped table-borderless text-center align-middle mb-0">
                            <thead className="table-light">
                                <tr>
                                    <th><FaCreditCard /> ID</th>
                                    <th><FaMoneyBillAlt /> Tipo</th>
                                </tr>
                            </thead>
                            <tbody>
                                {metodoPagos.map((metodoPago: any) => (
                                    <tr key={metodoPago.id} className="rounded-3">
                                        <td className="fw-semibold">{metodoPago.id}</td>
                                        <td>{metodoPago.tipo}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default MetodoPagoContainer;