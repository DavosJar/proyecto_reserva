import { lazy } from "react";
import { createBrowserRouter, Outlet } from "react-router-dom";
import { vehiculoRoutes } from "../../modules/vehiculo/routers/routes"; // Asegúrate de importar correctamente
lazy(
    () => import("../../modules/vehiculo/containers/VehiculoContainer")
);
export const router = createBrowserRouter([
    {
        path: "/",
        element: <Outlet />, // Elemento que permite el anidado de rutas
        children: [
            {
                index: true,
                element: <h1> Hello World </h1>, // Página de inicio
            },
            ...vehiculoRoutes,
        ],
    },
]);