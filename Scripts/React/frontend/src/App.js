import React, { useState, useEffect } from 'react';
import api from './services/api';

import "./App.css";

import Header from './components/Header';

export default function App(){
    const [projects, setProjects] = useState([]);

    useEffect(() => {
        api.get("projects").then(response => {
            setProjects(response.data);
        });
    }, []);

    async function handleAddProject(){
        const response = await api.post("projects", {
            title: `Novo projeto ${Date.now()}`,
            owner: "Victor"
        });

        const project = response.data;
        
        setProjects([...projects, project]);
    }

    function handleRemoveProject(id){
        api.delete(`projects/${id}`)

        const projectFiltred = projects.filter(project => project.id !== id);
        
        setProjects([...projectFiltred]);
    }
    
    return (
        <>
            <Header title="Projects" >
                
                <ul>
                    {projects.map(project => <li key={project.id}>{project.title}</li>)}
                </ul>

                <button type="button" onClick={handleAddProject}>Adicionar projeto</button>
                <button type="button" onClick={() => handleRemoveProject(projects[projects.length - 1].id)}>Remover projeto</button>
            </Header>
        </>
    );
};