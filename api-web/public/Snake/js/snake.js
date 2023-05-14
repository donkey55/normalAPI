class Snake {
    constructor() {
        this.body = [
            {
                x: 5, y: 6
            },
            {
                x: 5, y: 5
            },
            {
                x: 5, y: 4
            }
        ]
        this.direction = 'R';
        this.willDirection = 'R';
    }

    render() {
        game.setHeadColor(this.body[0].x, this.body[0].y);
        for (let i = 1; i < this.body.length; i++) {
            let box = this.body[i];
            game.setColor(box.x, box.y, '#649c49');
        }
    }

    update() {
        this.direction = this.willDirection;
        switch (this.direction) {
            case "R": {
                this.body.unshift({x: this.body[0].x, y: this.body[0].y + 1})
                break
            }
            case "L": {
                this.body.unshift({x: this.body[0].x, y: this.body[0].y - 1})
                break
            }
            case "D": {
                this.body.unshift({x: this.body[0].x + 1, y: this.body[0].y})
                break
            }
            case "U": {
                this.body.unshift({x: this.body[0].x - 1, y: this.body[0].y})
                break
            }
        }
        // 死亡判断
        if (this.body[0].x > game.row - 1 || this.body[0].x < 0
            || this.body[0].y > game.col - 1 || this.body[0].y < 0) {
            alert("结束，撞到强了")
            this.body.shift();
            clearInterval(game.timer)
            location.reload();
        }
        // 自己装自己
        let first = this.body[0]
        for (let i = 1; i < this.body.length; i++) {
            let box = this.body[i]
            if (box.x === first.x && box.y === first.y) {
                alert("结束，撞自己了")
                this.body.shift();
                clearInterval(game.timer)
                location.reload();
            }
        }
        if (first.x === game.food.row && first.y === game.food.col) {
            game.food = new Food(game);
            game.score += 1;
            game.f = 0;
        } else {
            this.body.pop();
        }
    }


    changeDirection(d) {
        this.willDirection = d;
    }
}
