// polifill for map method

const { callbackify } = require("util");

[1].map((a) => a*2);

Array.prototype.map = function(callback) {
    let ans = [];
    for(let i=0; i<this.length; i++){
        ans.push(callback(this[i]));
    }
    return ans;
}

//polifill for filter
// [1].filter((e) => e%2);
Array.prototype.filter = function(callback) {
    let ans = [];
    for(let i=0; i<this.length; i++){
        if( callback(this[i]) ){
            ans.push(this[i]);
        }
    }
    return ans;
}

//polifill for reduce
// [1].reduce((acc, e, ind, arr) => {
//     return acc+e;
// }, 0);

Array.prototype.reduce = function(callback, initialValue) {
    let acc = initialValue?? 0;
    
    for(let i=0; i<this.length; i++){
        acc = callback(acc, this[i], i, this);
    }
    return acc;
}


function printNames(a, b, c){
    console.log(this.firstname, this.lastname, a, b, c);
}

const printNamesAr = (a, b, c) => {
    console.log(this.firstname, this.lastname, a, b, c);
}

//polifill for call

let o1 = {
    firstname: "Martand",
    lastname: "Dhamdere"
}

// call(context, arg1, arg2, ...)

Function.prototype.pcall = function(context, ...args) {
    context.tmp = this
    return context.tmp(...args);
}

// printNames.pcall(o1, 1,2,3,4);

//polifill for apply

// printNames.apply(o1, [1,2,3,4,5])

Function.prototype.papply = function (context, args) {
    context.papply = this;
    context.papply(...args);
}

// printNames.papply(o1, [1,2,3,4,5]);

//polifill for bind

// const binded = printNames.bind(o1, 1);
// binded(2,3)
const binded = printNamesAr.bind(o1, 1);
binded(2,3)

Function.prototype.pbind  = function(context, ...args) {
    context.pbind = this;
    return function(...args2) {
        context?.pbind(...args, ...args2);
    }
}

// const pbinded = printNames.pbind(o1, 1);
// pbinded(2, 3);
const pbinded = printNamesAr.pbind(o1, 1);
pbinded(2, 3);


// let arr = [1,2,3,4,5,6,7,8,9];
// const mapped = arr.map((e) => e*2);
// console.log(mapped);

// const filtered = arr.filter((e) => e > 5);
// console.log(filtered);

// const reduced = arr.reduce((acc, e) => acc+e, 0);
// console.log(reduced);


