const API_URL_BASE = 'http://localhost:8090/vehiculo';

export const getVehiculos = async () => {
    const response = await fetch(API_URL_BASE);
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    const result = await response.json();
    console.log('Success:', result);
    return result.data;
}

export const saveVehiculo = async (vehiculo: any) => {
    const response = await fetch(API_URL_BASE + '/guardar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(vehiculo),
    });
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    const result = await response.json();
    return result.data;
}

export const getVehiculoByMatricula = async (matricula: string) => {
    const response = await fetch(API_URL_BASE + '/matricula/' + matricula);
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    const result = await response.json();
    return result.data;
}