require('dotenv').config();
const express=require('express');
const cors=require('cors');
const connectDB=require('./config/db');
const recommendRoute=require('./routes/recommend');

const app=express();
app.use(cors());
app.use(express.json());

connectDB();
app.use('/api/recommend',recommendRoute());


app.get('/', (req,res)=>{
    res.send('Backend is running!');
});

app.listen(5000,()=>{
    console.log('server running at http://localhost:5000');
});


