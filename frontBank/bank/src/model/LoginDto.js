export class LoginDto {
    constructor(username, password) {
        this.username = username;
        this.password = password;
    }
    setName(username) {
        this.username.set(username);
    }
    getName(h) {
        return this.username.get(h);
    }
    setAge(password) {
        this.age.set(password);
    }
    getAge(h) {
        return this.age.get(h);
    }
}
