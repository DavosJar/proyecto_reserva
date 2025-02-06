import React from 'react';

interface ButtonProps {
    name: string;
    method: 'GET' | 'POST' | 'PUT' | 'DELETE';
    endpoint: string;
    body?: any;
}

const Button: React.FC<ButtonProps> = ({ name, method, endpoint, body }) => {
    const handleClick = async () => {
        try {
            const options: RequestInit = {
                method,
                headers: {
                    'Content-Type': 'application/json',
                },
            };

            if (body) {
                options.body = JSON.stringify(body);
            }

            const response = await fetch(endpoint, options);

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

            const data = await response.json();
            console.log('Success:', data);
        } catch (error) {
            console.error('Error:', error);
        }
    };

    return (
        <button onClick={handleClick}>
            {name}
        </button>
    );
};

export default Button;