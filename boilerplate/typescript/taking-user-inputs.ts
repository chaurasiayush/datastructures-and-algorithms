import readline from 'readline';

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  rl.question('Who are you? ', names: String => {
    console.log(`Hey there ${names}!`);
    rl.close();
  });
  