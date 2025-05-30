import logoImg from "@/assets/logo.png";
import Link from "next/link";
import classes from "./main-header.module.css";
import Image from "next/image";
import NavLink from "../nav-link/nav-link";

export default function MainHeader() {
  return (
    <header className={classes.header}>
      <Link className={classes.logo} href="/">
        <Image src={logoImg} alt="A plate with food on it" priority />
        NextLevel Food
      </Link>

      <nav className={classes.nav}>
        <ul>
          <li>
            <NavLink href={"/meals"}>Browse Meals</NavLink>
          </li>
        </ul>
        <ul>
          <li>
            <NavLink href={"/community"}>Foodies Community</NavLink>
          </li>
        </ul>
      </nav>
    </header>
  );
}
