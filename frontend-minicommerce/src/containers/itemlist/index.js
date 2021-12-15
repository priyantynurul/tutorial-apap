import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig.js";
import Button from "../../components/button";
import Modal from "../../components/modal";
import { Badge } from '@mui/material';
import Fab from '@mui/material/Fab';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { Link } from "react-router-dom";

class ItemList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
            //inCart: 0,
            textSearch: "",
            cartItems: [],
            cartHidden: true
        };
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleAddToCart = this.handleAddToCart.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitItem = this.handleSubmitItem.bind(this);
        this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        this.handleChangeFieldSearch = this.handleChangeFieldSearch.bind(this);
    }

    componentDidMount() {
        this.loadData();
    }

    handleAddItem() {
        this.setState({ isCreate: true });
    }

    handleEditItem(item) {
        this.setState({
            isEdit: true,
            id: item.id,
            title: item.title,
            price: item.price,
            description: item.description,
            category: item.category,
            quantity: item.quantity,
        });
    }

    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate: false, isEdit: false });
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    handleChangeFieldSearch(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
        this.loadData();
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get(`/item?title=${this.state.textSearch}`);
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0,
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSubmitEditItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
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

    async handleAddToCart(event) {
        const inputValue = document.getElementById("cartItem" + event.id).value;
        const cartItems = [...this.state.cartItems];
        try {
            if (cartItems.length === 0) {
                if (inputValue <= event.quantity) {
                    const data = {
                        quantity: inputValue,
                        idItem: event.id,
                    };
                    await APIConfig.post("/cart", data);
                    this.loadData();
                    this.loadDataCart();
                }
            } else {
                for (let i = 0; i < cartItems.length; i++) {
                    const temp = cartItems[i];
                    if (event.id === temp.item.id) {
                        if (inputValue <= event.quantity - temp.quantity) {
                            const data = {
                                quantity: inputValue,
                                idItem: event.id,
                            };
                            await APIConfig.post("/cart", data);
                            this.loadData();
                            this.loadDataCart();
                        } else {
                            alert("Insufficient stock");
                        }
                    } else {
                        console.log("masuk else");
                        if (inputValue <= event.quantity) {
                            const data = {
                                quantity: inputValue,
                                idItem: event.id,
                            };
                            await APIConfig.post("/cart", data);
                        }
                    }
                    alert("Oops maaf stok tidak cukup");
                }
            }
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    render() {
        return (
            <div className={classes.itemList}>
                <h1 className={classes.title}>
                    All Items
                </h1>
                <div style={{position:'fixed', top:25, right:25}}>
                    <Link to="/cart">
                        <Fab variant="extended">
                            <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                                <ShoppingCartIcon />
                            </Badge>
                        </Fab>
                    </Link>
                </div>
                <input
                    className={classes.textField}
                    type="text"
                    placeholder="Cari Item"
                    name="textSearch"
                    value={this.state.textSearch}
                    onChange={this.handleChangeFieldSearch}
                />
                <Button action={this.handleAddItem}>
                    Add Item
                </Button>
                <div>
                    {this.state.items.map((item) => (
                        <Item
                            key={item.id}
                            id={item.id}
                            title={item.title}
                            price={item.price}
                            description={item.description}
                            category={item.category}
                            quantity={item.quantity}
                            handleEdit={() => this.handleEditItem(item)}
                            handleAddToCart={() => this.handleAddToCart(item)}
                        />
                    ))}
                </div>
                <Modal
                    show={this.state.isCreate || this.state.isEdit}
                    handleCloseModal={this.handleCancel}
                    modalTitle={this.state.isCreate
                        ? "Add Item"
                        : `Edit Item ID ${this.state.id}`}
                >
                    <form>
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Nama Item"
                            name="title"
                            value={this.state.title}
                            onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField}
                            type="number"
                            placeholder="Harga"
                            name="price"
                            value={this.state.price}
                            onChange={this.handleChangeField}
                        />
                        <textarea
                            className={classes.textField}
                            placeholder="Deskripsi"
                            name="description"
                            rows="4"
                            value={this.state.description}
                            onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Kategori"
                            name="category"
                            value={this.state.category}
                            onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField}
                            type="number"
                            placeholder="qty"
                            name="quantity"
                            value={this.state.quantity}
                            onChange={this.handleChangeField}
                        />
                        <Button action={this.state.isCreate
                            ? this.handleSubmitItem
                            : this.handleSubmitEditItem}
                        >
                            Create
                        </Button>
                        <Button action={this.handleCancel}>
                            Cancel
                        </Button>
                    </form>
                </Modal>
            </div>
        );
    }
}
export default ItemList;