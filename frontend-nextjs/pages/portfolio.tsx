import Header from '../components/Header';
import Footer from '../components/Footer';
import NavBar from '../components/NavBar';
import PortfolioTable from '../components/PortfolioTable';
import CurrencySelector from '../components/CurrencySelector';
import FundSummaryCard from '../components/FundSummaryCard';
import MutualFundTable from '../components/MutualFundTable';

export default function PortfolioPage() {
  return (
    <div className="min-h-screen flex flex-col">
      <Header />
      <NavBar />
      <main className="flex-1 p-4">
        <CurrencySelector />
        <FundSummaryCard />
        <MutualFundTable />
        <PortfolioTable />
      </main>
      <Footer />
    </div>
  );
}
