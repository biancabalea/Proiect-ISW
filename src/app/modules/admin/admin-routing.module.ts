import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { PostBookComponent } from './components/post-book/post-book.component';

const routes: Routes = [
  {path: "dashboard", component: AdminDashboardComponent},
  {path: "book", component: PostBookComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
