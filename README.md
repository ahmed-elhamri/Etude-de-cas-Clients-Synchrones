# 📊 Étude comparative des clients HTTP synchrones  
### RestTemplate vs Feign vs WebClient  
### avec Eureka et Consul

## 📌 Objectif du TP
L’objectif de ce travail est de comparer trois méthodes de communication HTTP synchrone
dans une architecture microservices Spring Boot :

- **RestTemplate**
- **Feign Client**
- **WebClient**

La comparaison est réalisée avec deux mécanismes de découverte de services :
- **Eureka**
- **Consul**

Les critères étudiés sont :
- la **latence**
- le **débit**
- la **consommation CPU et mémoire**
- la **simplicité et la maintenabilité**

---

## 🧪 Environnement de test

- Tests de charge réalisés avec **Apache JMeter**
- Charges simulées :
  - 10 utilisateurs
  - 50 utilisateurs
  - 100 utilisateurs
  - 200 utilisateurs
  - 500 utilisateurs
- Métriques mesurées :
  - Temps moyen (ms)
  - P95 (ms)
  - Débit (requêtes/seconde)
  - CPU (%)
  - Mémoire (MB)

---

## 📈 Résultats de performance

### 🔹 10 utilisateurs

| Discovery | Métrique | Rest | Feign | WebClient |
|---------|---------|------|-------|-----------|
| Eureka | Temps moyen (ms) | 17 | 18 | 13 |
|        | P95 (ms) | 28 | 59 | 11 |
|        | Débit (req/s) | 0.05 | 0.19 | 1.1 |
| Consul | Temps moyen (ms) | 13 | 19 | 12 |
|        | P95 (ms) | 16 | 59 | 12 |
|        | Débit (req/s) | 1.1 | 0.02 | 1.1 |

---

### 🔹 50 utilisateurs

| Discovery | Métrique | Rest | Feign | WebClient |
|---------|---------|------|-------|-----------|
| Eureka | Temps moyen (ms) | 12 | 26 | 9 |
|        | P95 (ms) | 25 | 50 | 17 |
|        | Débit (req/s) | 0.29 | 0.4 | 5.1 |
| Consul | Temps moyen (ms) | 12 | 19 | 10 |
|        | P95 (ms) | 18 | 45 | 18 |
|        | Débit (req/s) | 5.1 | 0.07 | 5.1 |

---

### 🔹 100 utilisateurs

| Discovery | Métrique | Rest | Feign | WebClient |
|---------|---------|------|-------|-----------|
| Eureka | Temps moyen (ms) | 11 | 9 | 9 |
|        | P95 (ms) | 22 | 13 | 21 |
|        | Débit (req/s) | 0.5 | 1.8 | 10.1 |
| Consul | Temps moyen (ms) | 12 | 9 | 8 |
|        | P95 (ms) | 17 | 16 | 21 |
|        | Débit (req/s) | 10.1 | 0.18 | 10.1 |

---

### 🔹 200 utilisateurs

| Discovery | Métrique | Rest | Feign | WebClient |
|---------|---------|------|-------|-----------|
| Eureka | Temps moyen (ms) | 10 | 7 | 8 |
|        | P95 (ms) | 21 | 10 | 14 |
|        | Débit (req/s) | 1.2 | 20.1 | 20 |
| Consul | Temps moyen (ms) | 10 | 8 | 8 |
|        | P95 (ms) | 14 | 19 | 11 |
|        | Débit (req/s) | 20 | 1.16 | 20.1 |

---

### 🔹 500 utilisateurs

| Discovery | Métrique | Rest | Feign | WebClient |
|---------|---------|------|-------|-----------|
| Eureka | Temps moyen (ms) | 11 | 7 | 8 |
|        | P95 (ms) | 21 | 9 | 15 |
|        | Débit (req/s) | 1.2 | 20.1 | 20.1 |
| Consul | Temps moyen (ms) | 11 | 7 | 8 |
|        | P95 (ms) | 14 | 10 | 17 |
|        | Débit (req/s) | 20 | 1.16 | 20.1 |

---

## 💻 Consommation CPU et Mémoire

| Discovery | Client | CPU | Mémoire (MB) |
|---------|--------|-----|---------------|
| Eureka | RestTemplate | ~0% | 220 |
|        | Feign | ~0% | 198.5 |
|        | WebClient | ~0% | 180 |
| Consul | RestTemplate | ~0% | 253 |
|        | Feign | ~0% | 240 |
|        | WebClient | ~0% | 228 |

---

## 🧩 Simplicité et maintenabilité

| Critère | RestTemplate | Feign | WebClient |
|-------|--------------|-------|-----------|
| Configuration initiale | Simple | Moyenne | Moyenne à élevée |
| Lignes de code | Élevé | Faible | Moyen |
| Complexité globale | Faible | ⭐ Faible à moyenne | Élevée |

---

## 🧠 Analyse et conclusions

- **WebClient**
  - Meilleures performances globales
  - Très bon débit et faible consommation mémoire
  - Plus complexe à utiliser en mode synchrone

- **Feign**
  - Meilleur compromis performance / lisibilité
  - Très simple à maintenir
  - Bien intégré avec Eureka

- **RestTemplate**
  - Simple mais verbeux
  - Moins adapté aux architectures modernes

### 🔚 Conclusion finale
Pour une architecture microservices Spring Boot :
- ✅ **Feign** est recommandé pour les appels synchrones simples
- 🚀 **WebClient** est idéal pour des architectures modernes et performantes
- ⚠️ **RestTemplate** reste fonctionnel mais n’est plus conseillé pour les nouveaux projets

---

