-- Criar a tabela usuario
CREATE TABLE IF NOT EXISTS usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

-- Criar a tabela evento
CREATE TABLE IF NOT EXISTS evento (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    data DATE NOT NULL,
    localizacao VARCHAR(255) NOT NULL
);

-- Criar a tabela inscricao
CREATE TABLE IF NOT EXISTS inscricao (
    id SERIAL PRIMARY KEY,
    usuario_id INT NOT NULL,
    evento_id INT NOT NULL,
    tipo_inscricao VARCHAR(20) NOT NULL CHECK (tipo_inscricao IN ('ORGANIZADOR', 'CONVIDADO')),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (evento_id) REFERENCES evento(id) ON DELETE CASCADE
);

-- Inserir 100 usuários fictícios com nomes reais e e-mails únicos
INSERT INTO usuario (nome, email) VALUES
    ('Ada Lovelace', 'ada.lovelace@tech.com'),
    ('Nikola Tesla', 'nikola.tesla@energy.org'),
    ('Marie Curie', 'marie.curie@science.com'),
    ('Leonardo da Vinci', 'leonardo.davinci@renaissance.it'),
    ('Alan Turing', 'alan.turing@ai.com'),
    ('Galileo Galilei', 'galileo.galilei@astronomy.net'),
    ('Elon Musk', 'elon.musk@spacex.com'),
    ('Steve Jobs', 'steve.jobs@apple.com'),
    ('Bill Gates', 'bill.gates@microsoft.com'),
    ('Mark Zuckerberg', 'mark.zuck@meta.com'),
    ('Johann Bach', 'johann.bach@music.com'),
    ('Frida Kahlo', 'frida.kahlo@art.mx'),
    ('Isaac Newton', 'isaac.newton@gravity.net'),
    ('Albert Einstein', 'albert.einstein@relativity.com'),
    ('Cleópatra', 'cleopatra@egyptian.gov'),
    ('Napoleão Bonaparte', 'napoleao.bonaparte@france.fr'),
    ('Cristiano Ronaldo', 'cr7@futebol.pt'),
    ('Messi', 'messi@futebol.ar'),
    ('Beethoven', 'beethoven@music.com'),
    ('Vincent van Gogh', 'vincent@art.nl');

-- Gerar mais 80 usuários fictícios (nomes aleatórios)
INSERT INTO usuario (nome, email)
SELECT 
    'Usuário ' || i,
    'user' || i || '@email.com'
FROM generate_series(21, 100) i;

-- Inserir 20 eventos criativos
INSERT INTO evento (nome, descricao, data, localizacao) VALUES
    ('Hackathon de IA', 'Competição para programadores criarem soluções inovadoras usando inteligência artificial.', '2025-03-10', 'São Paulo, Brasil'),
    ('Fórum de Energia Sustentável', 'Discussão sobre fontes renováveis de energia e inovação tecnológica.', '2025-04-15', 'Berlim, Alemanha'),
    ('Conferência de Futurologia', 'Palestras sobre o futuro da tecnologia e impacto social.', '2025-05-20', 'Tóquio, Japão'),
    ('Festival de Arte Digital', 'Exploração de novas mídias na arte digital.', '2025-06-05', 'Nova York, EUA'),
    ('Encontro Mundial de Astronomia', 'Observação de estrelas e palestras sobre exoplanetas.', '2025-07-12', 'Santiago, Chile'),
    ('Congresso de Matemática Aplicada', 'Discussão sobre novas abordagens matemáticas em IA.', '2025-08-01', 'Paris, França'),
    ('Feira de Startups', 'Exposição de startups inovadoras e investidores.', '2025-09-15', 'Londres, Reino Unido'),
    ('Simulação de Marte', 'Experiência imersiva sobre colonização espacial.', '2025-10-10', 'Houston, EUA'),
    ('Conferência de Música Clássica', 'Apresentações e workshops sobre composição e história da música.', '2025-11-05', 'Viena, Áustria'),
    ('Palestra: A Arte da Guerra', 'Discussão sobre táticas militares e estratégia política.', '2025-12-01', 'Pequim, China'),
    ('Torneio Mundial de Xadrez', 'Os melhores jogadores do mundo competem.', '2026-01-20', 'Moscou, Rússia'),
    ('Maratona de Robótica', 'Competição de robôs autônomos.', '2026-02-18', 'Seul, Coreia do Sul'),
    ('Exposição Leonardo da Vinci', 'Análise das invenções de Da Vinci.', '2026-03-25', 'Florença, Itália'),
    ('Simpósio de Neurociência', 'Descobertas recentes sobre o cérebro humano.', '2026-04-30', 'Toronto, Canadá'),
    ('Conferência Blockchain e Criptomoedas', 'Debate sobre o futuro das criptomoedas.', '2026-05-15', 'Zurique, Suíça'),
    ('Festival de Cinema Indie', 'Exibição de filmes independentes e debates.', '2026-06-20', 'Los Angeles, EUA'),
    ('Conferência de Engenharia Aeroespacial', 'Exploração de novas tecnologias para aviação.', '2026-07-10', 'Sidney, Austrália'),
    ('Cúpula Mundial da Saúde', 'Debate sobre pandemias e avanços médicos.', '2026-08-05', 'Genebra, Suíça'),
    ('Workshop de Escrita Criativa', 'Aulas e mentorias para escritores.', '2026-09-12', 'Dublin, Irlanda');

-- Inscrever usuários aleatoriamente em eventos (como ORGANIZADOR ou CONVIDADO)
INSERT INTO inscricao (usuario_id, evento_id, tipo_inscricao)
SELECT 
    u.id,
    e.id,
    CASE WHEN random() > 0.7 THEN 'ORGANIZADOR' ELSE 'CONVIDADO' END
FROM 
    usuario u
JOIN 
    (SELECT id FROM evento ORDER BY random() LIMIT 10) e -- Cada usuário participa de até 10 eventos
ON random() > 0.3; -- 70% de chance de cada usuário se inscrever em um evento
