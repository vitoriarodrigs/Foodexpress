import React from "react";
import "../styles/Restaurantes.css";

const Restaurantes = () => {
  return (
    <section id="restaurantes" className="section">
      <h1 className="section-title" >RESTAURANTES POPULARES</h1>
      <div className="restaurante-grid">
        <div className="restaurante-card">
          <h3>Burger Town</h3>
          <div className="avaliacao">
            <span className="nota">4.8</span>
            <span className="estrelas">⭐⭐⭐⭐</span>
          </div>
          <p>O melhor hambúrguer artesanal da cidade.</p>
        </div>
        <div className="restaurante-card">
          <h3>Pizza Prime</h3>
          <div className="avaliacao">
            <span className="nota">4.6</span>
            <span className="estrelas">⭐⭐⭐⭐</span>
          </div>
          <p>Pizzas de forno a lenha com massa fina e crocante.</p>
        </div>
        <div className="restaurante-card">
              <h3>Carneiro & cia</h3>
              <div className="avaliacao">
                 <span className="nota">4.5</span>
                 <span className="estrelas">⭐⭐⭐⭐⭐</span>
              </div>
              <p>Churrascaria e petiscaria.</p>
            </div>
            <div className="restaurante-card">
              <h3>Sushi House</h3>
              <div className="avaliacao">
                 <span className="nota">4.5</span>
                 <span className="estrelas">⭐⭐⭐⭐⭐</span>
              </div>
              <p>Comida japonesa fresca e deliciosa.</p>
            </div>
            {/* Churras Grill */}
           <div className="restaurante-card">
             <h3>Churras Grill</h3>
             <div className="avaliacao">
                <span className="nota">4.6</span>
                <span className="estrelas">⭐⭐⭐⭐⭐</span>
              </div>
               <p>Especialista em carnes nobres e grelhados.</p>
            </div>
              {/* Samurai Sushi */}
            <div className="restaurante-card">
             <h3>Samurai Sushi</h3>
              <div className="avaliacao">
                <span className="nota">5.0</span>
                 <span className="estrelas">⭐⭐⭐⭐⭐</span>
              </div>
               <p>Experiência autêntica da culinária japonesa.</p>
            </div>
              {/* FastFood Express */}
             <div className="restaurante-card">
               <h3>FastFood Express</h3>
              <div className="avaliacao">
                 <span className="nota">4.5</span>
                 <span className="estrelas">⭐⭐⭐⭐</span>
              </div>
               <p>Lanches rápidos e saborosos para o seu dia a dia.</p>
            </div>
             {/* La pasta*/}
             <div className="restaurante-card">
               <h3>La Pasta</h3>
              <div className="avaliacao">
                 <span className="nota">4.7</span>
                 <span className="estrelas">⭐⭐⭐⭐</span>
              </div>
               <p>Macarronadas e Lasanhas.</p>
            </div>
            {/* CUCCINA DO MÁRIO*/}
             <div className="restaurante-card">
               <h3>CUCCINA DO Luiggi</h3>
              <div className="avaliacao">
                 <span className="nota">4.8</span>
                 <span className="estrelas">⭐⭐⭐⭐</span>
              </div>
               <p>Deliciosas Massas frescas feita na hora.</p>
            </div>
      </div>
    </section>
  );
};

export default Restaurantes;
