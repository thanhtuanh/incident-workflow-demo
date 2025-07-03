#!/bin/bash

echo "🚦 Incident Workflow Demo – Manuelle Tests"

API_URL="http://localhost:8080/api/incidents"

echo "----------------------------------------"
echo "1) Create VPN Incident"
curl -s -X POST $API_URL \
  -H "Content-Type: application/json" \
  -d '{"title":"VPN-Ausfall Abteilung XY","description":"Kein VPN seit 09:00 Uhr","priority":"LOW"}'
echo ""

echo "----------------------------------------"
echo "2) Create Drucker Incident"
curl -s -X POST $API_URL \
  -H "Content-Type: application/json" \
  -d '{"title":"Drucker druckt nicht","description":"Papierstau","priority":"LOW"}'
echo ""

echo "----------------------------------------"
echo "3) Get all Incidents"
curl -s $API_URL | jq .
echo ""

echo "----------------------------------------"
echo "4) Set ID 1 to IN_PROGRESS"
curl -s -X PUT "$API_URL/1/status?status=IN_PROGRESS"
echo ""

echo "5) Set ID 1 to RESOLVED"
curl -s -X PUT "$API_URL/1/status?status=RESOLVED"
echo ""

echo "6) Set ID 1 to CLOSED"
curl -s -X PUT "$API_URL/1/status?status=CLOSED"
echo ""

echo "✅ Manuelle Tests abgeschlossen!"
