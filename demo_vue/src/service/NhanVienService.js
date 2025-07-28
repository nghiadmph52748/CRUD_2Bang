const API = 'http://localhost:8080/api/nhan-vien-management';

export const getAllNhanVienService = async () => {
    const response = await fetch(`${API}/playlist`);
    if (!response.ok) {
        throw new Error('Failed getAllNhanVienService');
    }
    return await response.json();
}
