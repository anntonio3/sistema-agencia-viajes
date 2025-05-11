var id = "";

function addReserva(){
  location.href = "/add";
}

function updReserva(){
  id = document.querySelector('input[name="chkId"]:checked').value;
  if (typeof id != 'undefined'){
    location.href = "/upd/" + id;
  }
}

function delReserva(){
  id = document.querySelector('input[name="chkId"]:checked').value;
  alert(id);
  if (typeof id !== 'undefined'){
    location.href = "/del/" + id;
  }
}