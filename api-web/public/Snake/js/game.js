class Game {
    constructor() {
        this.row = 25;
        this.col = 25;
        this.snake = new Snake();
        this.food = new Food(this);
        this.score = 0;
        this.d = 'R';
        this.init();
        this.start();
        this.bindEvent()
    }

    init() {
        this.dom = document.createElement('table');
        let tr, td;
        for (let i = 0; i < this.row; i++) {
            tr = document.createElement('tr')
            for (let j = 0; j < this.col; j++) {
                td = document.createElement('td');
                tr.appendChild(td);
            }
            this.dom.appendChild(tr);
        }
        document.querySelector('#app').appendChild(this.dom)
    }

    setColor(row, col, color) {
        this.dom.getElementsByTagName('tr')[row].getElementsByTagName('td')[col].style.backgroundColor = color
    }

    setHeadColor(row, col) {
        let img = document.createElement('img')
        img.src = '/Snake/img/snake.png'
        img.className = 'snake'
        this.dom.getElementsByTagName('tr')[row].getElementsByTagName('td')[col].appendChild(img)

        switch (this.d) {
            case 'R':   //右
                break;
            case 'D':   //下
                img.style.transform = 'rotate(90deg)';
                break;
            case 'L':   //左
                img.style.transform = 'rotate(180deg)';
                break;
            case 'U':   //上
                img.style.transform = 'rotate(-90deg)';
                break;
        }
    }

    setFood(row, col) {
        this.dom.getElementsByTagName('tr')[row].getElementsByTagName('td')[col].style.backgroundImage = 'url(/Snake/img/food.png)'

    }

    clear() {
        for (let i = 0; i < this.row; i++) {
            for (let j = 0; j < this.col; j++) {
                this.dom.getElementsByTagName("tr")[i].getElementsByTagName('td')[j].style.background = '';
                this.dom.getElementsByTagName("tr")[i].getElementsByTagName('td')[j].innerHTML = '';
            }
        }
    }

    bindEvent() {
        document.addEventListener('keydown', (e) => {
            switch (e.key) {
                case 'ArrowUp': {
                    if (this.snake.direction === 'D') {
                        return
                    }
                    this.snake.changeDirection('U');
                    this.d = 'U'
                    break
                }
                case 'ArrowDown': {
                    if (this.snake.direction === 'U') {
                        return
                    }
                    this.snake.changeDirection('D');
                    this.d = 'D'
                    break
                }
                case 'ArrowLeft': {
                    if (this.snake.direction === 'R') {
                        return
                    }
                    this.snake.changeDirection('L');
                    this.d = 'L'
                    break
                }
                case 'ArrowRight': {
                    if (this.snake.direction === 'L') {
                        return
                    }
                    this.snake.changeDirection('R');
                    this.d = 'R'
                    break
                }
            }
        })
    }

    start() {
        this.f = 0;
        this.timer = setInterval(() => {
            game.f++;
            game.clear();
            let during = game.snake.body.length < 30 ? 30 - game.snake.body.length : 1;
            if (game.f % during === 0) {
                game.snake.update();
            }

            game.snake.render();
            // 渲染食物
            game.food.render();

        }, 10)
    }


}