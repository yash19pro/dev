import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BpmnDiagramComponent } from './bpmn-diagram/bpmn-diagram.component';

@NgModule({
  declarations: [
    AppComponent,
    BpmnDiagramComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
