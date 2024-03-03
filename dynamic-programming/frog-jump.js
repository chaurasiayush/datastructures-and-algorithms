// A frog can be jumped one stair or two stair, you are given energy levels required for jumping. 
// The energy reqquired for frog to jump is absolute difference between energy levels of two stairs. 
// Find a path which requires minimum energy to jump,


const solve = () => {
    const stairs = [30, 10, 60, 10, 60, 50];
    const n = stairs.length;

    function minimumEnergy(i) {
        if(i == n-1) return 0;
        let right = 999999;

        const left = Math.abs(stairs[i+1] - stairs[i]) + minimumEnergy(i+1);
        if(i < n-2) right = Math.abs(stairs[i+2] - stairs[i]) + minimumEnergy(i+2);

        // console.log(left, right)
        return Math.min(left, right);
    }

    console.log("ans", minimumEnergy(0));
}

solve();    