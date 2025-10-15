import React, { useState } from "react";
import { Link } from "react-router-dom";
import "../styles/Navbar.css";

const Navbar = () => {
  const [menuOpen, setMenuOpen] = useState(false);

  return (
    <nav className="navbar">
      <div className="logo">FOOD EXPRESS</div>

      <button className="menu-toggle" onClick={() => setMenuOpen(!menuOpen)}>
        ☰
      </button>

      <div className={`nav-links ${menuOpen ? "active" : ""}`}>
        <a href="#home">Home</a>
        <a href="#categorias">Categorias</a>
        <a href="#restaurantes">Restaurantes</a>
         <Link to="/login">Login</Link>
      </div>
      <Link to="/carrinho" className="cart-icon" title="Ir para o carrinho">
        🛒
      </Link>
    </nav>
  );
};

export default Navbar;
