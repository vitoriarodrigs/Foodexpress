import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "../styles/Login.css";
import Navbar from "../components/Navbar";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState(""); // agora é password
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post(
        "http://localhost:8081/api/login",
        { email, password }, // envia email e password
        { headers: { "Content-Type": "application/json" } }
      );

      console.log("✅ Resposta da API:", response.data);
      // Se login bem-sucedido, redireciona para Home
      navigate("/");
    } catch (error) {
      console.error("❌ Erro ao fazer login:", error);
      alert("Erro no login! Verifique o console para mais detalhes.");
    }
  };

  return (
    <>
      <Navbar />
      <div className="login-container">
        <div className="login-card">
          <h2>Entrar</h2>
          <form onSubmit={handleSubmit}>
            <input
              type="email"
              placeholder="Email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
            <input
              type="password"
              placeholder="Senha"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
            <button type="submit">Entrar</button>
          </form>
        </div>
      </div>
    </>
  );
}

export default Login;



