const form = document.getElementById('incidentForm');
const list = document.getElementById('incidentList');

form.addEventListener('submit', async (e) => {
  e.preventDefault();

  let title = document.getElementById('title').value.trim();
  let description = document.getElementById('description').value.trim();
  let priority = document.getElementById('priority').value;

  // 🟢 Regel: VPN → HIGH
  if (title.toLowerCase().includes('vpn')) {
    priority = 'HIGH';
    alert("Hinweis: VPN-Probleme werden automatisch als HIGH eingestuft!");
  }

  const data = { title, description, priority };

  await fetch('http://localhost:8080/api/incidents', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data)
  });

  form.reset();
  loadIncidents();
});

async function loadIncidents() {
  const res = await fetch('http://localhost:8080/api/incidents');
  const incidents = await res.json();
  list.innerHTML = '';

  incidents.forEach(i => {
    const tr = document.createElement('tr');
    tr.innerHTML = `
      <td>${i.id}</td>
      <td>${i.title}</td>
      <td><span class="badge ${badgeClass(i.priority)}">${i.priority}</span></td>
      <td>${i.status}</td>
      <td>
        ${statusButtons(i.id)}
      </td>
    `;
    list.appendChild(tr);
  });
}

function badgeClass(priority) {
  switch (priority) {
    case 'HIGH': return 'bg-danger';
    case 'MEDIUM': return 'bg-warning text-dark';
    default: return 'bg-secondary';
  }
}

// 🟢 NEU: Status-Änderungs-Buttons
function statusButtons(id) {
  return `
    <button onclick="updateStatus(${id}, 'IN_PROGRESS')" class="btn btn-sm btn-warning">In Progress</button>
    <button onclick="updateStatus(${id}, 'RESOLVED')" class="btn btn-sm btn-success">Resolved</button>
    <button onclick="updateStatus(${id}, 'CLOSED')" class="btn btn-sm btn-dark">Closed</button>
  `;
}

async function updateStatus(id, status) {
  await fetch(`http://localhost:8080/api/incidents/${id}/status?status=${status}`, {
    method: 'PUT'
  });
  loadIncidents();
}

loadIncidents();
