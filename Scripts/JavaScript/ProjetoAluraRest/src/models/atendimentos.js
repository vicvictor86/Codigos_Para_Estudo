const Database = require("../db/config");

function queryParaAlterarMaisDeUmCampo(camposParaAlterar, valores){
    let fraseinteira = "";

    camposParaAlterar.forEach(campo => {
        const ehString = typeof valores[campo] === "string" ? true : false;
        const ehOId = campo == "id" ? true : false;

        if(ehOId){
            return;
        }

        if(ehString){
            valores[campo] = `"${valores[campo]}"`;
        }

        fraseinteira += `${campo} = ${valores[campo]}, `;
    })

    return fraseinteira.substring(0, fraseinteira.lastIndexOf(","));
}

module.exports = {
    async adiciona(novoAtendimento, res){
        const db = await Database();

        const clienteEhValido = novoAtendimento.cliente.length >= 5;

        const validacoes = [
            { 
                nome: "cliente", 
                valido: clienteEhValido, 
                mensagem: "Cliente deve ter pelo menos cinco caracteres"
            }
        ]

        const erros = validacoes.filter(campo => !campo.valido)
        const existemErros = erros.length;

        if(existemErros){
            res.status(400).json(erros);
            return false;
        }else{
            db.run(`INSERT INTO atendimentos (
                cliente,
                pet,
                servico,
                status,
                observacoes
            ) VALUES (
                "${novoAtendimento.cliente}",
                "${novoAtendimento.pet}",
                "${novoAtendimento.servico}",
                "${novoAtendimento.status}",
                "${novoAtendimento.observacoes}"
            )
            `);
        }

        await db.close();
        return true;
    },

    async lista(res){
        const db = await Database();

        const atendimentos = await db.all(`SELECT * FROM atendimentos`); 

        res.status(200).json(atendimentos);

        await db.close();
    },

    async buscaPorId(id, res){
        const db = await Database();

        const atendimento = await db.get(`SELECT * FROM atendimentos WHERE id = ${id}`);

        const erro = {
            "erro": "error"
        };

        if(atendimento){
            res.status(200).json(atendimento);
        }else{
            res.status(404).json(erro);
        }

        await db.close();
    },

    async altera(id, valores, res){
        const db = await Database();

        const camposParaAlterar = Object.keys(valores);
        
        let fraseinteira = "";
        
        fraseinteira = queryParaAlterarMaisDeUmCampo(camposParaAlterar, valores);

        const query = `UPDATE atendimentos SET ${fraseinteira} WHERE id = ${id}`;
        await db.run(query);

        await db.close();
        res.status(200).json({ "status": "alteração feita com sucesso"});
    },

    async deleta(id, res){
        const db = await Database();

        db.run(`DELETE FROM atendimentos WHERE id = ${id}`);

        res.status(200).json({"status": "deletado com sucesso"})

        await db.close();
    }
}