const express=require('express');
const router=express.Router();

const Skill=require('../models/Skills');
const company=reqiure('../models/companies');

router.post('/',async(req,res)=>{
    const user=req.body;
    await Skill.create(user);

    const companies=await company.find({});
    const recommendations=companies.filter(c=> Object.entries(c.requiredSkills).every(([Skill,min])=>user[skill]>=min));
res.json({recommend:recommendations});
});

module.exports=router;