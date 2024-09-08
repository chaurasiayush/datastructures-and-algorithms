// currieng > f(a, b) : f(a)(b)

function multiply(a, b) {
    return a*b;
}

function curry(callback) {
    return function(a) {
        return function (b){
            return callback(a, b);
        }
    }
}

const fn = curry(multiply);

console.log(fn(3)(2))
