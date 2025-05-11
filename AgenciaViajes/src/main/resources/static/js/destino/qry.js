var id = "";

function addDestino(){
  location.href = "/add";
}

function updDestino(){
  id = document.querySelector('input[name="chkId"]:checked').value;
  if (typeof id != 'undefined'){
    location.href = "/upd/" + id;
  }
}

function delDestino(){
  id = document.querySelector('input[name="chkId"]:checked').value;
  alert(id);
  if (typeof id !== 'undefined'){
    location.href = "/del/" + id;
  }
}