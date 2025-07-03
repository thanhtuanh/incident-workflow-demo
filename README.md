# 🚦 Incident Workflow Demo

Ein kleines ITSM-Demo-Projekt für den **Incident Management Workflow** nach ITIL – mit einem realistischen Beispiel aus dem IT-Support.

---

## 🎯 Szenario: VPN-Ausfall

## 🎯 Beispiel-Workflow: VPN-Ausfall

1. Incident wird erstellt → Status: **OPEN**  
2. 1st-Level-Support prüft VPN-Logs und Netzwerk-Monitoring → Status: **IN_PROGRESS**  
3. VPN-Dienst wird neugestartet, Zugang erfolgreich getestet → Status: **RESOLVED**  
4. User bestätigt die Lösung → Ticket wird endgültig abgeschlossen → Status: **CLOSED**


**Workflow:**
1. Ticket wird erstellt → Status: OPEN
2. IT prüft VPN-Logs → Status: IN_PROGRESS
3. Service wird neugestartet → Test erfolgreich → Status: RESOLVED
4. Nach Rückmeldung → Ticket geschlossen → Status: CLOSED

---

## ⚙️ Tech-Stack

- Spring Boot (Java)
- PostgreSQL
- Docker Compose
- Frontend: Bootstrap + Vanilla JS
- NGINX für statisches Hosting
- GitHub Actions für CI/CD

---

## ✅ Funktionen

- Neues Ticket anlegen mit Titel, Beschreibung, Priorität
- Automatischer Status „OPEN“
- API-Integration für Create & Read
- Tabelle mit farbigen Badges für Priorität
- Automatisierte Tests (`IncidentControllerTest` mit MockMvc)
- Manuelle Tests per Bash-Skript (`manual_tests.sh`)
- Spezifische Workflows & Abfragen im Frontend mit JavaScript

---

## 📦 Deployment

```bash
mvn clean package
docker-compose up
