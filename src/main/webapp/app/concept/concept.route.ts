import { Route } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ConceptComponent } from './concept.component';

export const CONCEPT_ROUTE: Route = {
  path: 'concept',
  component: ConceptComponent,
  data: {
    authorities: [],
    pageTitle: 'concept.title'
  },
  canActivate: [UserRouteAccessService]
};
