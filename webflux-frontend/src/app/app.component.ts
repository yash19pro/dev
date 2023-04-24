import { Component, NgZone } from '@angular/core';
import { Observable, Observer } from 'rxjs';

import { environment as env } from '../environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  endSearch: boolean = false;
  showProgressBar: boolean = true;
  results: string[] = [];
  resultObserver: Observable<string[]> = this.createEventSourceObserver();

  constructor(private ngZone: NgZone) {}

  search(event: any) {
    event.preventDefault();
    this.endSearch = false;
    this.showProgressBar = true;
    this.results = [];
    this.resultObserver = this.createEventSourceObserver();
  }

  createEventSourceObserver(): Observable<string[]> {
    return new Observable<string[]>((observer: Observer<string[]>) => {
      const source = new EventSource(env.api_url);

      source.onmessage = (event) => {
        console.log(event.data);
        this.results.push(event.data);
        this.results.sort();
        // NgZone is used to notify results updates to async operations
        this.ngZone.run(() => observer.next(this.results));
      };
      source.onopen = (event) => {
        if (this.endSearch) {
          source.close();
          this.ngZone.run(() => {
            observer.complete();
            this.showProgressBar = false;
          });
        }
        this.endSearch = true;
      };
    });
  }
}
