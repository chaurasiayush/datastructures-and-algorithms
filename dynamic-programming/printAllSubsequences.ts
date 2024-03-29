
function printAllSubsequences(){
    const s = "abc";
    const n = s.length;

    function solveRecursive(i: number, s: string): string[] {
        if(i==0) return [""];
    
        let s1 = solveRecursive(i-1, s);
        let s2 = s1.map(str => str + s[i-1]);
    
        return [...s1, ...s2];
    }

    function solveRecursive2(i: number, s:string, p:string) {
        if(i==0) {
            console.log(p);
            return;
        }
        solveRecursive2(i-1, s, s[i-1]+p);
        solveRecursive2(i-1, s, p);
    }
    
    function solveIterative(n: number, s: string) {
        const arr = [''];
        for(let i=0; i<n; i++) {
            for(let j=1+1; j<n; j++){
    
            }
        }
    }
    
    // const ans = solveRecursive(n, s);
    // console.log('ans:', ans);

    solveRecursive2(n, s, '');
};

printAllSubsequences();