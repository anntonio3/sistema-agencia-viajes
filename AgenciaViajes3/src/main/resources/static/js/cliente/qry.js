var id = "";

function addCliente(){
  location.href = "/add";
}

function updCliente(){
  id = document.querySelector('input[name="chkId"]:checked').value;
  if (typeof id != 'undefined'){
    location.href = "/upd/" + id;
  }
}

function delCliente(){
  id = document.querySelector('input[name="chkId"]:checked').value;
  alert(id);
  if (typeof id !== 'undefined'){
    location.href = "/del/" + id;
  }
}