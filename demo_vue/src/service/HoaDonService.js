const API = 'http://localhost:8080/api/hoa-don-management';

export const getAllHoaDonService = async () => {
    const res = await fetch(`${API}/playlist`);
    if (!res.ok) {
        throw new Error('Failed getAllHoaDonService');
    }
    return await res.json();
}

export const getHoaDonByIdService = async (id) => {
    const res = await fetch(`${API}/detail/${id}`);
    if (!res.ok) {
        throw new Error('Failed getHoaDonByIdService');
    }
    return await res.json();
}

export const deleteHoaDonByIdService = async (id) => {
    const res = await fetch(`${API}/delete/${id}`, {
        method: 'DELETE',
    });
    if (!res.ok) {
        throw new Error('Failed deleteHoaDonByIdService');
    }
}

export const addHoaDonService = async (data) => {
    const res = await fetch(`${API}/add`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });
    if (!res.ok) {
        throw new Error('Failed addHoaDonService');
    }
}

export const updateHoaDonService = async (id, data) => {
    const res = await fetch(`${API}/update/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });
    if (!res.ok) {
        throw new Error('Failed updateHoaDonService');
    }
}