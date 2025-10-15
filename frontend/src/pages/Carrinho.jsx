import React from "react";
import "../styles/Carrinho.css";

const Carrinho = () => {
  const itens = [
    { nome: "Hambúrguer Clássico", preco: 25.9 },
    { nome: "Batata Média", preco: 10.5 },
    { nome: "Refrigerante", preco: 7.0 },
  ];

  const total = itens.reduce((acc, item) => acc + item.preco, 0);

  return (
    <div className="carrinho-container">
      <h1 className="carrinho-titulo">Seu Carrinho</h1>

      <div className="carrinho-itens">
        {itens.map((item, index) => (
          <div className="item" key={index}>
            <div className="item-info">
              <span className="item-nome">{item.nome}</span>
            </div>
            <span className="item-preco">R$ {item.preco.toFixed(2)}</span>
          </div>
        ))}

        <div className="total">Total: R$ {total.toFixed(2)}</div>
        <button className="btn-finalizar">Finalizar Pedido</button>
      </div>
    </div>
  );
};

export default Carrinho;
