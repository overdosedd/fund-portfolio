import { useEffect, useState } from 'react';

export default function PortfolioTable() {
  const [data, setData] = useState<any[]>([]);
  const [loading, setLoading] = useState(true);
  const apiBaseUrl = process.env.NEXT_PUBLIC_API_BASE_URL;

  useEffect(() => {
    const token = typeof window !== 'undefined' ? localStorage.getItem('token') : null;
    if (!token) {
      setLoading(false);
      return;
    }

    fetch(`${apiBaseUrl}/api/portfolio/positions/1`, {
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    })
      .then(res => {
        if (!res.ok) throw new Error('Unauthorized');
        return res.json();
      })
      .then(data => {
        setData(data);
        setLoading(false);
      })
      .catch(err => {
        console.error('Failed to fetch portfolio data:', err);
        setLoading(false);
      });
  }, [apiBaseUrl]); // Removed userId from dependencies

  if (loading) return <div className="mt-4">Loading...</div>;

  return (
    <table className="min-w-full border mt-4">
      <thead>
        <tr>
          <th className="border px-4 py-2">Fund Name</th>
          <th className="border px-4 py-2">Units</th>
          <th className="border px-4 py-2">Cash Value</th>
        </tr>
      </thead>
      <tbody>
        {Array.isArray(data) && data.length > 0 ? (
          data.map((item, idx) => (
            <tr key={idx}>
              <td className="border px-4 py-2">{item.fundName}</td>
              <td className="border px-4 py-2">{item.units}</td>
              <td className="border px-4 py-2">{item.cashAmount}</td>
            </tr>
          ))
        ) : (
          <tr>
            <td colSpan={3}>No data available</td>
          </tr>
        )}
      </tbody>
    </table>
  );
}