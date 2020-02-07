import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { BoutiqueComponent } from './boutique.component';

export const BOUTIQUE_ROUTE: Route = {
  path: 'boutique',
  component: BoutiqueComponent,
  data: {
    authorities: [],
    pageTitle: 'boutique.title'
  },
  canActivate: [UserRouteAccessService]
};
