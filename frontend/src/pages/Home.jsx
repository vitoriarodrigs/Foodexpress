import React from "react";
import Navbar from "../components/Navbar";
import Categorias from "../components/Categorias";
import Restaurantes from "../components/Restaurantes";
import "../styles/Home.css";
import churrascoImg from "./home.jpg"; 

const Home = () => {
  return (
    <div className="home-container">
      <Navbar />
      <section className="banner">
        <h1 className="banner-title">
          COMER É <br /> TUDO DE BOM
        </h1>
        <div className="image-wrapper">
          <img src={churrascoImg} alt="Churrasco" />
        </div>
      </section>
      <main className="main-content" id="home">
        <Categorias />
        <Restaurantes />
      </main>
    </div>
  );
};

export default Home;

