import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'product',
        loadChildren: () => import('./product/product.module').then(m => m.RdlgalaxieProductModule)
      },
      {
        path: 'product-category',
        loadChildren: () => import('./product-category/product-category.module').then(m => m.RdlgalaxieProductCategoryModule)
      },
      {
        path: 'customer',
        loadChildren: () => import('./customer/customer.module').then(m => m.RdlgalaxieCustomerModule)
      },
      {
        path: 'product-order',
        loadChildren: () => import('./product-order/product-order.module').then(m => m.RdlgalaxieProductOrderModule)
      },
      {
        path: 'order-item',
        loadChildren: () => import('./order-item/order-item.module').then(m => m.RdlgalaxieOrderItemModule)
      },
      {
        path: 'invoice',
        loadChildren: () => import('./invoice/invoice.module').then(m => m.RdlgalaxieInvoiceModule)
      },
      {
        path: 'shipment',
        loadChildren: () => import('./shipment/shipment.module').then(m => m.RdlgalaxieShipmentModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class RdlgalaxieEntityModule {}
