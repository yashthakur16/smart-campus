document.addEventListener("DOMContentLoaded", function () {
    const generateBtn = document.getElementById("generate-btn");
    const skillsInput = document.getElementById("skills");
    const experienceInput = document.getElementById("experience");
    const latexOutput = document.getElementById("latex-output");
  
    // Function to generate the LaTeX resume
    const generateResume = () => {
      const skills = skillsInput.value.split(",").map(skill => `\\item ${skill.trim()}`).join("\n");
      const jobExperience = experienceInput.value.split(",").map(exp => `\\item ${exp.trim()}`).join("\n");
  
      const latexTemplate = `
  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
  % LaTeX Template: Curriculum Vitae
  %
  % Source: http://www.howtotex.com/
  % Feel free to distribute this template, but please keep the
  % referal to HowToTeX.com.
  % Date: July 2011
  %
  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
  
  \\documentclass[paper=a4,fontsize=11pt]{scrartcl}
  
  \\usepackage[english]{babel}
  \\usepackage[utf8x]{inputenc}
  \\usepackage[protrusion=true,expansion=true]{microtype}
  \\usepackage{amsmath,amsfonts,amsthm}
  \\usepackage{graphicx}
  \\usepackage[svgnames]{xcolor}
  \\usepackage[margin=0.5in]{geometry}
  \\textheight=700px
  \\usepackage{url}
  
  \\usepackage{kpfonts}
  \\newcommand*\\Hs{\\ensuremath{\\color{red}\\varheartsuit}}
  
  \\begin{document}
  
  \\NameEmailPhoneSiteGithub{Jane Doe}{+1 (123) 456 7898}{jane.doe@gmail.com}{\\href{https://www.janedoe.xyz}{janedoe.xyz}}{\\href{https://github.com/jane}{github.com/jane}}
  
  \\sepspace
  
  \\NewPart{Skills}{}
  \\begin{itemize}
  ${skills}
  \\end{itemize}
  
  \\NewPart{Job Experience}{}
  \\begin{itemize}
  ${jobExperience}
  \\end{itemize}
  
  \\end{document}
      `;
  
      latexOutput.textContent = latexTemplate;
    };
  
    // Add event listener to the button
    generateBtn.addEventListener("click", generateResume);
  });
  