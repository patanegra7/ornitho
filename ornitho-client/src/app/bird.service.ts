import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
// Ornitho App
import { Bird } from './bird';
import { MessageService } from './message.service'; 

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class BirdService {

  private birdsUrl = 'http://localhost:8080/birds';
  private birdUrl = 'http://localhost:8080/bird';  

  constructor(
    private http: HttpClient,
    private messageService: MessageService
  ) { }

  /** Log  */
  private log(message: string) {
    this.messageService.add('BirdService: ' + message);
  }

  getBirds(): Observable<Bird[]> {
    this.log('Birds retrieved')
    return this.http.get<Bird[]>(this.birdsUrl)
    .pipe(
      tap(birds => this.log(`fetched birds`)),
      catchError(this.handleError('getBirds', []))
    );
  }

  getBird(id: string): Observable<Bird> {
    this.messageService.add(`Bird retrieved with id=${id}`);
    const url = `${this.birdUrl}/${id}`;
    return this.http.get<Bird>(url)
    .pipe(
      tap(_ => this.log(`fetched bird id=${id}`)),
      catchError(this.handleError<Bird>(`getBird id=${id}`))
    );
  }

  /** POST: add a new bird to the server */
  addBird (bird: Bird): Observable<Bird> {
    return this.http.post<Bird>(this.birdUrl, bird, httpOptions)
    .pipe(
      tap((bird: Bird) => this.log(`added bird w/ id=${bird.id}`)),
      catchError(this.handleError<Bird>('addBird'))
    );
  }

  /** PUT: update the bird on the server */
  updateBird (bird: Bird): Observable<any> {
    return this.http.put(this.birdUrl, bird, httpOptions).pipe(
      tap(_ => this.log(`updated bird id=${bird.id}`)),
      catchError(this.handleError<any>('updateBird'))
    );
  }

  /** DELETE: delete the bird from the server */
  deleteBird (bird: Bird | number): Observable<Bird> {
    const id = typeof bird === 'number' ? bird : bird.id;
    const url = `${this.birdUrl}/${id}`;
    return this.http.delete<Bird>(url, httpOptions)
    .pipe(
      tap(_ => this.log(`deleted bird id=${id}`)),
      catchError(this.handleError<Bird>('deleteBird'))
    );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}