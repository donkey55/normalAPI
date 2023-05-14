class Food {
    constructor(game) {
        let self = this;
        do {
            this.row = Math.floor(Math.random() * game.row);
            this.col = Math.floor(Math.random() * game.col);
        } while ((function () {
            for (let box in game.snake.body) {
                if (box.x === self.row && box.y === self.col) {
                    return true;
                }
            }
            return false
        })())
    }

    render() {
        game.setFood(this.row, this.col)
    }
}