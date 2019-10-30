export class Bird {
    id: string;
    name: string;
    es: BirdI18n;
    ca: BirdI18n;
    en: BirdI18n;
    constructor() {
        this.es = new BirdI18n();
        this.ca = new BirdI18n();
        this.en = new BirdI18n();
    }
}
export class BirdI18n {
    id: string;
    name: string;
}