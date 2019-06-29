export class Agent {
    constructor(
        public id: number,
        public email: string,
        public firstName: string,
        public lastName: string,
        public password: string,
        public username: string,
        public brn: number,
        public status: number,
        public address_id: number
    ){}
}
