import React from "react";
import "../styles/Categorias.css"; 

const Categorias = () => {
  return (
    <section id="categorias" className="section">
      <h1 className="section-title" > CATEGORIAS</h1>
      <div className="categories-grid">
        <a href="/categoria/pizzas" className="category-item">
          <img src="/imagens/pizza.jpg" alt="Pizzas" />
          <span>Pizzas</span>
        </a>
        <a href="/categoria/massas" className="category-item">
          <img src="/imagens/massas.jpg" alt="Massas" />
          <span>Massas</span>
        </a>
        <a href="/categoria/hamburguer" className="category-item">
          <img src="/imagens/hamburguer.jpg" alt="Hamburguer" />
          <span>Hamburguer</span>
        </a>
        <a href="/categoria/lanches" className="category-item">
          <img src="/imagens/hotdog.jpg" alt="Lanches" />
          <span>Lanches</span>
        </a>
        <a href="/categoria/sushi" className="category-item">
          <img src="/imagens/sushi.jpg" alt="Sushi" />
          <span>Sushi</span>
        </a>
        <a href="/categoria/churrasco" className="category-item">
          <img src="/imagens/churrasco.jpg" alt="Churrasco" />
          <span>Churrasco</span>
        </a>
      </div>
    </section>
  );
};

export default Categorias;
