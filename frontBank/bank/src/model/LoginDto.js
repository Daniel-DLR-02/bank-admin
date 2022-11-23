class LoginDto {
    constructor(username, password) {
        this.username = new Field(username);
        this.password = new Field(password);
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