const API_URL_BASE = 'http://localhost:8090/metodo_pagos';

export const getMetodoPagos = async () => {
    const response = await fetch(API_URL_BASE);
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    const result = await response.json();
    console.log('Success:', result);
    return result.data;
}

export const saveMetodoPago = async (metodoPago: any) => {
    const response = await fetch(API_URL_BASE + '/guardar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(metodoPago),
    });
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    const result = await response.json();
    return result.data;
}

export const getMetodoPagoByTipo = async (tipo: string) => {
    const response = await fetch(API_URL_BASE + '/tipo/' + tipo);
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    const result = await response.json();
    return result.data;
}