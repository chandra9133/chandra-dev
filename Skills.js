const mongoose=require('mongoose');
const SkillSchema=new mongoose.Schema({
    name: String,
    java: Number,
    python: Number,
    dsa: Number,
    webdevelopment:  Number
});

module.exports=mongoose.model('Skill',SkillSchema);