import React, { useState } from 'react';
import Header from './components/Header';

import "./App.css";
import backgroundImage from "./assets/background.jpg"

export default function App(){
    const [projects, setProjects] = useState(["React", "Front End"]);

    function handleAddProject(){
        setProjects([...projects, `Novo projeto ${Date.now()}`]);
        console.log(projects);
    }
    
    return (
        <>
            <Header title="Projects" >
                <img width={300} src={backgroundImage} />

                <ul>
                    {projects.map(project => <li key={project}>{project}</li>)}
                </ul>

                <button type="button" onClick={handleAddProject}>Adicionar projeto</button>
            </Header>
        </>
    );
};