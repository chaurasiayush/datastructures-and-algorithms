const http = require('http');

const server = http.createServer((req, res) => {
    console.log(req.url);
    if(req.url === '/'){
        asyncFunc(res).then(() => console.log('eee'));
        console.log('sent response...');
    }
    else {
        res.write('simpet server..');
    }
    // res.write(JSON.stringify(req));
    res.end();
});

server.listen(3030, () => {
    console.log('listening...');
})


async function asyncFunc(response) {
    return new Promise((res, rej) => {
        setTimeout(() => {
            res('ended response');
            response.end('response ended');
        }, 1000)
    });
}


function longprocess() {
    console.log('Calculation started...');
    const startTime = Date.now();
    let endTime = startTime;
    const targetDuration = 5000; // target duration in milliseconds (5 seconds)
    let result = 0;

    while ((endTime - startTime) < targetDuration) {
        for (let i = 0; i < 1e7; i++) {
            result += Math.sqrt(i);
        }
        endTime = Date.now();
    }

    console.log('Calculation ended.');
    console.log('Result:', result);
    console.log('Time taken:', (endTime - startTime) / 1000, 'seconds');
}