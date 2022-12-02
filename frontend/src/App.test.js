import { render, screen } from '@testing-library/react';
import App from './App';

test('renders slaves link', () => {
  render(<App />);
  const linkElement = screen.getByText(/Slaves2/i);
  expect(linkElement).toBeInTheDocument();
});
