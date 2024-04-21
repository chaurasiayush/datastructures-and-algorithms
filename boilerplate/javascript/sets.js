// create a set
const aset = new Set();
console.log(aset);

// create a set from an iterable - Array
const aSetFromArray = new Set([1,2,3,4]);
console.log(aSetFromArray);



// adding an element in the set
aset.add(1);
console.log(aset);

// checking if set has a value
const hasOne = aset.has(1) // returns boolean
console.log(hasOne, aset);

// removing an element from a set
const wasRemoved = aset.delete(1);
console.log(wasRemoved, aset);