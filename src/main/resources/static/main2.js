function cadastrarJogo() {
    const name = document.getElementById('name').value;
    const genero = document.getElementById('genero').value;
    const squad = document.getElementById('squad').value;
    const integrantes = document.getElementById('integrantes').value;
    let url = document.getElementById('url').value;
    let thumbnailpath = document.getElementById('thumbnailpath').value;

    // Remover o prefixo "http://"
    url = url.replace(/^https?:\/\//, '');
    thumbnailpath = thumbnailpath.replace(/^https?:\/\//, '');

    const requestBody = {
        name,
        genero,
        squad,
        integrantes,
        url,
        thumbnailpath
    };

    fetch('http://localhost:8080/jogo/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(requestBody),
    })
        .then(response => response.json())
        .then(data => {
            alert('Jogo cadastrado com sucesso!');
            document.getElementById('cadastroForm').reset();
             location.reload();
        })
        .catch(error => {
            console.error('Erro ao cadastrar jogo:', error);
        });
}

function ListarJogos() {
    
    fetch(`http://localhost:8080/jogo`)
        .then(response => {
            if (response.status === 404) {
                return Promise.reject('Lista de Jogos não encontrada');
            }
            return response.json();
        })
        .then(data => {
            const tbodyElement = document.getElementById('jogos-tabela').querySelector('tbody');
            tbodyElement.innerHTML = '';

            // Preenche a tabela com os resultados da pesquisa
            data.forEach(finalgame => {
                const linhaFinalgame = document.createElement('tr');
                linhaFinalgame.innerHTML = `
                    <td>${finalgame.id}</td>
                    <td>${finalgame.name}</td>
                    <td>${finalgame.genero}</td>
                    <td>${finalgame.squad}</td>
                    <td>${finalgame.integrantes}</td>
                    <td>${finalgame.url}</td>
                    <td><a href="https://${finalgame.thumbnailpath}">Acesse a imagem</a></td>
                `;
                tbodyElement.appendChild(linhaFinalgame);

            });  
        })
        // Trata os Erros
        .catch(error => {
            console.error('Erro ao pesquisar funcionário:', error);
            const resultadoPesquisa = document.getElementById('resultadoPesquisa');
            resultadoPesquisa.innerHTML = 'Jopo não encontrado.';
        });

        
    }
    function excluirLivro() {
    ListarJogos();
            fetch(`http://localhost:8080/jogo/${requestBody}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ name, squad, integrantes, thumbnailpath, genero,url }),
        })
            .then(response => response.json())
            .then(data => {
                alert('jogo excluido com sucesso!');
                document.getElementById('cadastroForm').reset();                
            })
            .catch(error => {
                console.error('Erro ao Excluir jogo:', error);
            });



        }