import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./components/Layout/Header";
import Footer from "./components/Layout/Footer";
import Home from "./components/News/Home";
import NewDetails from "./components/News/NewDetails";
import Login from "./components/User/Login";
import Register from "./components/User/Register";
import "bootstrap/dist/css/bootstrap.min.css";
import { MyDispatchContext, MyUserContext } from "./configs/Contexts";
import { useReducer } from "react";
import MyUserReducer from "./configs/Reducers";
import cookie from "react-cookies";
import { Container } from "react-bootstrap";

const App = () => {

  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null)

  return (
    <BrowserRouter>
      <MyUserContext.Provider value={user}>
        <MyDispatchContext.Provider value={dispatch}>
          <Header />
          <Container>
            <Routes>
              <Route path="/login" element={<Login />} />
              <Route path="/register" element={<Register />} />
              <Route path="/news/:newId" element={<NewDetails />} />
              <Route path="/" element={<Home />} />
            </Routes>
          </Container>
          <Footer />
        </MyDispatchContext.Provider>
      </MyUserContext.Provider>
    </BrowserRouter>
  );
};

export default App;
