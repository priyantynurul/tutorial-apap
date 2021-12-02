import React from "react";
import Button from "../button";
import classes from "./styles.module.css";
const Item = (props) => {
    const { id, title, price, description, category, quantity, handleEdit, handleAddToCart} = props;
    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Price: ${price}`}</p>
            <p>{`Description: ${description}`}</p>
            <p>{`Category: ${category}`}</p>
            <p>{`Quantity: ${quantity}`}</p>
            <Button action={handleEdit}>
                Edit
            </Button>
            <div>
            <input
                className={classes.textField}
                id={`cartItem${id}`}
                type="number"
                placeholder="ex. 10"
                name="cartItem"
            />
            <Button action={handleAddToCart}>
                Add To Cart
            </Button>
            </div>
        </div>
    );
};
export default Item;
