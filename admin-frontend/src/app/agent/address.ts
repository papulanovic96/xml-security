export class AddressAgent{
    constructor(
        public country: string,
        public city: string,
        public zip: number,
        public street: string,
        public longitude: number,
        public latitude: number
    ) {}
}