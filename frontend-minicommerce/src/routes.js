import React from 'react';
import { Route, Switch, Redirect } from 'react-router-dom';
import itemlist from './containers/itemlist';
import cart from './containers/cart';

export const AppRoutes = () => {
    return (
        <div>
            <Switch>
                <Route exact path="/" component={itemlist} />
                <Route exact path="/cart" component={cart} />
            </Switch>
        </div>
    )
}
