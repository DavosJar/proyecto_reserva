import { Suspense } from "react";
import { Outlet, RouteObject } from "react-router-dom";
import { lazy } from "react";

const MetodoPagoListContainer = lazy(() => import("../containers/MetodoPagoListContainer"));
const MetodoPagoFormContainer = lazy(() => import("../containers/MetodoPagoFormContainer"));
const MetodoPagoDetailContainer = lazy(() => import("../containers/MetodoPagoDetailContainer"));

export const metodoPagoRoutes: RouteObject[] = [
    {
        path: "metodo_pagos",
        element: <Suspense fallback={<div>Loading...</div>}><Outlet /></Suspense>,
        children: [
            {
                path: "lista",
                index: true,
                element: <Suspense fallback={<div>Loading...</div>}><MetodoPagoListContainer /></Suspense>,
            },
            {
                path: "guardar",
                element: <Suspense fallback={<div>Loading...</div>}><MetodoPagoFormContainer /></Suspense>,
            },
            {
                path: "tipo/:tipo",
                element: <Suspense fallback={<div>Loading...</div>}><MetodoPagoDetailContainer /></Suspense>,
            }
            
        ]
    }
];