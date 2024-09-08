const express = require('express');

const app = express();
app.get('/', (req, res) => {
    res.end('hi response');
});

app.get('/about', (req, res) => {
    res.end('this is aboout paage')
})

app.listen(3030);