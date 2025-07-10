const mongoose=require('mongoose');
const connectDB=async()=>{
    await mongoose.log(process.env.MONGO_URI);
    console.log('MongoBD connected');
};
module.exports=connectDB;