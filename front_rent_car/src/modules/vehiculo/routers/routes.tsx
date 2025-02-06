import { Suspense } from "react";
import { Outlet, RouteObject } from "react-router-dom";
import { lazy } from "react";

// Cargar los contenedores de los componentes
const VehiculoContainer = lazy(() => import("../containers/VehiculoContainer"));
const VehiculoFormContainer = lazy(() => import("../containers/VehiculoFormContainer"));
const VehiculoDetailContainer = lazy(() => import("../containers/VehiculoDetailContainer"));

export const vehiculoRoutes: RouteObject[] = [
    {
        path: "vehiculo", // Ruta base para vehículos
        element: <Suspense fallback={<div>Loading...</div>}><Outlet /></Suspense>, // Usa Suspense para cargar la ruta
        children: [
            {
                path: "lista", // Ruta de listado de vehículos
                index: true, // Ruta por defecto dentro de /vehiculo
                element: <Suspense fallback={<div>Loading...</div>}><VehiculoContainer /></Suspense>, // Usa Suspense aquí también
            },
            {
                path: "guardar", // Ruta para guardar un nuevo veh ículo
                element: <Suspense fallback={<div>Loading...</div>}><VehiculoFormContainer /></Suspense>, // Suspense aquí también
            },
            {
                path: "matricula/:matricula", // Ruta para ver el detalle de un vehículo
                element: <Suspense fallback={<div>Loading...</div>}><VehiculoDetailContainer /></Suspense>, // Suspense aquí también
            }
        ],
    },
];  // Exporta las rutas para ser utilizadas en el archivo de rutas principal