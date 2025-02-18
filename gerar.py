import requests
import json
import random

BASE_URL = "http://localhost:8080"

# Criar usuários
usuarios_ids = []
for i in range(40):
    usuario = {"nome": f"Usuario {i+1}", "email": f"usuario{i+1}@email.com"}
    response = requests.post(f"{BASE_URL}/usuarios", json=usuario)
    
    if response.status_code == 201:
        user_id = response.json()["id"]
        usuarios_ids.append(user_id)
        print(f"✅ Usuário {user_id} criado")
    else:
        print(f"❌ Erro ao criar usuário {i+1}: {response.text}")

# Criar eventos
eventos_ids = []
for i in range(5):
    evento = {
        "nome": f"Evento {i+1}",
        "descricao": f"Descrição do evento {i+1}",
        "data": "2025-03-01",
        "localizacao": "Local X"
    }
    response = requests.post(f"{BASE_URL}/eventos", json=evento)
    
    if response.status_code == 201:
        evento_id = response.json()["id"]
        eventos_ids.append(evento_id)
        print(f"✅ Evento {evento_id} criado")
    else:
        print(f"❌ Erro ao criar evento {i+1}: {response.text}")

# Criar inscrições associando usuários aos eventos
for usuario_id in usuarios_ids:
    evento_id = random.choice(eventos_ids)  # Escolhe um evento aleatório
    tipo = random.choice(["ORGANIZADOR", "CONVIDADO"])

    response = requests.post(f"{BASE_URL}/inscricoes/register", params={
        "usuarioId": usuario_id,
        "eventoId": evento_id,
        "tipo": tipo
    })

    if response.status_code == 201:
        print(f"✅ Inscrição criada para usuário {usuario_id} no evento {evento_id} como {tipo}")
    else:
        print(f"❌ Erro ao criar inscrição: {response.text}")

# Salvar os IDs criados para referência no script de deletar
with open("ids_criados.json", "w") as f:
    json.dump({"usuarios": usuarios_ids, "eventos": eventos_ids}, f)

print("\n🎉 Finalizado! Usuários, eventos e inscrições foram criados com sucesso.")
