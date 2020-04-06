import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { CartComponent } from './cart.component';

export const CART_ROUTE: Route = {
  path: 'cart',
  component: CartComponent,
  data: {
    authorities: [],
    pageTitle: 'cart.title'
  },
  canActivate: [UserRouteAccessService]
};
