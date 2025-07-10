const form=document.getElementById('skill-form');

form.onsubmit=async(e)=>{
    e.preventDefault();

    const data=Object.fromEntries(new FormData(form).entries());

    const response=await fetch('https://localhost:5000/api/recommend',{
        method: 'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify(data)
    });

    const result=await response.json();
    const resultDiv=document.getElementById('result');
    
    resultDiv.innerHTML=result.recommended.length?result.recommended.map(c=> <p><strong>$(c.name)</strong> - ${c.role}</p>).join(''):"<p>No matching companies found.</p>";
};