var id = "";

function addPaquete(){
  location.href = "/add";
}

function updPaquete(){
  id = document.querySelector('input[name="chkId"]:checked').value;
  if (typeof id != 'undefined'){
    location.href = "/upd/" + id;
  }
}

function delPaquete(){
  id = document.querySelector('input[name="chkId"]:checked').value;
  alert(id);
  if (typeof id !== 'undefined'){
    location.href = "/del/" + id;
  }
}