const mongoose=require('mongoose');

const CompanySchema=new mongoose.Schema({
    name: String,
    role: String,
    requiredSkills: {
        java: Number,
        python: Number,
        webdevelopement: Number
    }
});

module.exports=mongoose.model('Company',CompanySchema);