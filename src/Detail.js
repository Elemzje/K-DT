import React from 'react';
import { useParams } from 'react-router-dom'
import styled from 'styled-components'

// const YellowBox = styled.div`
//     width: 50px;
//     height: 50px;
//     background-color: yellow;
//     margin-left: auto;
//     margin-right: auto;
// `

function Detail(props) {
    // React.useEffect(() => {
    //     setTimeout(() => {
    //         setBox(false);
    //     }, 2000);
    // }, []);

    
    const {id} = useParams();
    const foundItem = props.shoes.find((x) => {
        return x.id == id;
    })
    
    // const [box, setBox] = React.useState(true);
    
    // const [input, setInput] = React.useState('0');
    
    // React.useEffect(() => {
    //     if (isNaN(input)) {
    //         alert('왜그러는거야');
    //     }
    // }, [input])

    return (
        <div className="container">
            {/* <input onChange={(e) => {
                setInput(e.target.value);
            }} />
            {box ? <YellowBox/> : ''} */}
            <div className="row">
                <div className="col-md-6">
                    <img src={"https://codingapple1.github.io/shop/shoes"+(foundItem.id+1)+".jpg"} width="100%" />
                </div>
                <div className="col-md-6">
                    <h4 className="pt-5">{foundItem.title}</h4>
                    <p>{foundItem.content}</p>
                    <p>{foundItem.price}</p>
                    <button className="btn btn-danger">주문하기</button> 
                </div>
            </div>
        </div> 
    );
}

export default Detail;