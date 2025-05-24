import { useEffect, useState } from 'react';

type FundSummary = {
  totalValue: number;
  dailyChangeAmount: number;
  dailyChangePercent: number;
};

export default function FundSummaryCard() {
  const [summary, setSummary] = useState<FundSummary | null>(null);
  const [loading, setLoading] = useState(true);
  const apiBaseUrl = process.env.NEXT_PUBLIC_API_BASE_URL;

  useEffect(() => {
    const token = typeof window !== 'undefined' ? localStorage.getItem('token') : null;
    if (!token) {
      setLoading(false);
      return;
    }

    fetch(`${apiBaseUrl}/api/portfolio/summary`, {
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
        setSummary(data);
        setLoading(false);
      })
      .catch(err => {
        console.error('Failed to fetch portfolio summary:', err);
        setLoading(false);
      });
  }, [apiBaseUrl]);

  if (loading) return <div>Loading...</div>;

  if (!summary) return <div>No summary available.</div>;

  return (
    <div className="border p-4 my-4 bg-gray-100 rounded">
      <h2 className="text-lg font-semibold">Portfolio Summary</h2>
      <p>Total Value: ${summary.totalValue.toFixed(2)}</p>
      <p>
        Daily Change: {summary.dailyChangeAmount >= 0 ? '+' : ''}
        ${summary.dailyChangeAmount.toFixed(2)} ({summary.dailyChangePercent.toFixed(2)}%)
      </p>
    </div>
  );
}