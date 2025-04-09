import "./globals.css";
import MainHeader from "@/components/main-header//main-header";
import MainHeaderBackground from "@/components/main-header/main-header-background";

export const metadata = {
  title: "NextLevel Foodies",
  description: "Delicious meals, shared by a food-loving community.",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body>
        <MainHeaderBackground></MainHeaderBackground>
        <MainHeader></MainHeader>
        {children}
      </body>
    </html>
  );
}
