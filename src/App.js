import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { Container, Nav, Navbar } from 'react-bootstrap';
import data from './data';
import { useEffect, useState } from 'react';
import { Routes, Route, Link, useNavigate, Outlet } from 'react-router-dom'
import Detail from './Detail';
import axios from 'axios';

function App() {

  // eslint-disable-next-line
  const [shoes, setShoes] = useState(data);
  const navigate = useNavigate();
  const [btnCnt, setBtnCnt] = useState(2);
  const [btnState, setBtnState] = useState(true);
  const addData = (a) => {
    axios.get(`https://codingapple1.github.io/shop/data${a}.json`).then((extra)=>{
      let copy = [...shoes, ...extra.data];
      setShoes(copy);
      setTimeout(() => {
        console.log('ah');
        
      }, 1000);
    })
    .catch(()=>{
      console.log('실패함');
    }).then(() => {
      setSpanState(false);
    })
  }
  const [spanState, setSpanState] = useState(false);

  useEffect(() => {
    setSpanState(true);
  }, [shoes])


  return (
    <div className="App">
      <Header/>
      {btnState ? <><button onClick={()=>{
        if (btnCnt != 2 && btnCnt != 3) {
          setBtnState(false);
          return '';
        }
        addData(btnCnt);
        let copy = btnCnt;
        setBtnCnt(copy + 1);
      }}>버튼</button> {spanState ? <span>로딩중입니다</span> : '' }</> : ''}
      <Routes>
        <Route path="/" element={
          <>
            <div className="main-bg"></div>
            <div className="container">
              <div className="row">
                {shoes.map((item) => {
                  return(
                    <Shoes item={item}/>
                  );
                })}
              </div>
            </div>
          </>
        } />
        <Route path="/detail/:id" element={<Detail shoes={shoes}/>} />
        <Route path="/about" element={<div>어바웃</div>} />
        <Route path="/event" element={<Event />}>
          <Route path="one" element={<div>첫 주문시 양배추즙 서비스</div>} />
          <Route path="two" element={<div>생일기념 쿠폰받기</div>} />
        </Route>
        <Route path="*" element={<div>없는 페이지임</div>} />
      </Routes>
    </div>
  );
}

const Header = () => {
  return(
    <Navbar bg="dark" variant="dark">
      <Container>
      <Navbar.Brand href="/">Shoes Shop</Navbar.Brand>
      <Nav className="me-auto">
        <Nav.Link href="/">홈</Nav.Link>
        <Nav.Link href="/detail/0">상세페이지</Nav.Link>
        <Nav.Link href="#pricing">Pricing</Nav.Link>
      </Nav>
      </Container>
    </Navbar>
  );
}

const Shoes = (props) => {
  const navigate = useNavigate();
  return (
    <div className="col-md-4" key={props.item.id} onClick={ () => {
      navigate(`/detail/${props.item.id}`);
    }}>
      <img src={"https://codingapple1.github.io/shop/shoes"+(props.item.id + 1)+".jpg"} width="80%" />
      <h4>{props.item.title}</h4>
      <p>{props.item.content}</p>
    </div>
  );
}

const Event = () => {
  return(
    <>
      <h4>오늘의 이벤트</h4>
      <Outlet></Outlet>
    </>
  );
}

export default App;
