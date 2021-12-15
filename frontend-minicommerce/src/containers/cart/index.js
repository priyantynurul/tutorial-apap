import CartItem from "../../components/cartItem";
import Fab from '@mui/material/Fab';
import ViewStreamIcon from '@mui/icons-material/ViewStream';
import ShoppingCartCheckoutIcon from '@mui/icons-material/ShoppingCartCheckout';
import {Link} from "react-router-dom"
import React from "react";
import APIConfig from "../../api/APIConfig";
import classes from "./styles.module.css";

class Cart extends React.Component {
    constructor(props) {
        super(props);
        this.state = { cartItems: [], items: [], isLoading: false };
    }

    componentDidMount() {
        this.loadData();
        this.loadDataCart();
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/item");
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async loadDataCart() {
        try {
            const { data } = await APIConfig.get("/cart");
            this.setState({ cartItems: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleCheckout() {
        try {
            await APIConfig.get("/cart/checkout");
            this.loadDataCart();
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    render() {
        return(
            <div className={classes.itemList}>
                <h1 className={classes.title}>
                    My Cart
                </h1>
                <div style={{position:'fixed', top:25, left:25}}>
                    <Link to="/">
                        <Fab variant="extended">
                            <ViewStreamIcon />
                        </Fab>
                    </Link>
                </div>
                <div style={{position:'fixed', top:25, right:25}}>
                    <Fab variant="extended">
                        <ShoppingCartCheckoutIcon onClick={this.handleCheckout}/>
                    </Fab>
                </div>
                <div>
                    {this.state.cartItems.map(item => (
                        <div>
                            <CartItem
                                key={item.id}
                                id={item.id}
                                title={item.item.title}
                                price={item.item.price}
                                jumlah={item.quantity}
                                description={item.item.description}
                                category={item.item.category}
                                quantity={item.item.quantity}
                            />
                        </div>
                    ))}
                </div>
            </div>
        )
    }
}

export default Cart;