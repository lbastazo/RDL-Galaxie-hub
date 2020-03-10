import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { EquipeComponent } from './equipe.component';

export const EQUIPE_ROUTE: Route = {
  path: 'equipe',
  component: EquipeComponent,
  data: {
    authorities: [],
    pageTitle: 'equipe.title'
  },
  canActivate: [UserRouteAccessService]
};
