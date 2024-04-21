
const size = 3;
const defaultValue = 0;

// creating one dimentional array
const oneDimentionalArray = [];
console.log('one dimentional array: ', oneDimentionalArray);

// one dimentional array with size 3
const oneDimentionalArrayWithSize = Array(size);
console.log('one dimentional array with size 3: ', oneDimentionalArrayWithSize);

// one dimentional array with known values
const oneDimentionalArrayWithKnownValues = [1, 2, 3, 4, 5, 6, 7, 8, 9];
console.log('one dimentional array with known values: ', oneDimentionalArrayWithKnownValues);

// one dimentional array with size and default value
const oneDimentionalArrayWithSizeAndDefaultValue = Array(size).fill(defaultValue);
console.log('one dimentional array with size and default value: ', oneDimentionalArrayWithSizeAndDefaultValue);

// two dimentioanl array 
const twoDimetionalArray = [[]];
console.log('two dimentioanl array: ', twoDimetionalArray);

// two dimentional array with size x size
const twoDimetionalArrayWithSize = Array(size).fill(null).map(() => Array(size));
console.log('two dimentional array with size x size: ', twoDimetionalArrayWithSize);

// two dimentional array with known values
const twoDimetionalArrayWithKnownValues = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
console.log('two dimentional array with known values: ', twoDimetionalArrayWithKnownValues);

// two dimentional array with size 3x3 and default value as 0
const twoDimetionalArrayWithDefaultValues = Array(size).fill(null).map(() => Array(size).fill(defaultValue));
console.log('two dimentional array with size 3x3 and default value as 0: ', twoDimetionalArrayWithDefaultValues);

