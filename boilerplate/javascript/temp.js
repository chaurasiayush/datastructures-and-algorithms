// Store the original forEach function if you want to use it later
const originalForEach = Array.prototype.forEach;

// Define the custom forEach function
Array.prototype.forEach  = function(callback){
    
    const length = this.length;
    for(let i=0; i<length; i++){
        callback(this[i], i, this);
    }
};

// Example usage:
const arr = [1, 2, 3];
arr.forEach((element, index, array) => {
    console.log(`Element at index ${index} is ${element}`);
});