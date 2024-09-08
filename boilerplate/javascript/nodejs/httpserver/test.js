const { resolve } = require("path");

async function longprocess() {
    return new Promise((res, rej) => {
        setTimeout(() => {
            res(200)
            console.log('resolved');
        }, 1000);
    });
    // console.log('Calculation started...');
    // const startTime = Date.now();
    // let endTime = startTime;
    // const targetDuration = 5000; // target duration in milliseconds (5 seconds)
    // let result = 0;

    // while ((endTime - startTime) < targetDuration) {
    //     for (let i = 0; i < 1e7; i++) {
    //         result += Math.sqrt(i);
    //     }
    //     endTime = Date.now();
    // }

    // console.log('Calculation ended.');
    // console.log('Result:', result);
    // console.log('Time taken:', (endTime - startTime) / 1000, 'seconds');
}

console.log('starting calsulations');
longprocess();
console.log('process ended...')