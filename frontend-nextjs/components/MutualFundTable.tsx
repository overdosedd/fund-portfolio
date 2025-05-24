import { useEffect, useState } from "react";

type MutualFund = {
  id: number;
  name: string;
  isin: string;
  currency: string;
};

export default function MutualFundTable() {
  const [funds, setFunds] = useState<MutualFund[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchFunds = async () => {
      try {
        const res = await fetch(`${process.env.NEXT_PUBLIC_API_BASE_URL}/api/funds`);
        const data = await res.json();
        setFunds(data);
      } catch (err) {
        console.error("Failed to load mutual funds", err);
      } finally {
        setLoading(false);
      }
    };

    fetchFunds();
  }, []);

  return (
    <div className="p-4">
      <h2 className="text-xl font-bold mb-4">Mutual Funds</h2>
      {loading ? (
        <p>Loading...</p>
      ) : funds.length === 0 ? (
        <p>No mutual funds found.</p>
      ) : (
        <table className="min-w-full border">
          <thead>
            <tr>
              <th className="border px-4 py-2">Name</th>
              <th className="border px-4 py-2">ISIN</th>
              <th className="border px-4 py-2">Currency</th>
            </tr>
          </thead>
          <tbody>
            {funds.map((fund) => (
              <tr key={fund.id}>
                <td className="border px-4 py-2">{fund.name}</td>
                <td className="border px-4 py-2">{fund.isin}</td>
                <td className="border px-4 py-2">{fund.currency}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}