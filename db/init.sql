-- Inserir 100 usuários fictícios com nomes reais e e-mails únicos
-- Criar tabela de usuários
CREATE TABLE IF NOT EXISTS usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

-- Criar tabela de eventos
CREATE TABLE IF NOT EXISTS evento (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    data DATE NOT NULL,
    localizacao VARCHAR(255)
);

-- Criar tabela de inscrições
CREATE TABLE IF NOT EXISTS inscricoes (
    id SERIAL PRIMARY KEY,
    usuario_id INT REFERENCES usuario(id) ON DELETE CASCADE,
    evento_id INT REFERENCES evento(id) ON DELETE CASCADE,
    tipo_inscricao VARCHAR(20) CHECK (tipo_inscricao IN ('ORGANIZADOR', 'CONVIDADO'))
);

-- Criar Usuários
INSERT INTO usuario (nome, email) VALUES
    ('Ada Lovelace', 'ada_lovelace0@genius.com'),
    ('Nikola Tesla', 'nikola_tesla1@genius.com'),
    ('Marie Curie', 'marie_curie2@genius.com'),
    ('Leonardo da Vinci', 'leonardo_da_vinci3@genius.com'),
    ('Alan Turing', 'alan_turing4@genius.com'),
    ('Frida Kahlo', 'frida_kahlo5@genius.com'),
    ('Stephen Hawking', 'stephen_hawking6@genius.com'),
    ('Jane Goodall', 'jane_goodall7@genius.com'),
    ('Pablo Picasso', 'pablo_picasso8@genius.com'),
    ('Grace Hopper', 'grace_hopper9@genius.com'),
    ('Albert Einstein', 'albert_einstein10@genius.com'),
    ('Vincent van Gogh', 'vincent_van_gogh11@genius.com'),
    ('Rosalind Franklin', 'rosalind_franklin12@genius.com'),
    ('Galileu Galilei', 'galileu_galilei13@genius.com'),
    ('Amelia Earhart', 'amelia_earhart14@genius.com'),
    ('Wolfgang Mozart', 'wolfgang_mozart15@genius.com'),
    ('Charles Darwin', 'charles_darwin16@genius.com'),
    ('Claude Monet', 'claude_monet17@genius.com'),
    ('Isaac Newton', 'isaac_newton18@genius.com'),
    ('Maya Angelou', 'maya_angelou19@genius.com'),
    ('Nelson Mandela', 'nelson_mandela20@genius.com'),
    ('Michelangelo', 'michelangelo21@genius.com'),
    ('Sigmund Freud', 'sigmund_freud22@genius.com'),
    ('Virginia Woolf', 'virginia_woolf23@genius.com'),
    ('Steve Jobs', 'steve_jobs24@genius.com'),
    ('Marie Antoinette', 'marie_antoinette25@genius.com'),
    ('William Shakespeare', 'william_shakespeare26@genius.com'),
    ('Coco Chanel', 'coco_chanel27@genius.com'),
    ('Bruce Lee', 'bruce_lee28@genius.com'),
    ('Malala Yousafzai', 'malala_yousafzai29@genius.com'),
    ('Neil Armstrong', 'neil_armstrong30@genius.com'),
    ('J.K. Rowling', 'jk_rowling31@genius.com'),
    ('Elon Musk', 'elon_musk32@genius.com'),
    ('Serena Williams', 'serena_williams33@genius.com'),
    ('Banksy', 'banksy34@genius.com'),
    ('Lionel Messi', 'lionel_messi35@genius.com'),
    ('Beyoncé Knowles', 'beyonce_knowles36@genius.com'),
    ('Usain Bolt', 'usain_bolt37@genius.com'),
    ('Dwayne Johnson', 'dwayne_johnson38@genius.com'),
    ('Greta Thunberg', 'greta_thunberg39@genius.com'),
    ('Tim Berners-Lee', 'tim_berners_lee40@genius.com'),
    ('Mark Zuckerberg', 'mark_zuckerberg41@genius.com'),
    ('Satya Nadella', 'satya_nadella42@genius.com'),
    ('Linus Torvalds', 'linus_torvalds43@genius.com'),
    ('Sundar Pichai', 'sundar_pichai44@genius.com'),
    ('Stephen King', 'stephen_king45@genius.com'),
    ('Agatha Christie', 'agatha_christie46@genius.com'),
    ('J.R.R. Tolkien', 'jrr_tolkien47@genius.com'),
    ('George R.R. Martin', 'george_rr_martin48@genius.com'),
    ('Margaret Atwood', 'margaret_atwood49@genius.com');

-- Criar Eventos
INSERT INTO evento (nome, descricao, data, localizacao) VALUES
    ('Festival de Jazz no Parque', 'Evento exclusivo: Festival de Jazz no Parque', '2025-05-15', 'Rio de Janeiro - Brasil'),
    ('Conferência de Inteligência Artificial', 'Evento exclusivo: Conferência de Inteligência Artificial', '2025-05-15', 'São Paulo - Brasil'),
    ('Feira de Arte Moderna', 'Evento exclusivo: Feira de Arte Moderna', '2025-05-15', 'Rio de Janeiro - Brasil'),
    ('Maratona de Programação 24h', 'Evento exclusivo: Maratona de Programação 24h', '2025-05-15', 'Rio de Janeiro - Brasil'),
    ('Exposição de Sustentabilidade Global', 'Evento exclusivo: Exposição de Sustentabilidade Global', '2025-05-15', 'Rio de Janeiro - Brasil');

-- Criar Inscrições (250 inscrições no total)
-- Criar Inscrições (250 inscrições no total)
INSERT INTO inscricoes (usuario_id, evento_id, tipo_inscricao)
SELECT 
    u.id AS usuario_id,
    e.id AS evento_id,
    CASE 
        WHEN RANDOM() < 0.15 THEN 'ORGANIZADOR'  -- 15% chance de ser organizador
        ELSE 'CONVIDADO'  -- 85% chance de ser convidado
    END AS tipo_inscricao
FROM usuario u
JOIN evento e ON RANDOM() < (0.3 + RANDOM() * 0.7) -- Define uma chance aleatória para cada evento ter mais ou menos usuários
ORDER BY RANDOM(); -- Embaralha as inscrições para evitar padrões





