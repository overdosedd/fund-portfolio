import { useEffect, useState } from "react";

export default function CurrencySelector() {
  const [currencies, setCurrencies] = useState<string[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchCurrencies = async () => {
      try {
        const res = await fetch(`${process.env.NEXT_PUBLIC_API_BASE_URL}/api/currencies`);
        if (!res.ok) throw new Error("Failed to fetch currencies");
        const data = await res.json();
        setCurrencies(data); // Expecting: ["SGD", "JPY", "USD"]
      } catch (error) {
        console.error("Error fetching currencies:", error);
      } finally {
        setLoading(false);
      }
    };

    fetchCurrencies();
  }, []);

  return (
    <div className="my-4">
      <label htmlFor="currency" className="mr-2">Currency:</label>
      <select id="currency" className="border p-2" disabled={loading}>
        {loading ? (
          <option>Loading...</option>
        ) : (
          currencies.map((code) => (
            <option key={code} value={code}>
              {code}
            </option>
          ))
        )}
      </select>
    </div>
  );
}